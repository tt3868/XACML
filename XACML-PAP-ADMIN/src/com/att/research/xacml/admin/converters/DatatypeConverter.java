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

import com.att.research.xacml.admin.jpa.Datatype;
import com.att.research.xacml.api.Identifier;
import com.vaadin.data.util.converter.Converter;

public class DatatypeConverter implements Converter<Object, Datatype> {
	private static final long serialVersionUID = 1L;

	@Override
	public Datatype convertToModel(Object value,
			Class<? extends Datatype> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		Datatype datatype = new Datatype();
		if (value == null) {
			return datatype;
		}
		if (value instanceof Identifier) {
			datatype.setXacmlId(((Identifier)value).stringValue());
		} else {
			datatype.setXacmlId(value.toString());
		}
		return datatype;
	}

	@Override
	public Object convertToPresentation(Datatype value,
			Class<? extends Object> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		if (value == null) {
			return null;
		}
		if (targetType.isInstance(String.class) ||
			targetType.getName().equals(String.class.getName())) {
			return value.getXacmlId();
		}
		if (targetType.isInstance(Identifier.class) ||
			targetType.getName().equals(Identifier.class.getName())) {
			return value.getIdentifer();
		}
		return value.getIdentifer();
	}

	@Override
	public Class<Datatype> getModelType() {
		return Datatype.class;
	}

	@Override
	public Class<Object> getPresentationType() {
		return Object.class;
	}

}
