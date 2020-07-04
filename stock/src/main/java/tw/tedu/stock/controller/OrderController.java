package tw.tedu.stock.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.tedu.stock.controller.exception.CountEmptyException;
import tw.tedu.stock.controller.exception.CountException;
import tw.tedu.stock.entity.Order;
import tw.tedu.stock.service.IOrderService;
import tw.tedu.stock.util.ResponseResult;
import tw.tedu.stock.vo.OrderVO;

/**
 * 訂單的控制器類
 */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {
	
	@Autowired
	private IOrderService orderService;
	
	@RequestMapping("/create")
	public ResponseResult<Order> createOrder(HttpSession session,
			@RequestParam("goods_id")Integer goodsId,
			@RequestParam("count")Integer count,
			@RequestParam("buy_sell")Integer buySell){
		// 判斷下單數量是否為空
		if(count == null){
			throw new CountEmptyException("數量不允許為空!");
		}
		// 判斷下單數量是否 < 1
		if(count < 1){
			throw new CountException("數量錯誤!");
		}
		Integer uid = getUidFromSession(session);
		String username = session.getAttribute("username").toString();
		Order order = orderService.createOrder(uid, username, goodsId, count, buySell);
		return new ResponseResult<Order>(SUCCESS, order);
	}
	
	@GetMapping("/details/{id}")
	public ResponseResult<OrderVO> getById(@PathVariable("id")Integer id){
		OrderVO data = orderService.getById(id);
		return new ResponseResult<OrderVO>(SUCCESS, data);
	}
	
	@PostMapping("/status/{id}")
	public ResponseResult<Void> changeStatus(HttpSession session,
			@PathVariable("id")Integer id,
			@RequestParam("status")Integer status){
		Integer uid = getUidFromSession(session);
		orderService.changeStatus(uid, id, status);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@PostMapping("list")
	public ResponseResult<List<OrderVO>> getByUid(HttpSession session){
		Integer uid = getUidFromSession(session);
		List<OrderVO> list = orderService.getByUid(uid);
		return new ResponseResult<List<OrderVO>>(SUCCESS, list);
	}
	
}
