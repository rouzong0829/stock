package tw.tedu.stock.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import tw.tedu.stock.entity.User;
import tw.tedu.stock.mapper.UserMapper;
import tw.tedu.stock.service.IUserService;
import tw.tedu.stock.service.exception.DataFormatException;
import tw.tedu.stock.service.exception.DuplicateKeyException;
import tw.tedu.stock.service.exception.InsertException;
import tw.tedu.stock.service.exception.PasswordNotMatchException;
import tw.tedu.stock.service.exception.UpdateException;
import tw.tedu.stock.service.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User reg(User user) throws DuplicateKeyException, InsertException {
		// 根據嘗試註冊的用戶名查詢用戶註冊
		User data = findByUsername(user.getUsername());
		// 判斷查詢到的數據是否為null
		if(data == null){
			// 是: 用戶名不存在，允許註冊，則處理密碼加密
			// 【補充非用戶提交的數據】
			user.setIsDelete(0);
			// 4項日誌
			Date now = new Date();
			user.setCreatedUser(user.getUsername());
			user.setCreatedTime(now);
			user.setModifiedUser(user.getUsername());
			user.setModifiedTime(now);
			// 處理密碼加密
			String salt = UUID.randomUUID().toString();
			String srcPassword = user.getPassword();
			String md5Password = getMd5Password(srcPassword, salt);
			// 將加密後的密碼與鹽值封裝在user對象中
			user.setPassword(md5Password);
			user.setSalt(salt);
			// 執行註冊
			addnew(user);
			// 返回註冊的用戶對象
			return user;
		}else{
			// 否: 用戶名已被占用，拋出DuplicateKeyException異常
			throw new DuplicateKeyException("註冊失敗!" + user.getUsername() + "已被註冊!");
		}
	}
	
	@Override
	public User login(String username, String password) throws UserNotFoundException, PasswordNotMatchException {
		// 根據參數username查詢用戶數據
		User data = findByUsername(username);
		// 判斷用戶數據是否為null
		if(data == null){
			// 是: 為null，用戶名不存在，拋出UserNotFoundException異常
			throw new UserNotFoundException("查無此用戶!");
		}
		// 否: 非null，找到用戶數據，取出鹽值
		String salt = data.getSalt();
		// 對參數password執行加密
		String md5Password = getMd5Password(password, salt);
		// 判斷密碼是否匹配
		if(md5Password.equals(data.getPassword())){
			// 是: 匹配，密碼正確，判斷是否被刪除
			if(data.getIsDelete() == 1){
				// 是: 已被刪除，拋出UserNotFoundException異常
				throw new UserNotFoundException("用戶已被刪除!");
			}else{
				// 否: 未被刪除，則登入成功，將查詢的用戶數據中的鹽值和密碼設為null
				data.setPassword(null);
				data.setSalt(null);
				return data;
			}
		}else{
			// 否: 不匹配，密碼錯誤，拋出PasswordNotMatchException異常
			throw new PasswordNotMatchException("登入失敗!密碼錯誤!");
		}
	}
	
	@Override
	public void changePassword(Integer uid, String oldPassword, String newPassword)
			throws UserNotFoundException, PasswordNotMatchException, UpdateException {
		// 根據uid查詢用戶數據
		User data = findById(uid);
		// 判斷是否為null
		if(data == null){
			// 是: 拋出UserNotFoundException異常
			throw new UserNotFoundException("查無此用戶!");
		}
		// 判斷查詢結果isDelete是否為1
		if(data.getIsDelete() == 1){
			// 是: 拋出UserNotFoundException異常
			throw new UserNotFoundException("用戶已被刪除!");
		}
		// 取出查詢結果中的鹽值
		String salt = data.getSalt();
		// 對參數oldPassword進行MD5加密
		String oldMd5Password = getMd5Password(oldPassword, salt);
		// 將加密結果與查詢結果中的password對比是否匹配
		if(oldMd5Password.equals(data.getPassword())){
			// 是: 原密碼正確，對參數newPassword執行MD5加密
			String newMd5Password = getMd5Password(newPassword, salt);
			// 獲取當前時間
			Date now = new Date();
			// 更新密碼
			updatePassword(uid, newMd5Password, data.getUsername(), now);
		}else{
			// 否: 密碼錯誤，拋出PasswordNotMatchException異常
			throw new PasswordNotMatchException("更改失敗!密碼錯誤!");
		}
	}
	
	@Override
	public void changeInfo(User user) throws UserNotFoundException, UpdateException, DataFormatException {
		// 根據user.getId()查詢用戶數據
		User data = findById(user.getId());
		// 判斷數據是否為null
		if(data == null){
			// 是: 拋出UserNotFoundException異常
			throw new UserNotFoundException("查無此用戶!");
		}
		// 判斷is_delete是否為1
		if(data.getIsDelete() == 1){
			// 是: 拋出UserNotFoundException異常
			throw new UserNotFoundException("用戶已被刪除!");
		}
		// 判斷手機號碼格式
		if(!user.getPhone().matches("\\d{4}-\\d{6}")){
			throw new DataFormatException("手機號碼格式錯誤!");
		}
		// 判斷email格式
		if(!user.getEmail().matches("^\\w{1,20}@[a-zA-Z0-9]{2,10}\\.[a-zA-Z]{2,10}(\\.[a-zA-Z]{2,10})?$")){
			throw new DataFormatException("電子信箱格式錯誤!");
		}
		// 向參數對象中封裝:
		user.setModifiedUser(data.getUsername());
		user.setModifiedTime(new Date());
		// 執行修改
		updateInfo(user);
	}
	
	@Override
	public void changeAvatar(Integer uid, String avatar) throws UserNotFoundException, UpdateException {
		// 根據uid查詢用戶數據
		User data = findById(uid);
		// 判斷數據是否為null
		if(data == null){
			throw new UserNotFoundException("查無此用戶!");
		}
		//判斷is_delete是否為1
		if(data.getIsDelete() == 1){
			throw new UserNotFoundException("用戶已被刪除!");
		}
		// 執行更改頭像
		updateAvatar(uid, avatar, data.getUsername(), new Date());
	}
	
	@Override
	public User getById(Integer id) {
		User data = findById(id);
		data.setPassword(null);
		data.setSalt(null);
		data.setIsDelete(null);
		return data;
	}
	
	/**
	 * 獲取根據MD5加密的密碼
	 * @param srcPassword 原密碼
	 * @param salt 鹽值
	 * @return 加密後的密碼
	 */
	private String getMd5Password(String srcPassword, String salt){
		// 鹽值 + 原密碼 + 鹽值
		String str = salt + srcPassword + salt;
		// 循環執行10次摘要運算
		for(int i = 0; i < 10; i ++){
			str = DigestUtils.md5DigestAsHex(str.getBytes());
		}
		// 返回摘要結果
		return str;
	}
	
	/**
	 * 插入用戶數據
	 * @param user 用戶數據
	 * @return 受影響行數
	 */
	private void addnew(User user){
		Integer rows = userMapper.addnew(user);
		if(rows != 1){
			throw new InsertException("增加用戶數據時出現未知錯誤!");
		}
	}
	
	/**
	 * 更改用戶密碼
	 * @param uid 用戶id
	 * @param password 用戶新密碼
	 * @param modifiedUser 更改數據者
	 * @param modifiedTime 更改時間
	 */
	private void updatePassword(Integer uid, String password, String modifiedUser, Date modifiedTime){
		Integer rows = userMapper.updatePassword(uid, password, modifiedUser, modifiedTime);
		if(rows != 1){
			throw new UpdateException("更改密碼時發生未知錯誤!");
		}
	}
	
	/**
	 * 更改用戶資料
	 * @param user 用戶資料
	 */
	private void updateInfo(User user){
		Integer rows = userMapper.updateInfo(user);
		if(rows != 1){
			throw new UpdateException("更改用戶資料發生未知錯誤!");
		}
	}
	
	/**
	 * 更改用戶頭像
	 * @param uid 用戶id
	 * @param avatar 頭像的路徑
	 * @param modifiedUser 更改數據者
	 * @param modifiedTime 更改時間
	 */
	private void updateAvatar(Integer uid, String avatar, String modifiedUser, Date modifiedTime){
		Integer rows = userMapper.updateAvatar(uid, avatar, modifiedUser, modifiedTime);
		if(rows != 1){
			throw new UpdateException("更改用戶頭像發生未知錯誤!");
		}
	}
	
	/**
	 * 根據用戶名查詢用戶數據
	 * @param username 用戶名
	 * @return 用戶數據，若沒有匹配的數據，則返回null
	 */
	private User findByUsername(String username){
		return userMapper.findByUsername(username);
	}
	
	/**
	 * 根據id查詢用戶數據
	 * @param id 用戶id
	 * @return 用戶數據，若沒有匹配的數據，則返回null
	 */
	private User findById(Integer id){
		return userMapper.findById(id);
	}
	
}
