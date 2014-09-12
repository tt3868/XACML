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

import com.vaadin.data.Validator;

public class DoubleValidator implements Validator {
	private static final long serialVersionUID = 1L;

	public DoubleValidator() {
	}

	@Override
	public void validate(Object value) throws InvalidValueException {
		if (value instanceof Double) {
			return;
		}
		try {
			Double.parseDouble(value.toString());
		} catch (NumberFormatException e) {
			throw new InvalidValueException(e.getLocalizedMessage());
		}
	}

}
