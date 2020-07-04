package tw.tedu.stock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.stock.entity.Favorite;
import tw.tedu.stock.service.exception.ServiceException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FavoriteServiceTestCase {
	
	@Autowired
	private IFavoriteService favoriteService;
	
	@Test
	public void addToFavorite(){
		try {
			String username = "test";
			Favorite favorite = new Favorite();
			favorite.setUid(4);
			favorite.setGid(2);
			favoriteService.addToFavorite(username, favorite);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void deleteFavorite(){
		try {
			Integer uid = 4;
			Integer id = 10;
			favoriteService.deleteFavorite(uid, id);
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
}
