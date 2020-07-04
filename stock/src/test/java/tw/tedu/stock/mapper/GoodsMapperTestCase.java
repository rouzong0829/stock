package tw.tedu.stock.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tw.tedu.stock.vo.IndexGoodsVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsMapperTestCase {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Test
	public void findByVolume(){
		Integer count = 2;
		Integer desc = 0;
		List<IndexGoodsVO> list = goodsMapper.findByVolume(count, desc);
		System.err.println("BEGIN:");
		for (IndexGoodsVO indexGoodsVO : list) {
			System.err.println(indexGoodsVO);
		}
		System.err.println("END.");
	}
	
	@Test
	public void findByCode(){
		Integer desc = 0;
		List<IndexGoodsVO> list = goodsMapper.findByCode(desc);
		System.err.println("BEGIN:");
		for (IndexGoodsVO indexGoodsVO : list) {
			System.err.println(indexGoodsVO);
		}
		System.err.println("END.");
	}
	
	@Test
	public void findById(){
		Integer id = 1;
		IndexGoodsVO goods = goodsMapper.findById(id);
		System.err.println("goods:" + goods);
	}
	
}
