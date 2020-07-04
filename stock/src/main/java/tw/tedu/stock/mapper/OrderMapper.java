package tw.tedu.stock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import tw.tedu.stock.entity.Order;
import tw.tedu.stock.entity.OrderItem;
import tw.tedu.stock.vo.OrderVO;

/**
 * 訂單與訂單商品數據的持久層接口
 */
public interface OrderMapper {
	
	/**
	 * 插入訂單數據
	 * @param order 訂單數據
	 * @return 受影響行數
	 */
	Integer insertOrder(Order order);
	
	/**
	 * 插入訂單商品數據
	 * @param orderItem 訂單商品數據
	 * @return 受影響行數
	 */
	Integer insertOrderItem(OrderItem orderItem);
	
	/**
	 * 根據訂單id修改訂單狀態
	 * @param id 訂單id
	 * @param status 訂單狀態:0-未支付,1-已支付,2-已取消
	 * @return 受影響行數
	 */
	Integer updateStatus(@Param("id")Integer id, @Param("status")Integer status);
	
	/**
	 * 根據訂單id查詢數據
	 * @param id 訂單id
	 * @return 訂單數據
	 */
	OrderVO findById(Integer id);
	
	/**
	 * 根據用戶id查詢訂單數據列表
	 * @param uid 用戶id
	 * @return 該用戶訂單數據列表
	 */
	List<OrderVO> findByUid(Integer uid);
	
}
