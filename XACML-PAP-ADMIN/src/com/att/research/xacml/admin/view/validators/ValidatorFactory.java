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
package com.att.research.xacml.admin.view.validators;

import com.att.research.xacml.admin.jpa.Datatype;
import com.att.research.xacml.api.XACML3;
import com.vaadin.data.Validator;

public class ValidatorFactory {

	public static Validator	newInstance(Datatype datatype) {
		
		if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_ANYURI)) {
			return new AnyURIValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_BASE64BINARY)) {
			return new Base64BinaryValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_BOOLEAN)) {
			return new BooleanValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_DATE)) {
			return new DateValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_DATETIME)) {
			return new DateTimeValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_DAYTIMEDURATION)) {
			return new DayTimeDurationValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_DNSNAME)) {
			return new DNSNameValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_DOUBLE)) {
			return new DoubleValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_HEXBINARY)) {
			return new HexBinaryValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_INTEGER)) {
			return new IntegerValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_IPADDRESS)) {
			return new IpAddressValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_RFC822NAME)) {
			return new RFC822NameValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_STRING)) {
			return new StringValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_TIME)) {
			return new TimeValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_X500NAME)) {
			return new X500NameValidator();
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_XPATHEXPRESSION)) {
			
		} else if (datatype.getIdentifer().equals(XACML3.ID_DATATYPE_YEARMONTHDURATION)) {
			return new YearMonthDurationValidator();
		}
		
		return null;
	}
}
