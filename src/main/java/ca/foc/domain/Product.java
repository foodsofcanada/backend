package ca.foc.domain;


import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="foc_products")
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(name = "getAllProductsInRegion",
            procedureName = "getAllProductsInRegion",
            resultClasses = Product.class,
            parameters = @StoredProcedureParameter(name = "p_reg_id",type=Long.class,
            mode = ParameterMode.IN)),

    @NamedStoredProcedureQuery(name = "getProductInfo",
            procedureName = "getProductInfo",
            resultClasses = Product.class,
            parameters = @StoredProcedureParameter(name = "p_prod_id",type = Long.class,
            mode = ParameterMode.IN))
})
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long prod_id;
	
	private String name;
	private String description;
	private String imgPath;
	private String shelfLife;
	
	// One to may relationship with table pairing tips
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL)
	private List<PairingTip>pairingTip;

	private String danger;
	
	//One to many relationship with bridge table Product_Region
	@OneToMany( mappedBy="product", cascade = CascadeType.ALL)
	private List<ProductRegion> growthRegions;
	
	private String growthPhases;
	private String scientificName;
	private String history;
	private String cookingUse;
	private String preservation;
	private String funFact;
	private String countryOfOrigin;
	
	
	//Getters and setters
	public long getProd_id() {
		return prod_id;
	}
	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	public List<PairingTip> getPairingTip() {
		return pairingTip;
	}
	public void setPairingTip(List<PairingTip> pairingTip) {
		this.pairingTip = pairingTip;
	}
	public String getDanger() {
		return danger;
	}
	public void setDanger(String danger) {
		this.danger = danger;
	}
	public List<ProductRegion> getGrowthRegions() {
		return growthRegions;
	}
	public void setGrowthRegions(List<ProductRegion> growthRegions) {
		this.growthRegions = growthRegions;
	}
	public String getGrowthPhases() {
		return growthPhases;
	}
	public void setGrowthPhases(String growthPhases) {
		this.growthPhases = growthPhases;
	}
	public String getScientificName() {
		return scientificName;
	}
	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public String getCookingUse() {
		return cookingUse;
	}
	public void setCookingUse(String cookingUse) {
		this.cookingUse = cookingUse;
	}
	public String getPreservation() {
		return preservation;
	}
	public void setPreservation(String preservation) {
		this.preservation = preservation;
	}
	public String getFunFact() {
		return funFact;
	}
	public void setFunFact(String funFact) {
		this.funFact = funFact;
	}
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}
	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	
	

}
