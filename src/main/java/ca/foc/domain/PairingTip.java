package ca.foc.domain;

import javax.persistence.*;
/**
 * PairingTips entity to implement pairing tips table
 * @author Mariia Voronina
 *
 */
@Entity
@Table(name="foc_products_pairing")
public class PairingTip {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId; // primary key table products_pairing

	@ManyToOne
	@JoinColumn
	private Product product;

}
