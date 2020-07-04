package tw.tedu.stock.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.stock.entity.Order;
import tw.tedu.stock.service.exception.ServiceException;
import tw.tedu.stock.vo.OrderVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTestCase {
	
	@Autowired
	private IOrderService orderService;
	
	@Test
	public void createOrder(){
		try {
			Integer uid = 1;
			String username = "test";
			Integer goodsId = 1;
			Integer count = 5;
			Integer buySell = 0;
			Order order = orderService.createOrder(uid, username, goodsId, count, buySell);
			System.err.println(order);
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void changeStatus(){
		try {
			Integer uid = 4;
			Integer id = 15;
			Integer status = 2;
			orderService.changeStatus(uid, id, status);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void getById(){
		try {
			Integer id = 18;
			OrderVO order = orderService.getById(id);
			System.err.println(order);
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void getByUid(){
		try {
			Integer uid = 4;
			List<OrderVO> order = orderService.getByUid(uid);
			System.err.println("BEGIN:");
			for (OrderVO orderVO : order) {
				System.err.println(orderVO);
			}
			System.err.println("END.");
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
}
