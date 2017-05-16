package com.kate.domain;

import java.io.Serializable;

public class RequestServiceId implements Serializable {
	private static final long serialVersionUID = -5182930776321592367L;
	
	private Long request;
	
	private Long service;

	public Long getRequest() {
		return request;
	}

	public void setRequest(Long request) {
		this.request = request;
	}

	public Long getService() {
		return service;
	}

	public void setService(Long service) {
		this.service = service;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((request == null) ? 0 : request.hashCode());
		result = prime * result + ((service == null) ? 0 : service.hashCode());
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
		RequestServiceId other = (RequestServiceId) obj;
		if (request == null) {
			if (other.request != null)
				return false;
		} else if (!request.equals(other.request))
			return false;
		if (service == null) {
			if (other.service != null)
				return false;
		} else if (!service.equals(other.service))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequestServiceId [request=" + request + ", service=" + service + "]";
	}

	
}
