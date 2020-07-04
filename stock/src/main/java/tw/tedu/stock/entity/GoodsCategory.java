package tw.tedu.stock.entity;

/**
 * 商品分類
 */
public class GoodsCategory extends BaseEntity {
	
	private static final long serialVersionUID = 6408290912914515321L;
	
	private Integer id;
	private String name;
	private Integer status;
	
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
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "GoodsCategory [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	
	
}
