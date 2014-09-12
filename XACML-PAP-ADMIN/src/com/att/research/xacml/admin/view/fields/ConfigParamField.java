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

import com.att.research.xacml.admin.jpa.PIPConfiguration;
import com.att.research.xacml.admin.jpa.PIPType;
import com.att.research.xacml.admin.view.components.CSVPIPConfigurationComponent;
import com.att.research.xacml.admin.view.components.CustomPIPConfigurationComponent;
import com.att.research.xacml.admin.view.components.HyperCSVPIPConfigurationComponent;
import com.att.research.xacml.admin.view.components.LDAPPIPConfigurationComponent;
import com.att.research.xacml.admin.view.components.SQLPIPConfigurationComponent;
import com.att.research.xacml.admin.view.events.FormChangedEventListener;
import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.data.Validator.InvalidValueException;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.VerticalLayout;

public class ConfigParamField extends CustomField<Object> implements FormChangedEventListener {
	private static final long serialVersionUID = 1L;
	private final EntityItem<PIPConfiguration> entityConfig;
	private VerticalLayout mainLayout = new VerticalLayout();

	public ConfigParamField(EntityItem<PIPConfiguration> config) {
		//
		// Save
		//
		this.entityConfig = config;
		//
		// Make sure we can auto-fit
		//
		this.setWidth("-1px");
		this.mainLayout.setWidth("-1px");
	}

	public Component resetContent(PIPType pipType) {
		//
		// Remove all the layout
		//
		this.mainLayout.removeAllComponents();
		this.mainLayout.setDescription("Custom Field Layout");
		//
		// Is there a type?
		//
		if (pipType == null) {
			return this.mainLayout;
		}
		//
		// Setup the layout based on the type
		//
		Component c = null;
		String type = pipType.getType();
		if (type.equals(PIPType.TYPE_SQL)) {
			SQLPIPConfigurationComponent comp = new SQLPIPConfigurationComponent(this.entityConfig);
			comp.addListener(this);
			c = comp;
		} else if (type.equals(PIPType.TYPE_LDAP)) {
			LDAPPIPConfigurationComponent comp = new LDAPPIPConfigurationComponent(this.entityConfig);
			comp.addListener(this);
			c = comp;
		} else if (type.equals(PIPType.TYPE_CSV)) {
			CSVPIPConfigurationComponent comp = new CSVPIPConfigurationComponent(this.entityConfig);
			comp.addListener(this);
			c = comp;
		} else if (type.equals(PIPType.TYPE_HYPERCSV)) {
			HyperCSVPIPConfigurationComponent comp = new HyperCSVPIPConfigurationComponent(this.entityConfig);
			comp.addListener(this);
			c = comp;
		} else if (type.equals(PIPType.TYPE_CUSTOM)) {
			CustomPIPConfigurationComponent comp = new CustomPIPConfigurationComponent(this.entityConfig);
			comp.addListener(this);
			c = comp;
		}
		if (c != null) {
			this.mainLayout.addComponent(c);
		}
		//
		// Done
		//
		return this.mainLayout;
	}
	
	@Override
	protected Component initContent() {
		return this.resetContent(this.entityConfig.getEntity().getPiptype());
	}

	@Override
	public void validate() throws InvalidValueException {
		if (this.mainLayout.getComponentCount() == 0) {
			return;
		}
		Component c = this.mainLayout.getComponent(0);
		if (c instanceof SQLPIPConfigurationComponent) {
			((SQLPIPConfigurationComponent)c).validate();
		} else if (c instanceof LDAPPIPConfigurationComponent) {
			((LDAPPIPConfigurationComponent)c).validate();
		} else if (c instanceof CSVPIPConfigurationComponent) {
			((CSVPIPConfigurationComponent)c).validate();
		} else if (c instanceof HyperCSVPIPConfigurationComponent) {
			((HyperCSVPIPConfigurationComponent)c).validate();
		} else if (c instanceof CustomPIPConfigurationComponent) {
			((CustomPIPConfigurationComponent)c).validate();
		}
		super.validate();
	}

	@Override
	public void commit() throws SourceException, InvalidValueException {
		if (this.mainLayout.getComponentCount() == 0) {
			return;
		}
		Component c = this.mainLayout.getComponent(0);
		if (c instanceof SQLPIPConfigurationComponent) {
			((SQLPIPConfigurationComponent)c).commit();
		} else if (c instanceof LDAPPIPConfigurationComponent) {
			((LDAPPIPConfigurationComponent)c).commit();
		} else if (c instanceof CSVPIPConfigurationComponent) {
			((CSVPIPConfigurationComponent)c).commit();
		} else if (c instanceof HyperCSVPIPConfigurationComponent) {
			((HyperCSVPIPConfigurationComponent)c).commit();
		} else if (c instanceof CustomPIPConfigurationComponent) {
			((CustomPIPConfigurationComponent)c).commit();
		}
		super.commit();
	}

	@Override
	public Class<?> getType() {
		return Collection.class;
	}

	@Override
	public void onFormChanged() {
		this.fireEvent(new com.vaadin.ui.Field.ValueChangeEvent(this));
	}

}
