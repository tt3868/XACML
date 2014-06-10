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
package com.att.research.xacml.std.pap;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.att.research.xacml.api.pap.PDPPIPConfig;
import com.att.research.xacml.api.pap.PDPPolicy;
import com.att.research.xacml.api.pap.PDPStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class StdPDPStatus implements Serializable, PDPStatus {
	private static final long serialVersionUID = 1L;
	
	private Status status = Status.UNKNOWN;

	private Set<String>	loadErrors = new HashSet<String>();
	
	private Set<String> loadWarnings = new HashSet<String>();
	
	private Set<PDPPolicy> loadedPolicies = new HashSet<PDPPolicy>();
	
	private Set<PDPPolicy> loadedRootPolicies = new HashSet<PDPPolicy>();
	
	private Set<PDPPolicy> failedPolicies = new HashSet<PDPPolicy>();
	
	private Set<PDPPIPConfig>	loadedPIPConfigs = new HashSet<PDPPIPConfig>();
	
	private Set<PDPPIPConfig>	failedPIPConfigs = new HashSet<PDPPIPConfig>();
	
	public StdPDPStatus() {
	}
	
	
	

	public void set(StdPDPStatus newStatus) {
		this.status				=	newStatus.status;
		this.loadErrors			=	newStatus.loadErrors;
		this.loadWarnings		=	newStatus.loadWarnings;
		this.loadedPolicies		=	newStatus.loadedPolicies;
		this.failedPolicies		=	newStatus.failedPolicies;
		this.loadedPIPConfigs	=	newStatus.loadedPIPConfigs;
		this.failedPIPConfigs	=	newStatus.failedPIPConfigs;
	}
	
	

	@Override
	public Status getStatus() {
		return this.status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	@Override
	public Set<String> getLoadErrors() {
		return Collections.unmodifiableSet(this.loadErrors);
	}

	public void setLoadErrors(Set<String> errors) {
		this.loadErrors = errors;
	}
	
	public void addLoadError(String error) {
		this.loadErrors.add(error);
	}

	@Override
	public Set<String> getLoadWarnings() {
		return Collections.unmodifiableSet(this.loadWarnings);
	}

	public void setLoadWarnings(Set<String> warnings) {
		this.loadWarnings = warnings;
	}
	
	public void addLoadWarning(String warning) {
		this.loadWarnings.add(warning);
	}

	@Override
	public Set<PDPPolicy> getLoadedPolicies() {
		return Collections.unmodifiableSet(this.loadedPolicies);
	}
	
	public void setLoadedRootPolicies(Set<PDPPolicy> policies) {
		this.loadedRootPolicies = policies;
	}
	
	public void addAllLoadedRootPolicies(Set<PDPPolicy> policies) {
		this.loadedRootPolicies.addAll(policies);
	}
	
	public void addLoadedPolicy(PDPPolicy policy) {
		this.loadedPolicies.add(policy);
	}
	
	@Override
	public Set<PDPPolicy> getLoadedRootPolicies() {
		return Collections.unmodifiableSet(this.loadedRootPolicies);
	}
	
	public void setLoadedPolicies(Set<PDPPolicy> policies) {
		this.loadedPolicies = policies;
	}
	

	@Override
	public Set<PDPPolicy> getFailedPolicies() {
		return Collections.unmodifiableSet(this.failedPolicies);
	}
	
	public void addFailedPolicy(PDPPolicy policy) {
		this.failedPolicies.add(policy);
	}

	@Override
	public boolean policiesOK() {
		if (this.failedPolicies.size() > 0) {
			return false;
		}
		return true;
	}

	@Override
	public Set<PDPPIPConfig> getLoadedPipConfigs() {
		return Collections.unmodifiableSet(this.loadedPIPConfigs);
	}
	
	public void addLoadedPipConfig(PDPPIPConfig config) {
		this.loadedPIPConfigs.add(config);
	}

	@Override
	public Set<PDPPIPConfig> getFailedPipConfigs() {
		return Collections.unmodifiableSet(this.failedPIPConfigs);
	}
	
	public void addFailedPipConfig(PDPPIPConfig config) {
		this.failedPIPConfigs.add(config);
	}

	@Override
	public boolean pipConfigOK() {
		if (this.failedPIPConfigs.size() > 0) {
			return false;
		}
		return true;
	}

	@Override
	@JsonIgnore
	public boolean isOk() {
		if (this.policiesOK() == false) {
			return false;
		}
		if (this.pipConfigOK() == false) {
			return false;
		}
		return (this.status == Status.UP_TO_DATE);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ (failedPIPConfigs.hashCode());
		result = prime * result
				+ (failedPolicies.hashCode());
		result = prime * result
				+ (loadErrors.hashCode());
		result = prime * result
				+ (loadWarnings.hashCode());
		result = prime
				* result
				+ (loadedPIPConfigs.hashCode());
		result = prime * result
				+ (loadedPolicies.hashCode());
		result = prime * result + (status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StdPDPStatus other = (StdPDPStatus) obj;
		if (!failedPIPConfigs.equals(other.failedPIPConfigs))
			return false;
		if (!failedPolicies.equals(other.failedPolicies))
			return false;
		if (!loadErrors.equals(other.loadErrors))
			return false;
		if (!loadWarnings.equals(other.loadWarnings))
			return false;
		if (!loadedPIPConfigs.equals(other.loadedPIPConfigs))
			return false;
		if (!loadedPolicies.equals(other.loadedPolicies))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StdPDPStatus [status=" + status + ", loadErrors=" + loadErrors
				+ ", loadWarnings=" + loadWarnings + ", loadedPolicies="
				+ loadedPolicies + ", loadedRootPolicies=" + loadedRootPolicies 
				+ ", failedPolicies=" + failedPolicies
				+ ", loadedPIPConfigs=" + loadedPIPConfigs
				+ ", failedPIPConfigs=" + failedPIPConfigs + "]";
	}


}
