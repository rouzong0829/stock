package tw.tedu.stock.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.stock.entity.Address;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTestCase {
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Test
	public void addnew(){
		Address address = new Address();
		Date now = new Date();
		address.setUid(4);
		address.setName("spring");
		address.setZip("247");
		address.setAddress("蘆洲區");
		address.setPhone("123456789");
		address.setTel("987654321");
		address.setTag("Home");
		address.setCreatedUser("spring");
		address.setCreatedTime(now);
		address.setModifiedUser("spring");
		address.setModifiedTime(now);
		Integer rows = addressMapper.addnew(address);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateNoDefault(){
		Integer uid = 4;
		Integer rows = addressMapper.updateNoDefault(uid);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void updateDefault(){
		Integer id = 3;
		Integer rows = addressMapper.updateDefault(id);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void getCountById(){
		Integer uid = 4;
		Integer count = addressMapper.getCountByUid(uid);
		System.err.println("count=" + count);
	}
	
	@Test
	public void findByUid(){
		Integer uid = 4;
		List<Address> list = addressMapper.findByUid(uid);
		System.err.println("BEGIN:");
		for (Address address : list) {
			System.err.println(address);
		}
		System.err.println("END.");
	}
	
	@Test
	public void findById(){
		Integer id = 3;
		Address address = addressMapper.findById(id);
		System.err.println(address);
	}
	
	@Test
	public void findLastModified(){
		Integer uid = 1;
		Address address = addressMapper.findLastModified(uid);
		System.err.println(address);
	}
	
	@Test
	public void deleteById(){
		Integer id = 3;
		Integer rows = addressMapper.deleteById(id);
		System.err.println("rows=" + rows);
	}
	
}
