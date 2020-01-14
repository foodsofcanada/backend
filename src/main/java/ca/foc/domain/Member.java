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
    private String hashedPw;
    private String fName;
    private String lName;
    private List<Product> favourites;
    private int role;

    public Member(String email, String hashedPw, String fName, String lName, List<Product> favourites, int role) {
        this.email = email;
        this.hashedPw = hashedPw;
        this.fName = fName;
        this.lName = lName;
        this.favourites = favourites;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPw() {
        return hashedPw;
    }

    public void setHashedPw(String hashedPw) {
        this.hashedPw = hashedPw;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
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
