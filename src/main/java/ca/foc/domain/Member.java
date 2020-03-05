package ca.foc.domain;

import java.util.List;

/**
 * ******************************************** **
 * Member - ca.foc.domain.Member
 *
 * @author Christian Garrovillo
 * Information and Communications Technologies
 * Software Development
 * * ********************************************* **
 */
public class Member {

    private String email;
    private String passw;
    private String firstName;
    private String lastName;
    private String imgPath;
    private List<Product> favourites;
    private int role;

    public Member(String email, String passw, String firstName, String lastName, String imgPath, List<Product> favourites, int role) {
        this.email = email;
        this.passw = passw;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imgPath = imgPath;
        this.favourites = favourites;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public List<Product> getFavourites() {
        return favourites;
    }

    public void setFavourites(List<Product> favourites) {
        this.favourites = favourites;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
