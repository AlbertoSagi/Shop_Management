package com.springboot.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.springboot.model.Shop;

public class ShopDto {

	private Long id;
	private String name;
	private int capacity;
	private List<PictureDto> picturesDto = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PictureDto> getPictures() {
		return picturesDto;
	}

	public void setPicturesDto(List<PictureDto> picturesDto) {
		this.picturesDto = picturesDto;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public static ShopDto from(Shop shop) {
		ShopDto shopDto = new ShopDto();
		shopDto.setId(shop.getId());
		shopDto.setName(shop.getName());
		shopDto.setCapacity(shop.getCapacity());
		shopDto.setPicturesDto(shop.getPictures().stream().map(PictureDto::from).collect(Collectors.toList()));
		return shopDto;
	}

}
