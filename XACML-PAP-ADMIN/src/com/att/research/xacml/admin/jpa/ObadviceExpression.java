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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the ObadviceExpressions database table.
 * 
 */
@Entity
@Table(name="ObadviceExpressions")
@NamedQuery(name="ObadviceExpression.findAll", query="SELECT o FROM ObadviceExpression o")
public class ObadviceExpression implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String EXPRESSION_APPLY = "Apply";
	public static final String EXPRESSION_SELECTOR = "Attribute Selector";
	public static final String EXPRESSION_VALUE = "Attribute Value";
	public static final String EXPRESSION_FUNCTION = "Function";
	public static final String EXPRESSION_REFERENCE = "Varable Reference";
	public static final String EXPRESSION_DESIGNATOR = "Attribute Designator";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;

	//unidirectional one-to-one association to Attribute
	@OneToOne
	@JoinColumn(name="attribute_id")
	private Attribute attribute;

	@Column(name="type", nullable=false)
	private String type;
	
	/*
	@Lob
	@Column(name="expression", nullable=false)
	private byte[] expression;
	*/

	//bi-directional many-to-one association to Obadvice
	@ManyToOne
	@JoinColumn(name="obadvice_id")
	private Obadvice obadvice;

	public ObadviceExpression() {
		type = EXPRESSION_VALUE;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Attribute getAttribute() {
		return this.attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Obadvice getObadvice() {
		return this.obadvice;
	}

	public void setObadvice(Obadvice obadvice) {
		this.obadvice = obadvice;
	}

	public ObadviceExpression clone() {
		ObadviceExpression expression = new ObadviceExpression();
		
		expression.attribute = this.attribute;
		expression.type = this.type;
		expression.obadvice = this.obadvice;
		
		return expression;
	}
}