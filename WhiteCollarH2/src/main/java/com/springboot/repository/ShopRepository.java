package com.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springboot.model.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {

}
