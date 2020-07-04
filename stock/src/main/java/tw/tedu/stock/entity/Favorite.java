package tw.tedu.stock.entity;

/**
 * 收藏的實體類
 */
public class Favorite extends BaseEntity {
	
	private static final long serialVersionUID = -1542999897117650348L;
	
	private Integer id;
	private Integer uid;
	private Integer gid;
	private Double price;
	private Long volume;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
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
	@Override
	public String toString() {
		return "Favorite [id=" + id + ", uid=" + uid + ", gid=" + gid + ", price=" + price + ", volume=" + volume + "]";
	}
	
	
}
