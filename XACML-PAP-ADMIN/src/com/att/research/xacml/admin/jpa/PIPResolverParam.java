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
package com.att.research.xacml.admin.jpa;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the PIPResolverParams database table.
 * 
 */
@Entity
@Table(name="PIPResolverParams")
@NamedQuery(name="PIPResolverParam.findAll", query="SELECT p FROM PIPResolverParam p")
public class PIPResolverParam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="PARAM_NAME", nullable=false, length=1024)
	private String paramName;

	@Column(name="PARAM_VALUE", nullable=false, length=2048)
	private String paramValue;

	@Column(name="PARAM_DEFAULT", nullable=true, length=2048)
	private String paramDefault;
		
	@Column(name="REQUIRED", nullable=false)
	private char required = '0';

	//bi-directional many-to-one association to PIPResolver
	@ManyToOne
	@JoinColumn(name="ID_RESOLVER")
	private PIPResolver pipresolver;

	public PIPResolverParam() {
	}

	public PIPResolverParam(String name) {
		this.paramName = name;
	}

	public PIPResolverParam(String name, String value) {
		this(name);
		this.paramValue = value;
	}

	public PIPResolverParam(PIPResolverParam param) {
		this(param.getParamName(), param.getParamValue());
		this.paramDefault = param.getParamDefault();
		this.required = param.required;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamValue() {
		return this.paramValue;
	}

	public void setParamValue(String paramValue) {
		this.paramValue = paramValue;
	}

	public String getParamDefault() {
		return paramDefault;
	}

	public void setParamDefault(String paramDefault) {
		this.paramDefault = paramDefault;
	}

	public char getRequired() {
		return required;
	}

	public void setRequired(char required) {
		this.required = required;
	}

	public PIPResolver getPipresolver() {
		return this.pipresolver;
	}

	public void setPipresolver(PIPResolver pipresolver) {
		this.pipresolver = pipresolver;
	}

	@Transient
	public boolean isRequired() {
		return this.required == '1';
	}
	
	@Transient
	public void setRequired(boolean required) {
		if (required) {
			this.required = '1';
		} else {
			this.required = '0';
		}
	}

	@Transient
	@Override
	public String toString() {
		return "PIPResolverParam [id=" + id + ", paramName=" + paramName
				+ ", paramValue=" + paramValue + ", required=" + required + "]";
	}

}