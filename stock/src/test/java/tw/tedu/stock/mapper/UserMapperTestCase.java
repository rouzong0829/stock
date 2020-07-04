package tw.tedu.stock.mapper;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.stock.entity.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTestCase {
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void addnew(){
		User user = new User();
		user.setUsername("spring");
		user.setPassword("123456");
		user.setSalt("test");
		Integer rows = userMapper.addnew(user);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updatePassword(){
		Date now = new Date();
		Integer uid = 1;
		String password = "1234";
		String modifiedUser = "test";
		Date modifiedTime = now;
		Integer rows = userMapper.updatePassword(uid, password, modifiedUser, modifiedTime);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateInfo(){
		User user = new User();
		Date now = new Date();
		user.setId(2);
		user.setGender(0);
		user.setPhone("123456789");
		user.setEmail("tedu.gmail");
		user.setModifiedUser("boot");
		user.setModifiedTime(now);
		Integer rows = userMapper.updateInfo(user);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateAvatar(){
		Date now = new Date();
		Integer uid = 4;
		String avatar = "/upload/123.jpg";
		String modifiedUser = "test";
		Date modifiedTime = now;
		Integer rows = userMapper.updateAvatar(uid, avatar, modifiedUser, modifiedTime );
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void findByUsername(){
		String username = "spring";
		User user = userMapper.findByUsername(username);
		System.err.println(user);
	}
	
	@Test
	public void findById(){
		Integer id = 4;
		User user = userMapper.findById(id);
		System.err.println("user=" + user);
	}
	
}
