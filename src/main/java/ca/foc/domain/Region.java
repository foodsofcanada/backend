package ca.foc.domain;

import javax.persistence.*;
import org.springframework.data.geo.Polygon;

@Entity
@Table(name="foc_region")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reg_id")
	private int reg_id;
	
//	@OneToMany(mappedBy="region", cascade = CascadeType.ALL)
//	private List<ProductRegion> productRegion;
	
	private String name;
	
	private  Polygon polygon;
	
	//getters and setters
	
	public long getReg_id() {
		return reg_id;
	}
	public void setReg_id(int reg_id) {
		this.reg_id = reg_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Polygon getPolygon() {
		return polygon;
	}
	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}
	@Override
	public String toString() {
		return "Region [reg_id=" + reg_id + ", name=" + name + ", polygon=" + polygon + "]";
	}
	
	
	
}
