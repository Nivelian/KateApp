package com.kate.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.kate.domain.Request;
import com.kate.domain.RequestService;
import com.kate.domain.RequestServiceId;
import com.kate.domain.User;
import com.kate.repository.RequestRepository;
import com.kate.repository.RequestServiceRepository;
import com.kate.repository.UserRepository;
import com.kate.repository.filter.RequestSpecification;
import com.kate.security.SecurityUtils;
import com.kate.web.rest.util.HeaderUtil;
import com.kate.web.rest.util.PaginationUtil;
import io.swagger.annotations.ApiParam;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Request.
 */
@RestController
@RequestMapping("/api")
public class RequestResource {

    private final Logger log = LoggerFactory.getLogger(RequestResource.class);

    private static final String ENTITY_NAME = "request";
        
    private final RequestRepository requestRepository;
    
    private final UserRepository userRepository;
    
    private final RequestServiceRepository requestServiceRepository;

    public RequestResource(RequestRepository requestRepository, UserRepository userRepository, RequestServiceRepository requestServiceRepository) {
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.requestServiceRepository = requestServiceRepository;
    }

    /**
     * POST  /requests : Create a new request.
     *
     * @param request the request to create
     * @return the ResponseEntity with status 201 (Created) and with body the new request, or with status 400 (Bad Request) if the request has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/requests")
    @Timed
    public ResponseEntity<Request> createRequest(@Valid @RequestBody Request request) throws URISyntaxException {
        log.debug("REST request to save Request : {}", request);
        if (request.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new request cannot already have an ID")).body(null);
        }
        
        // Set current User
        String currentLogin = SecurityUtils.getCurrentUserLogin();
        Optional<User> currentUser = userRepository.findOneByLogin(currentLogin);
        if(currentUser.isPresent() == Boolean.TRUE)
        	request.setUser(currentUser.get());
        
        // Set current date
        request.setLastModifiedDate(ZonedDateTime.now());
        
        // Save request
        Request result = requestRepository.save(request);
        
        // Save square value in request_service table
        if(result != null)
        	request.getServices().forEach(item -> {
	        	RequestService requestService = new RequestService(result.getId(), item.getId(), item.getSquare());
	        	requestServiceRepository.save(requestService);
	        });
        
        return ResponseEntity.created(new URI("/api/requests/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /requests : Updates an existing request.
     *
     * @param request the request to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated request,
     * or with status 400 (Bad Request) if the request is not valid,
     * or with status 500 (Internal Server Error) if the request couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/requests")
    @Timed
    public ResponseEntity<Request> updateRequest(@Valid @RequestBody Request request) throws URISyntaxException {
        log.debug("REST request to update Request : {}", request);
        if (request.getId() == null) {
            return createRequest(request);
        }
        
        // Set current User
        String currentLogin = SecurityUtils.getCurrentUserLogin();
        Optional<User> currentUser = userRepository.findOneByLogin(currentLogin);
        if(currentUser.isPresent() == Boolean.TRUE)
        	request.setUser(currentUser.get());
        
        // Set current date
        request.setLastModifiedDate(ZonedDateTime.now());
        
        // Update request
        Request result = requestRepository.save(request);
        
        // Update square value in request_service table
        if(result != null)
        	request.getServices().forEach(item -> {
	        	RequestService requestService = new RequestService(result.getId(), item.getId(), item.getSquare());
	        	requestServiceRepository.save(requestService);
	        });
        
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, request.getId().toString()))
            .body(result);
    }

    /**
     * GET  /requests : get all the requests.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of requests in body
     */
    @GetMapping("/requests")
    @Timed
    public ResponseEntity<List<Request>> getAllRequests(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Requests");
        String login = SecurityUtils.getCurrentUserLogin();
        Optional<User> optUser = userRepository.findOneByLogin(login);
        User user = null;
        if(optUser.isPresent() == Boolean.TRUE) {
        	user = optUser.get();
        }
        Specification<Request> spec = RequestSpecification.build(user);
        Page<Request> page = requestRepository.findAll(spec, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/requests");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /requests/:id : get the "id" request.
     *
     * @param id the id of the request to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the request, or with status 404 (Not Found)
     */
    @GetMapping("/requests/{id}")
    @Timed
    public ResponseEntity<Request> getRequest(@PathVariable Long id) {
        log.debug("REST request to get Request : {}", id);
        Request request = requestRepository.findOne(id);
        
        // Set square for services
        if(request != null)
	        request.getServices().forEach(item -> {
	        	RequestServiceId requestServiceId = new RequestServiceId(request.getId(), item.getId());
	        	RequestService requestService = requestServiceRepository.findOne(requestServiceId);
	        	item.setSquare(requestService.getSquare());
	        });
        
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(request));
    }

    /**
     * DELETE  /requests/:id : delete the "id" request.
     *
     * @param id the id of the request to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/requests/{id}")
    @Timed
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        log.debug("REST request to delete Request : {}", id);
        requestRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }

}
