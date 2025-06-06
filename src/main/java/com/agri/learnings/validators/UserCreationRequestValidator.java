package com.agri.learnings.validators;

import com.agri.learnings.exception.CommonException;
import com.agri.learnings.exception.PasswordMisMatchException;
import com.agri.learnings.request.CommonRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class UserCreationRequestValidator {
    public static void validateRequest(CommonRequest commonRequest) {
        if (!StringUtils.isNotBlank(commonRequest.getPassword())) {
            throw new CommonException("Password should not be empty or null");
        }

        if (!StringUtils.isNotBlank(commonRequest.getConfirmPassword())) {
            throw new CommonException("Confirm Password should not be empty or null");
        }

        if (!commonRequest.getPassword().equalsIgnoreCase(commonRequest.getConfirmPassword())) {
            throw new PasswordMisMatchException("Password and Confirm Password are not matched");
        }

        if (!StringUtils.isNotBlank(commonRequest.getUsername())) {
            throw new CommonException("Username should not be empty or null");
        }

        if (!StringUtils.isNotBlank(commonRequest.getContactNumber())) {
            throw new CommonException("Contact Number should not be empty or null");
        }

        if (!StringUtils.isNotBlank(commonRequest.getEmail())) {
            throw new CommonException("Email should not be empty or null");
        }
        if (!validateMobileNumber(commonRequest.getContactNumber())) {
            throw new CommonException("Mobile Number Format is incorrect");
        }
        if (!validateEmail(commonRequest.getEmail())) {
            throw new CommonException("Email is Incorrect");
        }

    }

    private static boolean validateEmail(String email) {
        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    private static boolean validateMobileNumber(String contactNumber) {
        String INDIAN_MOBILE_REGEX = "^(\\+91[\\-\\s]?)?[6789]\\d{9}$";
        if (contactNumber == null || contactNumber.trim().isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(INDIAN_MOBILE_REGEX);
        Matcher matcher = pattern.matcher(contactNumber);
        return matcher.matches();
    }
}
