package com.att.research.xacml.admin.util;

import com.vaadin.ui.Notification;

/**
 * A simple mechanism for displaying messages to the user.
 * 
 * At the moment this is a very thin layer on top of the Vaadin Notification class.
 * There are two reasons for this class existing:
 * 	- simplifying (slightly) the code, in that the type is in the method call just like logging
 * 	- this is a central point where all messages are done, which allows us to globally change how they are displayed if we wish.
 * 
 * @author glenngriffin
 *
 */
public class AdminNotification  {
	//
	// PUBLIC STATIC METHODS
	//
	
	public static void info(String caption) {
		Notification.show(caption, Notification.Type.HUMANIZED_MESSAGE);
	}

	public static void warn(String caption) {
		Notification.show(caption, Notification.Type.WARNING_MESSAGE);
	}
	
	public static void error(String caption) {
		Notification.show(caption, Notification.Type.ERROR_MESSAGE);
	}
	



}
