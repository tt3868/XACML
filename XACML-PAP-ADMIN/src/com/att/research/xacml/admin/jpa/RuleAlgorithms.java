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
package com.att.research.xacml.admin.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.att.research.xacml.api.Identifier;

@Entity
@Table(name="RuleAlgorithms")
@NamedQuery(name="RuleAlgorithms.findAll", query="SELECT d FROM RuleAlgorithms d")
public class RuleAlgorithms implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final char STANDARD = 'S';
	public static final char CUSTOM = 'C';

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="is_standard", nullable=false)
	private char isStandard;

	@Column(name="xacml_id", nullable=false, unique=true, length=255)
	private String xacmlId;
	
	@Column(name="short_name", nullable=false, length=64)
	private String shortName;

	public RuleAlgorithms(Identifier id, char standard) {
		if (id != null) {
			this.xacmlId = id.stringValue();
		}
		this.isStandard = standard;
	}
	public RuleAlgorithms(Identifier id) {
		this(id, RuleAlgorithms.STANDARD);
	}

	public RuleAlgorithms() {
		this(null, RuleAlgorithms.STANDARD);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public char getIsStandard() {
		return this.isStandard;
	}

	public void setIsStandard(char isStandard) {
		this.isStandard = isStandard;
	}
	
	@Transient
	public boolean isStandard() {
		return (this.isStandard == RuleAlgorithms.STANDARD);
	}
	
	@Transient
	public boolean isCustom() {
		return (this.isStandard == RuleAlgorithms.CUSTOM);
	}

	public String getXacmlId() {
		return this.xacmlId;
	}

	public void setXacmlId(String xacmlId) {
		this.xacmlId = xacmlId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

}
