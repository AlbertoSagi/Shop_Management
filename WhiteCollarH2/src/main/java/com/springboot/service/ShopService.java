package com.springboot.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Picture;
import com.springboot.model.Shop;
import com.springboot.model.exception.PictureIsAlreadyAssignedException;
import com.springboot.model.exception.ShopNotFoundException;
import com.springboot.repository.ShopRepository;

@Service
public class ShopService {

	private final ShopRepository shopRepository;
	private final PictureService pictureService;

	public ShopService(ShopRepository shopRepository, PictureService pictureService) {
		super();
		this.shopRepository = shopRepository;
		this.pictureService = pictureService;
	}

	public Shop addShop(Shop shop) {
		return shopRepository.save(shop);
	}

	public List<Shop> getShops() {
		return StreamSupport.stream(shopRepository.findAll().spliterator(), false).collect(Collectors.toList());

	}

	public Shop getShop(Long id) {
		return shopRepository.findById(id).orElseThrow(() -> new ShopNotFoundException(id));
	}

	public Shop deleteShop(Long id) {
		Shop shop = getShop(id);
		shopRepository.delete(shop);
		return shop;
	}

	@Transactional
	public Shop editShop(Long id, Shop shop) {
		Shop shopToEdit = getShop(id);
		shopToEdit.setName(shop.getName());
		return shopToEdit;
	}

	@Transactional
	public Shop addPictureToShop(Long shopId, Long pictureId) {
		Shop shop = getShop(shopId);
		Picture picture = pictureService.getPicture(pictureId);
		if (Objects.nonNull(picture.getShop())) {
			throw new PictureIsAlreadyAssignedException(pictureId, picture.getShop().getId());

		}
		shop.addPicture(picture);
		picture.setShop(shop);
		return shop;
	}

	@Transactional
	public Shop removePictureFromShop(Long shopId, Long pictureId) {
		Shop shop = getShop(shopId);
		Picture picture = pictureService.getPicture(pictureId);
		shop.removePicture(picture);
		return shop;
	}

	@Transactional
	public Shop removeAllPicturesFromShop(Long shopId) {
		Shop shop = getShop(shopId);
		List<Picture> pictures = shop.getPictures();
		pictures.removeAll(pictures);
		return shop;
	}

}
