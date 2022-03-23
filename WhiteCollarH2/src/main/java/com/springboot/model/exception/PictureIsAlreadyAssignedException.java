package com.springboot.model.exception;

import java.text.MessageFormat;

public class PictureIsAlreadyAssignedException extends RuntimeException {

	public PictureIsAlreadyAssignedException(final Long pictureId, final Long shopId) {
		super(MessageFormat.format("Picture: {0} is already assigned to shop: {1}", pictureId, shopId));
	}

}
