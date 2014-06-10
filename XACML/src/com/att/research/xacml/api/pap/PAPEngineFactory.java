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
package com.att.research.xacml.api.pap;

import com.att.research.xacml.util.FactoryException;
import com.att.research.xacml.util.FactoryFinder;

public abstract class PAPEngineFactory {
	// Default to the PAP version of the PAP Engine, not the RESTful version
//	private static final String	FACTORYID	= XACMLProperties.PROP_PAP_PAPENGINEFACTORY;
//	private static final String	DEFAULT_FACTORY_CLASSNAME	= "com.att.research.xacml.std.pap.StdEngineFactory";
	
	/**
	 * The constructor is protected to prevent instantiation of the class.
	 */
	protected PAPEngineFactory() {
	}
	
//
// Because there are 2 types of PAPEngine (the PAP version that works with files and the AC RESTful version that uses
// a RESTful interface to communicate with the PAP servlet) it is important for the caller to know which kind
// they are working with.
// Also, the AC RESTfulPAPEngine cannot be found by the default XACML FactoryFinder because it is packaged in a WAR file
// that is not part of the base code.
// To reduce confusion we do not provide a default PAPEngineFactory.  The calling code must explicitly identify which one they want.
// When getting the RESTfulPAPEngineFactory the caller must also include an appropriate ClassLoader.
//
//	/**
//	 * Creates a new <code>PAPEngineFactory</code> instance by examining initialization resources from
//	 * various places to determine the class to instantiate and return.
//	 * 
//	 * @return an instance of an object that extends <code>PAPEngineFactory</code> to use in creating <code>PAPEngine</code> objects.
//	 */
//	public static PAPEngineFactory newInstance() throws FactoryException {
//		return FactoryFinder.find(FACTORYID, DEFAULT_FACTORY_CLASSNAME, PAPEngineFactory.class);
//	}
	
	/**
	 * Creates a new <code>PAPEngineFactory</code> instance using the given class name and <code>ClassLoader</code>.  If the
	 * <code>ClassLoader</code> is null, use the default thread class loader.
	 * 
	 * @param factoryClassName the <code>String</code> name of the factory class to instantiate
	 * @param classLoader the <code>ClassLoader</code> to use to load the factory class
	 * @return an instance of an object that extends <code>PAPEngineFactory</code> to use in creating <code>PAPEngine</code> objects.
	 */
	public static PAPEngineFactory newInstance(String factoryClassName, ClassLoader classLoader) throws FactoryException {
		return FactoryFinder.newInstance(factoryClassName, PAPEngineFactory.class, classLoader, false);
	}
	
	/**
	 * Creates a new <code>PAPEngineFactory</code> instance using the given class name and the default thread class loader.
	 * 
	 * @param factoryClassName the <code>String</code> name of the factory class to instantiate
	 * @return an instance of an object that extends <code>PAPEngineFactory</code> to use in creating <code>PAPEngine</code> objects.
	 */
	public static PAPEngineFactory newInstance(String factoryClassName) throws FactoryException {
		return FactoryFinder.newInstance(factoryClassName, PAPEngineFactory.class, null, true);
	}
	
	/**
	 * Creates a new <code>PAPEngine</code> based on the configured <code>PAPEngineFactory</code>.
	 * 
	 * @param myURLString - optional parameter needed by some PAPEngines and not others
	 * @return a new <code>PAPEngine</code>
	 * @throws PAPException 
	 */
	public abstract PAPEngine newEngine(String myURLString) throws FactoryException, PAPException;

}
