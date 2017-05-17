package com.kate.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RequestServiceId implements Serializable {
	private static final long serialVersionUID = -5182930776321592367L;
	
	@Column(name = "request_id")
	private Long requestId;
	
	@Column(name = "service_id")	
	private Long serviceId;
	
	public RequestServiceId() {
		
	}
	
	public RequestServiceId(Long requestId, Long serviceId) {
		this.requestId = requestId;
		this.serviceId = serviceId;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
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
		if (requestId == null) {
			if (other.requestId != null)
				return false;
		} else if (!requestId.equals(other.requestId))
			return false;
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequestServiceId [requestId=" + requestId + ", serviceId=" + serviceId + "]";
	}

	
}
