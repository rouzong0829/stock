package tw.tedu.stock.entity;

/**
 * 商品數據
 */
public class Goods extends BaseEntity {
	
	private static final long serialVersionUID = -3862318950671589485L;
	
	private Integer id;
	private Integer categoryId;
	private String code;
	private String stock;
	private String mainBusiness;
	private Double price;
	private Long volume;
	private Integer state;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
	public String getMainBusiness() {
		return mainBusiness;
	}
	public void setMainBusiness(String mainBusiness) {
		this.mainBusiness = mainBusiness;
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
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", categoryId=" + categoryId + ", code=" + code + ", stock=" + stock
				+ ", mainBusiness=" + mainBusiness + ", price=" + price + ", volume=" + volume + ", state=" + state
				+ "]";
	}
	
	
}
