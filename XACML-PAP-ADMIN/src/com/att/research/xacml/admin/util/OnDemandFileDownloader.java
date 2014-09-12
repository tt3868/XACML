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
package com.att.research.xacml.admin.util;

import java.io.IOException;

import com.vaadin.server.FileDownloader;
import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamResource.StreamSource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.ui.UI;

public class OnDemandFileDownloader extends FileDownloader {
	private static final long serialVersionUID = 1L;
	private final OnDemandStreamResource resource;

	public interface OnDemandStreamResource extends StreamSource {
		String getFilename ();
	}

  public OnDemandFileDownloader(OnDemandStreamResource resource) {
		super(new StreamResource(resource, ""));
		this.resource = resource;
		if (this.resource == null) {
			throw new NullPointerException("Can't send null resource");
		}
	}

	@Override
	public boolean handleConnectorRequest(VaadinRequest request,
			VaadinResponse response, String path) throws IOException {
		this.getResource().setFilename(this.resource.getFilename());
		return super.handleConnectorRequest(request, response, path);
	}

	private StreamResource getResource() {
		StreamResource resource = null;
		UI.getCurrent().getSession().lock();
		try {
			resource = (StreamResource) this.getResource("dl");
		} finally {
			UI.getCurrent().getSession().unlock();
		}
		return resource;
	}
}
