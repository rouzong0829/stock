package tw.tedu.stock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.stock.entity.User;
import tw.tedu.stock.service.exception.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTestCase {
	
	@Autowired
	private IUserService userService;
	
	@Test
	public void reg(){
		try{
			User user = new User();
			user.setUsername("eclipse");
			user.setPassword("123456");
			user.setSalt("hello");
			user.setGender(1);
			user.setPhone("123456789");
			user.setEmail("tedu.gmail");
			user.setAvatar("123");
			User result = userService.reg(user);
			System.err.println("result=" + result);
		} catch (ServiceException e){
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void login(){
		try{
			String username = "spring";
			String password = "123";
			User user = userService.login(username, password);
			System.err.println("user:" + user);
		} catch (ServiceException e){
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void changePassword(){
		try{
			Integer uid = 2;
			String oldPassword = "1234";
			String newPassowrd = "123";
			userService.changePassword(uid, oldPassword, newPassowrd);
			System.err.println("OK.");
		} catch (ServiceException e){
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void changeInfo(){
		try{
			User user = new User();
			user.setId(1);
			user.setGender(1);
			user.setPhone("987654321");
			user.setEmail("123@gmail");
			userService.changeInfo(user);
			System.err.println("OK.");
		} catch(ServiceException e){
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void changeAvatar(){
		try {
			Integer uid = 4;
			String avatar = "/upload/456.jpg";
			userService.changeAvatar(uid, avatar);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void getById(){
		try {
			Integer id = 4;
			User user = userService.getById(id);
			System.err.println(user);
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
}
