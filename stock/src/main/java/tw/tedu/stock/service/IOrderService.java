package tw.tedu.stock.service;

import java.util.List;

import tw.tedu.stock.entity.Order;
import tw.tedu.stock.service.exception.AccessDeniedException;
import tw.tedu.stock.service.exception.InsertException;
import tw.tedu.stock.service.exception.UpdateException;
import tw.tedu.stock.vo.OrderVO;

/**
 * 訂單與訂單商品的業務層接口
 */
public interface IOrderService {
	
	/**
	 * 創建訂單
	 * @param uid 當前登入的用戶id
	 * @param username 當前登入的用戶名
	 * @return 成功創建的訂單數據
	 * @throws InsertException
	 */
	Order createOrder(Integer uid, String username, Integer goodsId, Integer count, Integer buySell)throws InsertException;
	
	/**
	 * 根據訂單id變更訂單狀態
	 * @param id 訂單id
	 * @param status 訂單狀態:0-未支付,1-已支付,2-已取消
	 */
	void changeStatus(Integer uid, Integer id, Integer status)throws UpdateException, AccessDeniedException;
	
	/**
	 * 根據訂單id獲取數據
	 * @param id 訂單id
	 * @return 訂單數據
	 */
	OrderVO getById(Integer id);
	
	/**
	 * 根據用戶id獲取訂單數據列表
	 * @param uid 用戶id
	 * @return 該用戶訂單數據列表
	 */
	List<OrderVO> getByUid(Integer uid);
	
}
