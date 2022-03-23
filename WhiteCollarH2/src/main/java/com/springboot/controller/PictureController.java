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

import com.springboot.model.Picture;
import com.springboot.model.dto.PictureDto;
import com.springboot.service.PictureService;

@RestController
@RequestMapping("/pictures")
public class PictureController {

	private final PictureService pictureService;

	@Autowired
	public PictureController(PictureService pictureService) {
		super();
		this.pictureService = pictureService;
	}

	@PostMapping
	public ResponseEntity<PictureDto> addPicture(@RequestBody final PictureDto pictureDto) {
		Picture picture = pictureService.addPicture(Picture.from(pictureDto));
		return new ResponseEntity<>(PictureDto.from(picture), HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<List<PictureDto>> getPictures() {
		List<Picture> pictures = pictureService.getPictures();
		List<PictureDto> picturesDto = pictures.stream().map(PictureDto::from).collect(Collectors.toList());

		return new ResponseEntity<>(picturesDto, HttpStatus.OK);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<PictureDto> getPicture(@PathVariable final Long id) {
		Picture picture = pictureService.getPicture(id);
		return new ResponseEntity<>(PictureDto.from(picture), HttpStatus.OK);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity<PictureDto> deletePicture(@PathVariable final Long id) {
		Picture picture = pictureService.deletePicture(id);
		return new ResponseEntity<>(PictureDto.from(picture), HttpStatus.OK);

	}

	@PutMapping(value = "{id}")

	public ResponseEntity<PictureDto> editPicture(@PathVariable final Long id,
			@RequestBody final PictureDto pictureDto) {
		Picture editedPicture = pictureService.editPicture(id, Picture.from(pictureDto));
		return new ResponseEntity<>(PictureDto.from(editedPicture), HttpStatus.OK);

	}

}
