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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the ObadviceExpressions database table.
 * 
 */
@Entity
@Table(name="AttributeAssignment")
@NamedQuery(name="AttributeAssignment.findAll", query="SELECT a FROM AttributeAssignment a")
public class AttributeAssignment implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String EXPRESSION_APPLY = "Apply";
	public static final String EXPRESSION_SELECTOR = "AttributeSelector";
	public static final String EXPRESSION_VALUE = "AttributeValue";
	public static final String EXPRESSION_FUNCTION = "Function";
	public static final String EXPRESSION_REFERENCE = "VarableReference";
	public static final String EXPRESSION_DESIGNATOR = "AttributeDesignator";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	@Column(name="attribute_id")
	private int attributeId;

	//bi-directional many-to-one association to Obadvice
	@Column(name="expression", nullable=false)
	private String expression;

	//bi-directional many-to-one association to Obadvice
	@ManyToOne
	private Obadvice obadvice;

	public AttributeAssignment() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAttributeId() {
		return this.attributeId;
	}

	public void setAttributeId(int attributeId) {
		this.attributeId = attributeId;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}
}