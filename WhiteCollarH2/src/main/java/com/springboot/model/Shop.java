package com.springboot.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.springboot.model.dto.ShopDto;

@Entity
@Table(name = "Shop")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private int capacity;
	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL, orphanRemoval = true)
	// @JoinColumn(name = "shop_id")

	private List<Picture> pictures = new ArrayList<>();

	public Shop() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addPicture(Picture picture) {
		pictures.add(picture);
	}

	public void removePicture(Picture picture) {
		pictures.remove(picture);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public static Shop from(ShopDto shopDto) {
		Shop shop = new Shop();
		shop.setName(shopDto.getName());
		shop.setCapacity(shopDto.getCapacity());
		return shop;

	}

	public Shop(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

}
