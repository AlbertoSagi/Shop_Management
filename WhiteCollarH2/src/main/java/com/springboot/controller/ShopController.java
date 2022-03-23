package com.springboot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Shop;
import com.springboot.model.dto.ShopDto;
import com.springboot.service.ShopService;

@RestController
@RequestMapping("/shops")
public class ShopController {

	private final ShopService shopService;

	@Autowired
	public ShopController(ShopService shopService) {
		super();
		this.shopService = shopService;
	}

	@PostMapping
	public ResponseEntity<ShopDto> addShop(@RequestBody final ShopDto shopDto) {
		Shop shop = shopService.addShop(Shop.from(shopDto));
		return new ResponseEntity<>(ShopDto.from(shop), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<ShopDto>> getShops() {
		List<Shop> shops = shopService.getShops();
		List<ShopDto> shopsDto = shops.stream().map(ShopDto::from).collect(Collectors.toList());
		return new ResponseEntity<>(shopsDto, HttpStatus.OK);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<ShopDto> getShop(@PathVariable final Long id) {
		Shop shop = shopService.getShop(id);
		return new ResponseEntity<>(ShopDto.from(shop), HttpStatus.OK);

	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<ShopDto> deleteShop(@PathVariable final Long id) {
		Shop shop = shopService.deleteShop(id);
		return new ResponseEntity<>(ShopDto.from(shop), HttpStatus.OK);

	}

	@PutMapping(value = "{id}")
	public ResponseEntity<ShopDto> editShop(@PathVariable final Long id, @RequestBody final ShopDto shopDto) {
		Shop shop = shopService.editShop(id, Shop.from(shopDto));
		return new ResponseEntity<>(ShopDto.from(shop), HttpStatus.OK);

	}

	@PostMapping(value = "{shopId}/pictures/{pictureId}/add")
	public ResponseEntity<ShopDto> addPictureToShop(@PathVariable final Long shopId,
			@PathVariable final Long pictureId) {
		Shop shop = shopService.addPictureToShop(shopId, pictureId);
		return new ResponseEntity<>(ShopDto.from(shop), HttpStatus.OK);
	}

	@DeleteMapping(value = "{shopId}/pictures/{pictureId}/remove")
	public ResponseEntity<ShopDto> removePictureFromShop(@PathVariable final Long shopId,
			@PathVariable final Long pictureId) {
		Shop shop = shopService.removePictureFromShop(shopId, pictureId);
		return new ResponseEntity<>(ShopDto.from(shop), HttpStatus.OK);
	}

	@DeleteMapping(value = "{shopId}/pictures/burnItAll")
	public ResponseEntity<ShopDto> removeAllPicturesFromShop(@PathVariable final Long shopId) {
		Shop shop = shopService.removeAllPicturesFromShop(shopId);
		return new ResponseEntity<>(ShopDto.from(shop), HttpStatus.OK);
	}

}
