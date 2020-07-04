package tw.tedu.stock.mapper;

import java.util.List;

import tw.tedu.stock.entity.Address;

/**
 * 處理地址的持久層
 */
public interface AddressMapper {
	
	/**
	 * 增加新的地址
	 * @param address 地址數據
	 * @return 受影響行數
	 */
	Integer addnew(Address address);

	/**
	 * 將用戶的所有地址設為非默認
	 * @param uid 用戶id
	 * @return 受影響行數
	 */
	Integer updateNoDefault(Integer uid);
	
	/**
	 * 將指定id的地址設為默認
	 * @param id 數據id
	 * @return 受影響行數
	 */
	Integer updateDefault(Integer id);
	
	/**
	 * 根據用戶id獲取該用戶的地址數據的數量
	 * @param uid 用戶id
	 * @return 該用戶的地址數據的數量，如果沒有數據，則返回0
	 */
	Integer getCountByUid(Integer uid);
	
	/**
	 * 獲取某用戶的地址列表
	 * @param uid 用戶id
	 * @return 地址列表
	 */
	List<Address> findByUid(Integer uid);
	
	/**
	 * 根據id查詢數據地址
	 * @param id 地址id
	 * @return 匹配的地址數據，如果沒有匹配的數據，則返回null
	 */
	Address findById(Integer id);
	
	/**
	 * 根據用戶id查詢最後修改的地址數據
	 * @param uid 用戶id
	 * @return 匹配的地址數據，如果沒有匹配的數據，則返回null
	 */
	Address findLastModified(Integer uid);
	
	/**
	 * 根據id刪除地址數據
	 * @param id 地址id
	 * @return 受影響行數
	 */
	Integer deleteById(Integer id);
	
}
