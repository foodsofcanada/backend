package ca.foc.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foc_pantries")
public class Pantry {

    @Id
    @Column (name="pantry_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pantryId;
    private String owner;
    @Column(name="imagen_path")
    private String imgPath;
    private String description;
    @Column(name="name")
    private String pantryName;

    public Pantry(long pantry_id, String owner,String imgPath, String description, String pantryName) {
        this.pantryId = pantry_id;
        this.imgPath = imgPath;
        this.owner = owner;
        this.description = description;
        this.pantryName = pantryName;
    }

    public long getPantryId() {
		return pantryId;
	}

	public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
    
    public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setPantryId(long pantryId) {
		this.pantryId = pantryId;
	}

	public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPantryName() {
        return pantryName;
    }

    public void setPantryName(String name) {
        this.pantryName = name;
    }
}
