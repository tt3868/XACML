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
package com.att.research.xacmlatt.pdp.std;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.att.research.xacml.api.Request;
import com.att.research.xacml.api.pip.PIPFinder;
import com.att.research.xacml.api.pip.PIPFinderFactory;
import com.att.research.xacml.api.trace.TraceEngine;
import com.att.research.xacml.api.trace.TraceEngineFactory;
import com.att.research.xacmlatt.pdp.eval.EvaluationContext;
import com.att.research.xacmlatt.pdp.eval.EvaluationContextFactory;
import com.att.research.xacmlatt.pdp.policy.PolicyFinder;
import com.att.research.xacmlatt.pdp.policy.PolicyFinderFactory;

/**
 * StdEvaluationContextFactory extends {@link com.att.research.xacmlatt.pdp.eval.EvaluationContextFactory} to implement
 * the <code>getEvaluationContext</code> method with a standard {@link com.att.research.xacmlatt.pdp.eval.EvaluationContext}.
 * 
 * @author car
 * @version $Revision: 1.1 $
 */
public class StdEvaluationContextFactory extends EvaluationContextFactory {
	private Log logger					= LogFactory.getLog(this.getClass());
	private PolicyFinder policyFinder;
	private PIPFinder pipFinder;
	private TraceEngine traceEngine;
	
	protected PolicyFinder getPolicyFinder() {
		if (this.policyFinder == null) {
			synchronized(this) {
				if (this.policyFinder == null) {
					try {
						PolicyFinderFactory policyFinderFactory	= PolicyFinderFactory.newInstance();
						this.policyFinder	= policyFinderFactory.getPolicyFinder();
					} catch (Exception ex) {
						this.logger.error("Exception getting PolicyFinder: " + ex.getMessage(), ex);
					}
				}
			}
		}
		return this.policyFinder;
	}
	
	protected PIPFinder getPIPFinder() {
		if (this.pipFinder == null) {
			synchronized(this) {
				if (this.pipFinder == null) {
					try {
						PIPFinderFactory pipFinderFactory	= PIPFinderFactory.newInstance();
						this.pipFinder						= pipFinderFactory.getFinder();
					} catch (Exception ex) {
						this.logger.error("Exception getting PIPFinder: " + ex.toString(), ex);
					}
				}
			}
		}
		return this.pipFinder;
	}
	
	protected TraceEngine getTraceEngine() {
		if (this.traceEngine == null) {
			synchronized(this) {
				if (this.traceEngine == null) {
					try {
						TraceEngineFactory traceEngineFactory	= TraceEngineFactory.newInstance();
						this.traceEngine	= traceEngineFactory.getTraceEngine();
					} catch (Exception ex) {
						this.logger.error("Exception getting TraceEngine: " + ex.toString(), ex);
					}
				}
			}
		}
		return this.traceEngine;
	}
	
	public StdEvaluationContextFactory() {
	}

	@Override
	public EvaluationContext getEvaluationContext(Request request) {
		return new StdEvaluationContext(request, this.getPolicyFinder(), this.getPIPFinder(), this.getTraceEngine());
	}

	@Override
	public void setPolicyFinder(PolicyFinder policyFinderIn) {
		this.policyFinder	= policyFinderIn;
	}

	@Override
	public void setPIPFinder(PIPFinder pipFinderIn) {
		this.pipFinder		= pipFinderIn;
	}

}
