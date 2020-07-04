package tw.tedu.stock.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.stock.entity.Address;
import tw.tedu.stock.service.exception.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceTestCase {
	
	@Autowired
	private IAddressService addressService;
	
	@Test
	public void create(){
		try{
			String username = "spring";
			Address address = new Address();
			address.setUid(4);
			address.setName("test");
			address.setZip("247");
			address.setAddress("蘆洲區");
			address.setPhone("15697856");
			address.setTel("9873218965");
			address.setTag("公司");
			Address result = addressService.create(username, address);
			System.err.println("result=" + result);
		} catch (ServiceException e){
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void setDefault(){
		try{
			Integer id = 3;
			Integer uid = 4;
			addressService.setDefault(id, uid);
			System.err.println("OK.");
		} catch (ServiceException e){
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void getListByUid(){
		try{
			Integer uid = 4;
			List<Address> list = addressService.getListByUid(uid);
			System.err.println("BEGIN:");
			for (Address address : list) {
				System.err.println(address);
			}
			System.err.println("END.");
		} catch (ServiceException e){
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void delete(){
		try{
			Integer id = 1;
			Integer uid = 1;
			addressService.delete(uid, id);
			System.err.println("OK.");
		} catch (ServiceException e){
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
}
