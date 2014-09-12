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
package com.att.research.xacml.admin;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Handle Notifications from the PAP that the PDP Groups have been changed.
 * We need a Server Push Broadcaster because there may be multiple Vaadin instances (i.e. Users) that need to be told when a change occurs.
 * 
 * Initially we only update the entire set of PDPGroups in one shot.
 * 
 * (Code copied from Book of Vaadin chapter on Server Push
 * @author glenngriffin
 *
 */
public class PAPNotificationBroadcaster implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2539940306348821754L;


	private static Log logger	= LogFactory.getLog(PAPNotificationBroadcaster.class);

	
    static ExecutorService executorService = Executors.newSingleThreadExecutor();

    /**
     * Interface used by all classes that need to be notified when PAP sends an update message.
     * 
     * @author glenngriffin
     *
     */
    public interface PAPNotificationBroadcastListener {
        void updateAllGroups();
    }
    
    
    
    /*
     * list of registered listeners
     */
    private static LinkedList<PAPNotificationBroadcastListener> listeners =
        new LinkedList<PAPNotificationBroadcastListener>();
    
    /**
     * Listener registers to hear about updates.
     * @param listener
     */
    public static synchronized void register(
    		PAPNotificationBroadcastListener listener) {
        listeners.add(listener);
    }
    
    
    /**
     * Listener is going away.
     * 
     * @param listener
     */
    public static synchronized void unregister(
    		PAPNotificationBroadcastListener listener) {
        listeners.remove(listener);
    }
    
    
    
    /**
     * Tell all listeners about an update.
     * 
     * @param message
     */
    public static synchronized void updateAllGroups() {
        for (final PAPNotificationBroadcastListener listener: listeners) {
  // Original code copied from example:
  //          executorService.execute(new Runnable() {
  //              @Override
  //              public void run() {
  // The problem with this is that the execute starts a new Thread, but the thing we are calling (the listener.updateAllGroups)
  // happens in this case to ALSO create a new thread, and it locks up because the shared threadpool queue is already locked by this method.
  // On application shutdown that left us with a blocked thread, so the process never goes away.
  // Since the listener.updateAllGroups does ALL of its work inside a new Runnable thread, there should be no need for this method to also create a thread.
  
        	/*
        	 * IMPORTANT:
        	 * All listeners MUST either execute with no possibility of blocking
        	 * OR must start their own threads to handle blocking and concurrent operations.
        	 */
        	if (logger.isDebugEnabled()) {
        		logger.debug("updateAllGroups");
        	}
            listener.updateAllGroups();
        }
    }
}
