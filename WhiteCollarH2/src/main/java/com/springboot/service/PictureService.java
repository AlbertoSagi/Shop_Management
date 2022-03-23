package com.springboot.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.model.Picture;
import com.springboot.model.exception.PictureNotFoundException;
import com.springboot.repository.PictureRepository;

@Service
public class PictureService {

	private final PictureRepository pictureRepository;

	@Autowired
	public PictureService(PictureRepository pictureRepository) {
		this.pictureRepository = pictureRepository;
	}

	public Picture addPicture(Picture picture) {
		return pictureRepository.save(picture);
	}

	public List<Picture> getPictures() {
		return StreamSupport.stream(pictureRepository.findAll().spliterator(), false).collect(Collectors.toList());

	}

	public Picture getPicture(Long id) {
		return pictureRepository.findById(id).orElseThrow(() -> new PictureNotFoundException(id));
	}

	public Picture deletePicture(Long id) {
		Picture picture = getPicture(id);
		pictureRepository.delete(picture);
		return picture;
	}

	@Transactional
	public Picture editPicture(Long id, Picture picture) {
		Picture pictureToEdit = getPicture(id);
		pictureToEdit.setAuthor(picture.getAuthor());
		pictureToEdit.setNamePicture(picture.getNamePicture());
		pictureToEdit.setPrice(picture.getPrice());
		pictureToEdit.setDate(picture.getDate());
		return pictureToEdit;

	}

}
