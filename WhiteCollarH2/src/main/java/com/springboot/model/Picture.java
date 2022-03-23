package com.springboot.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.springboot.model.dto.PictureDto;

@Entity
@Table(name = "picture")
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String author;
	private String namePicture;
	private float price;
	private LocalDate date = LocalDate.now();
	@ManyToOne
	private Shop shop;

	public Picture() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNamePicture() {
		return namePicture;
	}

	public void setNamePicture(String namePicture) {
		this.namePicture = namePicture;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public static Picture from(PictureDto pictureDto) {
		Picture picture = new Picture();
		picture.setAuthor(pictureDto.getAuthor());
		picture.setNamePicture(pictureDto.getNamePicture());
		picture.setDate(pictureDto.getDate());
		picture.setPrice(pictureDto.getPrice());
		return picture;
	}

	public Picture(String author, String namePicture, float price, LocalDate date, Shop shop) {
		this.author = author;
		this.namePicture = namePicture;
		this.price = price;
		this.date = date;
		this.shop = shop;
	}

}
