/*
 *                        AT&T - PROPRIETARY
 *          THIS FILE CONTAINS PROPRIETARY INFORMATION OF
 *        AT&T AND IS NOT TO BE DISCLOSED OR USED EXCEPT IN
 *             ACCORDANCE WITH APPLICABLE AGREEMENTS.
 *
 *          Copyright (c) 2013 AT&T Knowledge Ventures
 *              Unpublished and Not for Publication
 *                     All Rights Reserved
 */
package com.att.research.xacml.admin.converters;

import java.util.Locale;

import com.att.research.xacml.api.Identifier;
import com.att.research.xacml.std.IdentifierImpl;
import com.vaadin.data.util.converter.Converter;


public class IdentifierConverter implements Converter<Object, Identifier> {
	private static final long serialVersionUID = 1L;

	@Override
	public Identifier convertToModel(Object value,
			Class<? extends Identifier> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		return new IdentifierImpl(value.toString());
	}

	@Override
	public Object convertToPresentation(Identifier value,
			Class<? extends Object> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		if (targetType.isInstance(String.class) ||
			targetType.getName().equals(String.class.getName())) {
			return value.stringValue();
		}
		return null;
	}

	@Override
	public Class<Identifier> getModelType() {
		return Identifier.class;
	}

	@Override
	public Class<Object> getPresentationType() {
		return Object.class;
	}

}
