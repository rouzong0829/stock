package tw.tedu.stock.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.stock.service.exception.ServiceException;
import tw.tedu.stock.vo.IndexGoodsVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsServiceTestCase {
	
	@Autowired
	private IGoodsService goodsService;
	
	@Test
	public void getByVolume(){
		try {
			Integer count = 3;
			Integer desc = 1;
			List<IndexGoodsVO> list = goodsService.getByVolume(count, desc);
			System.err.println("BEGIN:");
			for (IndexGoodsVO indexGoodsVO : list) {
				System.err.println(indexGoodsVO);
			}
			System.err.println("END.");
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void getByCode(){
		try {
			Integer desc = 0;
			List<IndexGoodsVO> list = goodsService.getByCode(desc);
			System.err.println("BEGIN:");
			for (IndexGoodsVO indexGoodsVO : list) {
				System.err.println(indexGoodsVO);
			}
			System.err.println("END.");
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
	@Test
	public void getById(){
		try {
			Integer id = 1;
			IndexGoodsVO goods = goodsService.getById(id);
			System.err.println("goods:" + goods);
		} catch (ServiceException e) {
			System.err.println("錯誤類型:" + e.getClass().getName());
			System.err.println("錯誤描述:" + e.getMessage());
		}
	}
	
}
