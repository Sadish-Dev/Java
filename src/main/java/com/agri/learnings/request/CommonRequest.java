package com.agri.learnings.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class CommonRequest {

    private String username;
    private String password;
    private String confirmPassword;
    private String email;
    private String contactNumber;
    private String otp;

}
