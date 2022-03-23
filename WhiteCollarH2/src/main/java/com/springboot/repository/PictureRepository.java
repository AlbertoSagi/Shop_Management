package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Picture;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long> {

}
