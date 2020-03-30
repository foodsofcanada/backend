package ca.foc.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foc_favourite_products")
public class FavouriteProducts {
    @Id
    private String email;
    @Id
    private int prod_id;
}
