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
package com.att.research.xacml.admin.converters;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.att.research.xacml.admin.jpa.ConstraintType;
import com.vaadin.data.util.converter.Converter;

public class ConstraintTypeConverter  implements Converter<Object, ConstraintType> {
	private static final long serialVersionUID = 1L;
	private static final Log logger	= LogFactory.getLog(ConstraintTypeConverter.class);

	@Override
	public ConstraintType convertToModel(Object value,
			Class<? extends ConstraintType> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		if (logger.isTraceEnabled()) {
			logger.trace("convertToModel:" + value + " target " + targetType);
		}
		ConstraintType constraintValue = new ConstraintType();
		if (value == null) {
			return constraintValue;
		}
		// PLD TODO??
		return constraintValue;
	}

	@Override
	public Object convertToPresentation(ConstraintType value,
			Class<? extends Object> targetType, Locale locale)
			throws com.vaadin.data.util.converter.Converter.ConversionException {
		if (logger.isTraceEnabled()) {
			logger.trace("convertToPresentation:" + value + " target " + targetType);
		}
		if (value == null) {
			return null;
		}
		if (targetType.isAssignableFrom(String.class)) {
			return value.getConstraintType();
		}
		if (targetType.isInstance(Integer.class)) {
			return value.getId();
		}
		return null;
	}

	@Override
	public Class<ConstraintType> getModelType() {
		return ConstraintType.class;
	}

	@Override
	public Class<Object> getPresentationType() {
		return Object.class;
	}

}
