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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.att.research.xacml.admin.jpa.Category;
import com.att.research.xacml.admin.jpa.ConstraintType;
import com.att.research.xacml.admin.jpa.ConstraintValue;
import com.att.research.xacml.admin.jpa.Datatype;
import com.att.research.xacml.api.Identifier;
import com.vaadin.data.util.converter.Converter;
import com.vaadin.data.util.converter.DefaultConverterFactory;

public class XacmlConverterFactory extends DefaultConverterFactory {
	private static final long serialVersionUID = 1L;
	private static final Log logger	= LogFactory.getLog(XacmlConverterFactory.class);
	
    @SuppressWarnings("unchecked")
	@Override
    public <PRESENTATION, MODEL> Converter<PRESENTATION, MODEL>
            createConverter(Class<PRESENTATION> presentationType,
                            Class<MODEL> modelType) {
    	if (logger.isTraceEnabled()) {
    		logger.trace("createConverter: " + presentationType + " from model " + modelType);
    	}
    	//
        // Handle one particular type conversion for Categories
    	//
        if (Category.class == modelType) {
            return (Converter<PRESENTATION, MODEL>) new CategoryConverter();
        }
        //
        // Handle one particular type conversion for Datatypes
        //
        if (Datatype.class == modelType) {
            return (Converter<PRESENTATION, MODEL>) new DatatypeConverter();
        }
        //
        // Handle one particular type conversion for ConstraintType
        //
        if (ConstraintType.class == modelType) {
        	return (Converter<PRESENTATION, MODEL>) new ConstraintTypeConverter();
        }
        //
        // Handle one particular type conversion for ConstraintType
        //
        if (ConstraintValue.class == modelType) {
        	return (Converter<PRESENTATION, MODEL>) new ConstraintValueConverter();
        }
        //
        // Handle one particular type conversion for Identifiers
        //
        if (Identifier.class == modelType) {
        	return (Converter<PRESENTATION, MODEL>) new IdentifierConverter();
        }
        //
        // Default to the supertype
        //
        return super.createConverter(presentationType,
                                     modelType);
    }

}
