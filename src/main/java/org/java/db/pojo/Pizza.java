package org.java.db.pojo;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "The field is empty")
	private String name;

	@Column(columnDefinition = "TEXT")
	@Length(min = 3, message = "The description must be longer than 3 characters")
	private String description;

	@Column(columnDefinition = "TEXT")
	@URL
	private String photo;

	@Column(precision = 4, scale = 2)
	@Positive(message = "Invalid price")
	private BigDecimal price;

	// RELAZIONE CON OFFERTA

	@OneToMany(mappedBy = "pizza")
	private List<Offert> offert;

	public List<Offert> getOffert() {
		return offert;
	}

	public void setOffert(List<Offert> offert) {
		this.offert = offert;
	}

	public Pizza() {
	}

	public Pizza(String name, String description, String photo, BigDecimal price) {

		setName(name);
		setDescription(description);
		setPhoto(photo);
		setPrice(price);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return getName() + " - " + getDescription() + " - " + getPrice() + " €";
	}

}
