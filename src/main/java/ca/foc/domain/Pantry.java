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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pantryId;
    @Column(name="owner")
    private String email;
    @Column(name="imagen_path")
    private String imgPath;
    private String description;
    @Column(name="name")
    private String pantryName;
    
    public Pantry() {
    	
    }

    public Pantry(Integer pantry_id, String email,String imgPath, String description, String pantryName) {
        this.pantryId = pantry_id;
        this.imgPath = imgPath;
        this.email = email;
        this.description = description;
        this.pantryName = pantryName;
    }

    public Integer getPantryId() {
		return pantryId;
	}

	public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
    
    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPantryId(Integer pantryId) {
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
