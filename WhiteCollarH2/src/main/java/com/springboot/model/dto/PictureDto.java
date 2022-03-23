package com.springboot.model.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.springboot.model.Picture;

public class PictureDto {

	private long id;
	private String author;
	private String namePicture;
	private float price;
	private LocalDate date = LocalDate.now();
	private PlainShopDto plainShopDto;

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

	public PlainShopDto getPlainShopDto() {
		return plainShopDto;
	}

	public void setPlainShopDto(PlainShopDto plainShopDto) {
		this.plainShopDto = plainShopDto;
	}

	public static PictureDto from(Picture picture) {
		PictureDto pictureDto = new PictureDto();
		pictureDto.setId(picture.getId());
		pictureDto.setAuthor(picture.getAuthor());
		pictureDto.setNamePicture(picture.getNamePicture());
		pictureDto.setDate(picture.getDate());
		pictureDto.setPrice(picture.getPrice());
		if (Objects.nonNull(picture.getShop())) {
			pictureDto.setPlainShopDto(PlainShopDto.from(picture.getShop()));
		}
		return pictureDto;

	}

}
