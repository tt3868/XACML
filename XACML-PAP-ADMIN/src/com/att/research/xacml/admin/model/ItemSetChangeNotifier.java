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
package com.att.research.xacml.admin.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.EventObject;
import java.util.LinkedList;

import com.vaadin.data.Container;
import com.vaadin.data.Container.ItemSetChangeEvent;
import com.vaadin.data.Container.ItemSetChangeListener;

public class ItemSetChangeNotifier implements Container.ItemSetChangeNotifier {
	private static final long serialVersionUID = 1L;
    private Collection<Container.ItemSetChangeListener> itemSetChangeListeners = null;
    private Container container = null;
    
    public ItemSetChangeNotifier() {
    }
    
    protected void setContainer(Container c) {
    	this.container = c;
    }

	@Override
	public void addItemSetChangeListener(ItemSetChangeListener listener) {
        if (getItemSetChangeListeners() == null) {
            setItemSetChangeListeners(new LinkedList<Container.ItemSetChangeListener>());
        }
        getItemSetChangeListeners().add(listener);	}

	@Override
	public void addListener(ItemSetChangeListener listener) {
        addItemSetChangeListener(listener);
	}

	@Override
	public void removeItemSetChangeListener(ItemSetChangeListener listener) {
        if (getItemSetChangeListeners() != null) {
            getItemSetChangeListeners().remove(listener);
        }
    }

	@Override
	public void removeListener(ItemSetChangeListener listener) {
        removeItemSetChangeListener(listener);
	}
	
	
	protected static class BaseItemSetChangeEvent extends EventObject implements
	    Container.ItemSetChangeEvent, Serializable {
		private static final long serialVersionUID = 1L;

		protected BaseItemSetChangeEvent(Container source) {
		    super(source);
		}
		
		@Override
		public Container getContainer() {
		    return (Container) getSource();
		}
	}

    protected void setItemSetChangeListeners(
            Collection<Container.ItemSetChangeListener> itemSetChangeListeners) {
        this.itemSetChangeListeners = itemSetChangeListeners;
    }
    protected Collection<Container.ItemSetChangeListener> getItemSetChangeListeners() {
        return itemSetChangeListeners;
    }
   /**
     * Sends a simple Item set change event to all interested listeners,
     * indicating that anything in the contents may have changed (items added,
     * removed etc.).
     */
    protected void fireItemSetChange() {
        fireItemSetChange(new BaseItemSetChangeEvent(this.container));
    }

    /**
     * Sends an Item set change event to all registered interested listeners.
     * 
     * @param event
     *            the item set change event to send, optionally with additional
     *            information
     */
    protected void fireItemSetChange(ItemSetChangeEvent event) {
        if (getItemSetChangeListeners() != null) {
            final Object[] l = getItemSetChangeListeners().toArray();
            for (int i = 0; i < l.length; i++) {
                ((Container.ItemSetChangeListener) l[i])
                        .containerItemSetChange(event);
            }
        }
    }
}
