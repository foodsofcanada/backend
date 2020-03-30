package ca.foc.domain;

import java.util.List;


public class Pantry {

    private long pantry_id;
    private String imgPath;
    private List<Product> products;
    private String description;
    private String name;

    public Pantry(long pantry_id, String imgPath, List<Product> products, String description, String name) {
        this.pantry_id = pantry_id;
        this.imgPath = imgPath;
        this.products = products;
        this.description = description;
        this.name = name;
    }

    public long getPantry_id() {
        return pantry_id;
    }

    public void setPantry_id(long pantry_id) {
        this.pantry_id = pantry_id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
