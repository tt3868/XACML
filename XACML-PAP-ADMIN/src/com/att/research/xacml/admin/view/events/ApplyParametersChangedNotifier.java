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
package com.att.research.xacml.admin.view.events;

import java.util.ArrayList;
import java.util.Collection;

import com.att.research.xacml.admin.jpa.FunctionArgument;

import oasis.names.tc.xacml._3_0.core.schema.wd_17.ApplyType;

public interface ApplyParametersChangedNotifier {

	public boolean	addListener(ApplyParametersChangedListener listener);
	
	public boolean	removeListener(ApplyParametersChangedListener listener);
	
	public void		fireEvent(ApplyType apply, ApplyType parent, FunctionArgument argument, Object container);
	
	public class BasicNotifier implements ApplyParametersChangedNotifier {
		Collection<ApplyParametersChangedListener> listeners = null;
		
		@Override
		public boolean addListener(ApplyParametersChangedListener listener) {
			if (this.listeners == null) {
				this.listeners = new ArrayList<ApplyParametersChangedListener>();
			}
			return this.listeners.add(listener);
		}

		@Override
		public boolean removeListener(ApplyParametersChangedListener listener) {
			if (this.listeners == null) {
				return false;
			}
			return this.listeners.remove(listener);
		}

		@Override
		public void fireEvent(ApplyType apply, ApplyType parent, FunctionArgument argument, Object container) {
			if (this.listeners == null) {
				return;
			}
			for (ApplyParametersChangedListener listener : this.listeners) {
				listener.applyParameterChanged(apply, parent, argument, container);
			}
		}
		
	}

}
