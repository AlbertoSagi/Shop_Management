package com.springboot.model.dto;

import com.springboot.model.Shop;

public class PlainShopDto {

	private Long id;
	private String name;

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

	public static PlainShopDto from(Shop shop) {
		PlainShopDto plainShopDto = new PlainShopDto();
		plainShopDto.setId(shop.getId());
		plainShopDto.setName(shop.getName());
		return plainShopDto;

	}

}
