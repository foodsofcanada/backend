package ca.foc.domain;

import java.util.List;

import javax.persistence.*;


import org.springframework.data.geo.Polygon;

@Entity
@Table(name="foc_region")
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
<<<<<<< Updated upstream
	private long reg_id;
	
	@OneToMany(mappedBy="region", cascade = CascadeType.ALL)
	private List<ProductRegion>productRegions;
	
=======
	@Column(name = "reg_id")
	private int reg_id;
>>>>>>> Stashed changes
	private String name;
	private  Polygon polygon;

	@ManyToMany(mappedBy = "regions")
	private List<Product> products;
	
	//getters and setters
	
	public long getReg_id() {
		return reg_id;
	}
	public void setReg_id(long reg_id) {
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
	
	
	
}
