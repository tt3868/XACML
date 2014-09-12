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

import java.text.ParseException;

import com.att.research.xacml.std.datatypes.RFC2396DomainName;
import com.vaadin.data.Validator;

public class DNSNameValidator implements Validator {
	private static final long serialVersionUID = 1L;

	public DNSNameValidator() {
	}

	@Override
	public void validate(Object value) throws InvalidValueException {
		if (value instanceof String) {
			try {
				RFC2396DomainName.newInstance((String) value);
			} catch (ParseException e) {
				throw new InvalidValueException(e.getLocalizedMessage());
			}
		} else
			throw new InvalidValueException("Unrecognized DNS Name");
	}
}
