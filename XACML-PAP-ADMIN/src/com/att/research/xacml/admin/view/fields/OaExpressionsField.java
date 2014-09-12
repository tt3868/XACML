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

import com.att.research.xacml.admin.XacmlAdminUI;
import com.att.research.xacml.admin.jpa.Obadvice;
import com.att.research.xacml.admin.view.components.OaExpressionsEditorComponent;
import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.UI;

public class OaExpressionsField extends CustomField<Object> {
	private static final long serialVersionUID = 1L;
	private final EntityItem<Obadvice> obad;

	public OaExpressionsField(EntityItem<Obadvice> obad) {
		this.obad = obad;
	}

	@Override
	protected Component initContent() {
		return new OaExpressionsEditorComponent(this.obad, ((XacmlAdminUI)UI.getCurrent()).getObadviceExpressions());
	}

	@Override
	public Class<? extends Object> getType() {
		return Collection.class;
	}

}
