package tw.tedu.stock.service;

import java.util.List;

import tw.tedu.stock.entity.Address;
import tw.tedu.stock.service.exception.AccessDeniedException;
import tw.tedu.stock.service.exception.AddressNotFoundException;
import tw.tedu.stock.service.exception.DataEmptyException;
import tw.tedu.stock.service.exception.DataFormatException;
import tw.tedu.stock.service.exception.DeleteException;
import tw.tedu.stock.service.exception.InsertException;
import tw.tedu.stock.service.exception.UpdateException;
import tw.tedu.stock.service.exception.UserNotFoundException;

/**
 * 處理地址的業務層接口
 */
public interface IAddressService {
	
	/**
	 * 創建地址數據
	 * @param username 當前執行人
	 * @param address 地址信息
	 * @return 受影響行數
	 * @throws InsertException
	 */
	Address create(String username, Address address)throws InsertException, DataFormatException, DataEmptyException;
	
	/**
	 * 設置默認地址
	 * @param id 將要設置為默認地址的數據id
	 * @param uid 地址歸屬的用戶id
	 * @throws UpdateException
	 * @throws AddressNotFoundException
	 * @throws AccessDeniedException
	 */
	void setDefault(Integer id, Integer uid)throws UpdateException, AddressNotFoundException, AccessDeniedException;
	
	/**
	 * 根據用戶id查詢地址數據列表
	 * @param uid 用戶id
	 * @return 地址數據列表
	 */
	List<Address> getListByUid(Integer uid);
	
	/**
	 * 根據id查詢地址數據
	 * @param id 地址id
	 * @return 地址數據，若沒有則返回null
	 */
	Address getById(Integer id);
	
	/**
	 * 根據id刪除地址數據
	 * @param uid 用戶id
	 * @param id 地址id
	 * @throws DeleteException
	 * @throws UserNotFoundException
	 * @throws AccessDeniedException
	 */
	void delete(Integer uid, Integer id) throws DeleteException, UserNotFoundException, AccessDeniedException;
	
	
}
