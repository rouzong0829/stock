package tw.tedu.stock.vo;

import java.io.Serializable;

/**
 * 收藏數據的Value Object類
 */
public class FavoriteVO implements Serializable {
	
	private static final long serialVersionUID = -7978264430016116890L;
	
	private Integer id;
	private Integer uid;
	private Integer gid;
	private String name;
	private String code;
	private String stock;
	private Double oldPrice;
	private Double newPrice;
	private Long oldVolume;
	private Long newVolume;
	
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
	public Double getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(Double oldPrice) {
		this.oldPrice = oldPrice;
	}
	public Double getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(Double newPrice) {
		this.newPrice = newPrice;
	}
	public Long getOldVolume() {
		return oldVolume;
	}
	public void setOldVolume(Long oldVolume) {
		this.oldVolume = oldVolume;
	}
	public Long getNewVolume() {
		return newVolume;
	}
	public void setNewVolume(Long newVolume) {
		this.newVolume = newVolume;
	}
	@Override
	public String toString() {
		return "FavoriteVO [id=" + id + ", uid=" + uid + ", gid=" + gid + ", name=" + name + ", code=" + code
				+ ", stock=" + stock + ", oldPrice=" + oldPrice + ", newPrice=" + newPrice + ", oldVolume=" + oldVolume
				+ ", newVolume=" + newVolume + "]";
	}
	
	
	
}
