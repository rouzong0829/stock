package tw.tedu.stock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.stock.entity.Order;
import tw.tedu.stock.entity.OrderItem;
import tw.tedu.stock.vo.OrderVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTestCase {
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Test
	public void insertOrder(){
		Order order = new Order();
		order.setUid(1);
		order.setRecvName("test");
		order.setRecvAddress("home");
		order.setPay(111L);
		Integer rows = orderMapper.insertOrder(order);
		System.err.println("rows:" + rows);
	}
	
	@Test
	public void insertOrderItem(){
		OrderItem orderItem = new OrderItem();
		orderItem.setOid(1);
		orderItem.setGoodsId(1);
		orderItem.setGoodsCode("123");
		orderItem.setGoodsStock("test");
		orderItem.setGoodsPrice(123456.0);
		Integer rows = orderMapper.insertOrderItem(orderItem);
		System.err.println("rows:" + rows);
	}
	
	@Test
	public void updateStatus(){
		Integer id = 16;
		Integer status = 1;
		Integer rows = orderMapper.updateStatus(id, status);
		System.err.println("rows:" + rows);
	}
	
	@Test
	public void findById(){
		Integer id = 10;
		OrderVO order = orderMapper.findById(id);
		System.err.println("order:" + order);
	}
	
	@Test
	public void findByUid(){
		Integer uid = 4;
		List<OrderVO> order = orderMapper.findByUid(uid);
		System.err.println("BEGIN:");
		for (OrderVO orderVO : order) {
			System.err.println(orderVO);
		}
		System.err.println("END.");
	}
	
}
