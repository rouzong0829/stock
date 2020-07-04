package tw.tedu.stock.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tw.tedu.stock.entity.Order;
import tw.tedu.stock.entity.OrderItem;
import tw.tedu.stock.mapper.GoodsMapper;
import tw.tedu.stock.mapper.OrderMapper;
import tw.tedu.stock.service.IOrderService;
import tw.tedu.stock.service.exception.AccessDeniedException;
import tw.tedu.stock.service.exception.InsertException;
import tw.tedu.stock.service.exception.UpdateException;
import tw.tedu.stock.vo.IndexGoodsVO;
import tw.tedu.stock.vo.OrderVO;

/**
 * 訂單與訂單商品的業務層實現類
 */
@Service
public class OrderServiceImpl implements IOrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	@Transactional
	public Order createOrder(Integer uid, String username, Integer goodsId, Integer count, Integer buySell) throws InsertException {
		// 創建Date對象
		Date now = new Date();
		// 查詢商品數據
		IndexGoodsVO goods = goodsMapper.findById(goodsId);
		// 創建Order對象
		Order order = new Order();
		Double doublePay = goods.getPrice() * count * 1000;
		Long pay = doublePay.longValue();
		
		order.setUid(uid);
		order.setRecvName(username);
		order.setPay(pay);
		order.setBuySell(buySell);
		order.setOrderTime(now);
		order.setStatus(0);
		order.setCreatedUser(username);
		order.setCreatedTime(now);
		order.setModifiedUser(username);
		order.setModifiedTime(now);
		
		// 插入訂單數據
		insertOrder(order);
		
		// 創建OrderItem對象
		OrderItem item = new OrderItem();
		
		item.setOid(order.getId());
		item.setGoodsId(goods.getId());
		item.setGoodsCode(goods.getCode());
		item.setGoodsStock(goods.getStock());
		item.setGoodsCount(count);
		item.setGoodsPrice(goods.getPrice());
		item.setCreatedUser(username);
		item.setCreatedTime(now);
		item.setModifiedUser(username);
		item.setModifiedTime(now);
		
		// 插入訂單商品數據
		insertOrderItem(item);
		// 返回
		return order;
	}
	
	@Override
	public void changeStatus(Integer uid, Integer id, Integer status)throws UpdateException, AccessDeniedException {
		OrderVO data = findById(id);
		if(data.getUid() != uid){
			throw new AccessDeniedException("失敗!不允許訪問此數據!");
		}
		updateStatus(id, status);
	}
	
	@Override
	public OrderVO getById(Integer id) {
		return findById(id);
	}
	
	@Override
	public List<OrderVO> getByUid(Integer uid) {
		return findByUid(uid);
	}
	
	/**
	 * 插入訂單數據
	 * @param order 訂單數據
	 */
	private void insertOrder(Order order){
		Integer rows = orderMapper.insertOrder(order);
		if(rows != 1){
			throw new InsertException("插入訂單數據時發生未知錯誤!");
		}
	}
	
	/**
	 * 插入訂單商品數據
	 * @param orderItem 訂單商品數據
	 */
	private void insertOrderItem(OrderItem orderItem){
		Integer rows = orderMapper.insertOrderItem(orderItem);
		if(rows != 1){
			throw new InsertException("插入訂單商品數據時發生未知錯誤!");
		}
	}
	
	/**
	 * 根據訂單id修改訂單狀態
	 * @param id 訂單id
	 * @param status 訂單狀態:0-未支付,1-已支付,2-已取消
	 */
	private void updateStatus(Integer id, Integer status){
		Integer rows = orderMapper.updateStatus(id, status);
		if(rows != 1){
			throw new UpdateException("修改訂單時發生未知錯誤!");
		}
	}
	
	/**
	 * 根據訂單id查詢數據
	 * @param id 訂單id
	 * @return 訂單數據
	 */
	private OrderVO findById(Integer id){
		return orderMapper.findById(id);
	}
	
	/**
	 * 根據用戶id查詢訂單數據列表
	 * @param uid 用戶id
	 * @return 該用戶訂單數據列表
	 */
	private List<OrderVO> findByUid(Integer uid){
		return orderMapper.findByUid(uid);
	}
	
}
