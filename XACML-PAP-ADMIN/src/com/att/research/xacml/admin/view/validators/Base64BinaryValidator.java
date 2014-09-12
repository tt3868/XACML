/*
 *                        AT&T - PROPRIETARY
 *          THIS FILE CONTAINS PROPRIETARY INFORMATION OF
 *        AT&T AND IS NOT TO BE DISCLOSED OR USED EXCEPT IN
 *             ACCORDANCE WITH APPLICABLE AGREEMENTS.
 *
 *          Copyright (c) 2014 AT&T Knowledge Ventures
 *              Unpublished and Not for Publication
 *                     All Rights Reserved
 */
package com.att.research.xacml.admin.view.validators;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;

import com.vaadin.data.Validator;

public class Base64BinaryValidator implements Validator {
	private static final long serialVersionUID = 1L;

	public Base64BinaryValidator() {
	}

	@Override
	public void validate(Object value) throws InvalidValueException {
		if (value instanceof String) {
			try {
				new Base64().decode((String) value);
			} catch (DecoderException e) {
				throw new InvalidValueException(e.getLocalizedMessage());
			}
		} else
			throw new InvalidValueException("Unrecognized Base64 Binary");
	}
}
