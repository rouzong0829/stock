package tw.tedu.stock.vo;

import java.io.Serializable;

/**
 * 商品的Value Object類
 */
public class IndexGoodsVO implements Serializable {
	
	private static final long serialVersionUID = 2246108177661431375L;
	
	private Integer id;
	private String name;
	private String code;
	private String stock;
	private Double price;
	private Long volume;
	private String mainBusiness;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public String getMainBusiness() {
		return mainBusiness;
	}
	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
	}
	@Override
	public String toString() {
		return "IndexGoodsVO [id=" + id + ", name=" + name + ", code=" + code + ", stock=" + stock + ", price=" + price
				+ ", volume=" + volume + ", mainBusiness=" + mainBusiness + "]";
	}
	
	
}
