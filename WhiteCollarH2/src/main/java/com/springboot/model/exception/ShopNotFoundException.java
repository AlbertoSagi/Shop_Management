package com.springboot.model.exception;

import java.text.MessageFormat;

public class ShopNotFoundException extends RuntimeException {

	public ShopNotFoundException(final Long id) {
		super(MessageFormat.format("Could not find shop with id: {0}", id));
	}

}
