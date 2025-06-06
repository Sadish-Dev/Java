package com.agri.learnings.service;

import com.agri.learnings.request.CommonRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Object> saveUserDetails(CommonRequest commonRequest);

    ResponseEntity<Object> login(CommonRequest commonRequest);
}
