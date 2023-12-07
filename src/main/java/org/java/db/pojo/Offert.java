package org.java.db.pojo;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;

public class Offert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@FutureOrPresent(message = "Invalid date")
	private LocalDateTime startDateOffert;

	@Future(message = "Invalid date")
	private LocalDateTime endDateOffert;

	@NotBlank(message = "Mandatory field")
	@Length(min = 5, message = "the title cannot be shorter than 5 characters")
	private String title;

	public Offert(String title, LocalDateTime startDateOffert, LocalDateTime endDateOffert) {

		setTitle(title);
		setStartDateOffert(startDateOffert);
		setEndDateOffert(endDateOffert);
	}

	public LocalDateTime getStartDateOffert() {
		return startDateOffert;
	}

	public void setStartDateOffert(LocalDateTime startDateOffert) {
		this.startDateOffert = startDateOffert;
	}

	public LocalDateTime getEndDateOffert() {
		return endDateOffert;
	}

	public void setEndDateOffert(LocalDateTime endDateOffert) {
		this.endDateOffert = endDateOffert;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Offert [getStartDateOffert()=" + getStartDateOffert() + ", getEndDateOffert()=" + getEndDateOffert()
				+ ", getTitle()=" + getTitle() + "]";
	}

}
