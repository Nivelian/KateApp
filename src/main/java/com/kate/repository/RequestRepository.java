package com.kate.repository;

import com.kate.domain.Request;
import com.kate.domain.User;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository for the Request entity.
 */
public interface RequestRepository extends JpaRepository<Request,Long> {

    /*@Query("select request from Request request where request.user.login = ?#{principal.username}")
    List<Request> findByUserIsCurrentUser();

    @Query("select distinct request from Request request left join fetch request.services")
    List<Request> findAllWithEagerRelationships();

    @Query("select request from Request request left join fetch request.services where request.id =:id")
    Request findOneWithEagerRelationships(@Param("id") Long id);*/
	
	/*@EntityGraph(attributePaths = "services")
    Request findOneWithServicesById(Long id);*/

}
