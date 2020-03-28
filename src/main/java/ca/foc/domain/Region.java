package ca.foc.domain;

import javax.persistence.*;
import org.springframework.data.geo.Polygon;

@Entity
@Table(name="foc_region")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reg_id")
	private int regionId;
	
//	@OneToMany(mappedBy="region", cascade = CascadeType.ALL)
//	private List<ProductRegion> productRegion;
	
	private String name;
	
	private  Polygon polygon;
	
	//getters and setters
	
	public long getRegionId() {
		return regionId;
	}
	public void setRegionId(int reg_id) {
		this.regionId = reg_id;
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
		return "Region [reg_id=" + regionId + ", name=" + name + ", polygon=" + polygon + "]";
	}
	
	
	
}
