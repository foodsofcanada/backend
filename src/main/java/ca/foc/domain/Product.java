package ca.foc.domain;

import java.util.List;

/**
 * ******************************************** **
 * Product - ca.foc.domain.Product
 *
 * @author Christian Garrovillo
 * Information and Communications Technologies
 * Software Development
 * * ********************************************* **
 */
public class Product {

    private long prod_id;
    private String name;
    private String description;
    private String imgPath;
    private String shelfLife;
    private List<Product> pairingTip;
    private String danger;
    private List<Region> growthRegions;
    private String growthPhases;
    private String scientificName;
    private String history;
    private String cookingUse;
    private String preservation;
    private String funFact;
    private String countryOfOrigin;

    public Product(long id, String name, String description, String shelfLife, String danger, String growthPhases, String scientificName, String history, String cookingUse, String preservation, String funFact, String countryOfOrigin) {
        this.prod_id = id;
        this.name = name;
        this.description = description;
        this.shelfLife = shelfLife;
        this.danger = danger;
        this.growthPhases = growthPhases;
        this.scientificName = scientificName;
        this.history = history;
        this.cookingUse = cookingUse;
        this.preservation = preservation;
        this.funFact = funFact;
        this.countryOfOrigin = countryOfOrigin;
    }

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

    public List<Product> getPairingTip() {
        return pairingTip;
    }

    public void setPairingTip(List<Product> pairingTip) {
        this.pairingTip = pairingTip;
    }

    public String getDanger() {
        return danger;
    }

    public void setDanger(String danger) {
        this.danger = danger;
    }

    public List<Region> getGrowthRegions() {
        return growthRegions;
    }

    public void setGrowthRegions(List<Region> growthRegions) {
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
