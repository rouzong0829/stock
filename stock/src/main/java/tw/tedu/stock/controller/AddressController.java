package tw.tedu.stock.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.tedu.stock.entity.Address;
import tw.tedu.stock.service.IAddressService;
import tw.tedu.stock.util.ResponseResult;

/**
 * 處理地址相關的控制器類
 */
@RestController
@RequestMapping("/address")
public class AddressController extends BaseController {
	
	@Autowired
	private IAddressService addressService;
	
	@PostMapping("/create")
	public ResponseResult<Void> handleCreate(HttpSession session, Address address){
		// 根據session獲取username與uid
		String username = session.getAttribute("username").toString();
		Integer uid = getUidFromSession(session);
		// 將uid封裝到address中
		address.setUid(uid);
		// 調用業務層執行
		addressService.create(username, address);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@RequestMapping("/list")
	public ResponseResult<List<Address>> getListByUid(HttpSession session){
		// 獲取uid
		Integer uid = getUidFromSession(session);
		// 查詢數據
		List<Address> list = addressService.getListByUid(uid);
		return new ResponseResult<List<Address>>(SUCCESS, list);
	}
	
	@GetMapping("/default/{id}")
	public ResponseResult<Void> setDefault(HttpSession session, @PathVariable("id")Integer id){
		// 獲取uid
		Integer uid = getUidFromSession(session);
		// 調用業務層執行
		addressService.setDefault(id, uid);
		return new ResponseResult<Void>(SUCCESS);
	}
	
	@GetMapping("/delete/{id}")
	public ResponseResult<Void> delete(HttpSession session, @PathVariable("id")Integer id){
		// 獲取uid
		Integer uid = getUidFromSession(session);
		// 調用業務層執行
		addressService.delete(uid, id);
		return new ResponseResult<Void>(SUCCESS);
	}
	
}
