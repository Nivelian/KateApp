package com.kate.repository.filter;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;

import com.kate.domain.Request;
import com.kate.domain.User;
import com.kate.security.AuthoritiesConstants;
import com.kate.security.SecurityUtils;

public class RequestSpecification {
	
	public static Specification<Request> build(User user){		
		Specification<Request> result = Specifications.where(filterByUser(user));	 
		return result;
	}
	
	private static Specification<Request> filterByUser(User user) {
		return (root, query, cb) -> user != null ? SecurityUtils.isCurrentUserInRole(AuthoritiesConstants.ADMIN) == false ? cb.equal(root.get("user"), user) : null : null;
	}

}