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
package com.att.research.xacml.admin.view.fields;

import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;


public class ExpressionField extends CustomField<Object> {
	private static final long serialVersionUID = 1L;
	private static final Log logger	= LogFactory.getLog(ExpressionField.class);
	
	@Override
	protected Component initContent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Object> getType() {
		return Collection.class;
	}

}
