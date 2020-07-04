package tw.tedu.stock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.stock.entity.Favorite;
import tw.tedu.stock.vo.FavoriteVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoriteMapperTestCase {
	
	@Autowired
	private FavoriteMapper favoriteMapper;
	
	@Test
	public void addnew(){
		Favorite favorite = new Favorite();
		favorite.setUid(4);
		favorite.setGid(1);
		favorite.setPrice(322.11);
		favorite.setVolume(36100L);
		Integer rows = favoriteMapper.addnew(favorite);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void deleteByUidAndGid(){
		Integer uid = 4;
		Integer gid = 2;
		Integer rows = favoriteMapper.deleteByUidAndGid(uid, gid);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void deleteByUidAndId(){
		Integer uid = 4;
		Integer id = 6;
		Integer rows = favoriteMapper.deleteByUidAndId(uid, id);
		System.err.println("rows=" + rows);
	}
	
	@Test
	public void findByUidAndGid(){
		Integer uid = 4;
		Integer gid = 1;
		Favorite favorite = favoriteMapper.findByUidAndGid(uid, gid);
		System.err.println(favorite);
	}
	
	@Test
	public void findByUidAndId(){
		Integer uid = 4;
		Integer id = 10;
		Favorite favorite = favoriteMapper.findByUidAndId(uid, id);
		System.err.println(favorite);
	}
	
	@Test
	public void findByUid(){
		Integer uid = 4;
		List<FavoriteVO> list = favoriteMapper.findByUid(uid);
		System.err.println("BEGIN:");
		for (FavoriteVO favoriteVO : list) {
			System.err.println(favoriteVO);
		}
		System.err.println("END.");
	}
	
}
