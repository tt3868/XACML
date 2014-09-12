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

import com.att.research.xacml.admin.jpa.Attribute;
import com.vaadin.addon.jpacontainer.EntityItem;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.OptionGroup;

public class DesignatorSelectorField extends CustomField<Object> {
	private static final long serialVersionUID = 1L;
	private final DesignatorSelectorField self = this;
	private final OptionGroup selectDesignator = new OptionGroup("Type of attribute");

	public DesignatorSelectorField(EntityItem<Attribute> attributeEntity) {
		this.selectDesignator.setImmediate(true);
		this.selectDesignator.addItem(Attribute.ATTRIBUTE_DESIGNATOR);
		this.selectDesignator.addItem(Attribute.ATTRIBUTE_SELECTOR);
		if (attributeEntity.getEntity().isDesignator()) {
			this.selectDesignator.select(Attribute.ATTRIBUTE_DESIGNATOR);
		} else {
			this.selectDesignator.select(Attribute.ATTRIBUTE_SELECTOR);
		}
		//
		// Listen when designator vs selector changes
		//
		this.selectDesignator.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(
					com.vaadin.data.Property.ValueChangeEvent event) {
				Object value = self.selectDesignator.getValue();
				if (value != null) {
					if (value.toString().equals(Attribute.ATTRIBUTE_DESIGNATOR)) {
						self.setValue('1');
					} else if (value.toString().equals(Attribute.ATTRIBUTE_SELECTOR)) {
						self.setValue('0');
					}
				}
			}
		});
	}

	@Override
	protected Component initContent() {
		return this.selectDesignator;
	}

	@Override
	public Class<? extends Object> getType() {
		return Character.class;
	}

}
