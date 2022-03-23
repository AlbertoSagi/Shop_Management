package com.springboot.model.exception;

import java.text.MessageFormat;

public class PictureNotFoundException extends RuntimeException {

	public PictureNotFoundException(final Long id) {
		super(MessageFormat.format("Could not find picture with id: {0}", id));
	}

}
