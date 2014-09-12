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

import com.att.research.xacml.admin.jpa.PIPResolver;
import com.att.research.xacml.admin.view.components.PIPParameterComponent;
import com.att.research.xacml.admin.view.events.FormChangedEventListener;
import com.att.research.xacml.admin.view.windows.PIPSQLResolverEditorWindow;
import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.VerticalLayout;

public class ResolverParamField extends CustomField<Object> implements FormChangedEventListener {
	private static final long serialVersionUID = 1L;
	private final EntityItem<PIPResolver> entity;
	private VerticalLayout mainLayout = new VerticalLayout();

	public ResolverParamField(EntityItem<PIPResolver> entity) {
		this.entity = entity;
		//
		// Make sure we can auto-fit
		//
		this.setWidth("-1px");
		this.mainLayout.setWidth("-1px");
	}

	@Override
	public void onFormChanged() {
		this.fireEvent(new com.vaadin.ui.Field.ValueChangeEvent(this));
	}

	@Override
	protected Component initContent() {
		Component c = null;
		if (this.entity.getEntity().getPipconfiguration().getPiptype().isSQL() ||
			this.entity.getEntity().getPipconfiguration().getPiptype().isHyperCSV() ||
			this.entity.getEntity().getPipconfiguration().getPiptype().isLDAP() ||
			this.entity.getEntity().getPipconfiguration().getPiptype().isCSV() ) {
			//
			//
			//
			PIPSQLResolverEditorWindow comp = new PIPSQLResolverEditorWindow(this.entity);
			comp.addListener(this);
			c = comp;
		} else {
			//
			//
			//
			PIPParameterComponent comp = new PIPParameterComponent(this.entity.getEntity());
			comp.addListener(this);
			c = comp;
		}
		if (c != null) {
			this.mainLayout.addComponent(c);
		}
		return this.mainLayout;
	}

	
	@Override
	public void discard() throws SourceException {
		if (this.mainLayout.getComponentCount() == 0) {
			return;
		}
		Component c = this.mainLayout.getComponent(0);
		if (c instanceof PIPSQLResolverEditorWindow) {
			((PIPSQLResolverEditorWindow)c).discard();
		}
		super.discard();
	}

	@Override
	public void validate() throws InvalidValueException {
		if (this.mainLayout.getComponentCount() == 0) {
			return;
		}
		Component c = this.mainLayout.getComponent(0);
		if (c instanceof PIPSQLResolverEditorWindow) {
			((PIPSQLResolverEditorWindow)c).validate();
		}
		super.validate();
	}

	@Override
	public void commit() throws SourceException, InvalidValueException {
		if (this.mainLayout.getComponentCount() == 0) {
			return;
		}
		Component c = this.mainLayout.getComponent(0);
		if (c instanceof PIPSQLResolverEditorWindow) {
			((PIPSQLResolverEditorWindow)c).commit();
		}
		super.commit();
	}

	@Override
	public Class<? extends Object> getType() {
		return Collection.class;
	}

}
