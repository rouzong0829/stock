package tw.tedu.stock.service;

import tw.tedu.stock.entity.User;
import tw.tedu.stock.service.exception.DataFormatException;
import tw.tedu.stock.service.exception.DuplicateKeyException;
import tw.tedu.stock.service.exception.InsertException;
import tw.tedu.stock.service.exception.PasswordNotMatchException;
import tw.tedu.stock.service.exception.UpdateException;
import tw.tedu.stock.service.exception.UserNotFoundException;

/**
 * 處理用戶數據的業務層接口
 */
public interface IUserService {
	
	/**
	 * 用戶註冊
	 * @param user 用戶的註冊信息
	 * @return 成功註冊的用戶數據
	 * @throws DuplicateKeyException
	 * @throws InsertException
	 */
	User reg(User user)throws DuplicateKeyException, InsertException;
	
	/**
	 * 用戶登入
	 * @param username 用戶名
	 * @param password 密碼
	 * @return 成功登入的用戶數據
	 * @throws UserNotFoundException
	 * @throws PasswordNotMatchException
	 */
	User login(String username, String password)throws UserNotFoundException, PasswordNotMatchException;
	
	/**
	 * 更改用戶密碼
	 * @param uid 用戶id
	 * @param oldPassword 舊密碼
	 * @param newPassowrd 新密碼
	 * @throws UserNotFoundException
	 * @throws PasswordNotMatchException
	 * @throws UpdateException
	 */
	void changePassword(Integer uid, String oldPassword, String newPassword)throws UserNotFoundException, PasswordNotMatchException, UpdateException;
	
	/**
	 * 更改用戶資料
	 * @param user 用戶資料
	 * @throws UserNotFoundException
	 * @throws UpdateException
	 */
	void changeInfo(User user)throws UserNotFoundException, UpdateException, DataFormatException;
	
	/**
	 * 更改用戶頭像
	 * @param uid 用戶id
	 * @param avatar 用戶頭像路徑
	 * @throws UserNotFoundException
	 * @throws UpdateException
	 */
	void changeAvatar(Integer uid, String avatar)throws UserNotFoundException, UpdateException;
	
	/**
	 * 根據id獲取用戶數據
	 * @param id 用戶id
	 * @return 用戶數據，若沒有則返回null
	 */
	User getById(Integer id);
	
}
