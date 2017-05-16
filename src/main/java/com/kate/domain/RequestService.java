package com.kate.domain;


import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A RequestService.
 */
@Entity
@Table(name = "request_service")
public class RequestService implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private RequestServiceId id;

	@Column(name = "square")
	private BigDecimal square;

	public RequestServiceId getId() {
		return id;
	}

	public void setId(RequestServiceId id) {
		this.id = id;
	}

	public BigDecimal getSquare() {
		return square;
	}

	public void setSquare(BigDecimal square) {
		this.square = square;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((square == null) ? 0 : square.hashCode());
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
		RequestService other = (RequestService) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (square == null) {
			if (other.square != null)
				return false;
		} else if (!square.equals(other.square))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RequestService [id=" + id + ", square=" + square + "]";
	}
	
	
}
