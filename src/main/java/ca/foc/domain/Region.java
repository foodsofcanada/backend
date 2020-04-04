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
	@Column(name ="name")
	private String regionName;	
	private  Polygon polygon;
	
	//getters and setters
	
	public long getRegionId() {
		return regionId;
	}
	public void setRegionId(int reg_id) {
		this.regionId = reg_id;
	}
	public String getRegionName() {
		return regionName;
	}
	public void setRegionName(String name) {
		this.regionName = name;
	}
	public Polygon getPolygon() {
		return polygon;
	}
	public void setPolygon(Polygon polygon) {
		this.polygon = polygon;
	}
	@Override
	public String toString() {
		return "Region [reg_id=" + regionId + ", name=" + regionName + ", polygon=" + polygon + "]";
	}
	
	
	
}
