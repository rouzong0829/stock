package tw.tedu.stock.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import tw.tedu.stock.entity.User;

/**
 * 處理用戶數據的持久層
 */
public interface UserMapper {
	
	/**
	 * 插入用戶數據
	 * @param user 用戶數據
	 * @return 受影響行數
	 */
	Integer addnew(User user);
	
	/**
	 * 更改用戶密碼
	 * @param uid 用戶id
	 * @param password 用戶新密碼
	 * @param modifiedUser 更改數據者
	 * @param modifiedTime 更改時間
	 * @return 受影響行數
	 */
	Integer updatePassword(
			@Param("uid")Integer uid, @Param("password")String password,
			@Param("modifiedUser")String modifiedUser, @Param("modifiedTime")Date modifiedTime);
	
	/**
	 * 更改用戶資料
	 * @param user 用戶資料
	 * @return 受影響行數
	 */
	Integer updateInfo(User user);
	
	/**
	 * 更改用戶頭像
	 * @param uid 用戶id
	 * @param avatar 頭像的路徑
	 * @param modifiedUser 更改數據者
	 * @param modifiedTime 更改時間
	 * @return 受影響行數
	 */
	Integer updateAvatar(
			@Param("uid")Integer uid, @Param("avatar")String avatar,
			@Param("modifiedUser")String modifiedUser, @Param("modifiedTime")Date modifiedTime);
	
	/**
	 * 根據用戶名查詢用戶數據
	 * @param username 用戶名
	 * @return 用戶數據，若沒有匹配的數據，則返回null
	 */
	User findByUsername(String username);
	
	/**
	 * 根據id查詢用戶數據
	 * @param id 用戶id
	 * @return 用戶數據，若沒有匹配的數據，則返回null
	 */
	User findById(Integer id);
	
}
