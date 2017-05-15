package com.kate.domain;


import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A Service.
 */
@Entity
@Table(name = "service")
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 30)
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @NotNull
    @Column(name = "is_square")
    private Boolean isSquare;
    
    @NotNull
    @Column(name = "cost")
    private BigDecimal cost;

    public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Service name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isIsSquare() {
        return isSquare;
    }

    public Service isSquare(Boolean isSquare) {
        this.isSquare = isSquare;
        return this;
    }

    public void setIsSquare(Boolean isSquare) {
        this.isSquare = isSquare;
    }

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service other = (Service) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isSquare == null) {
			if (other.isSquare != null)
				return false;
		} else if (!isSquare.equals(other.isSquare))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((isSquare == null) ? 0 : isSquare.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "Service [id=" + id + ", name=" + name + ", isSquare=" + isSquare + ", cost=" + cost + "]";
	}
}
