package com.hungpham.ecommerce.controller;

import com.hungpham.ecommerce.exception.BusinessErrorCode;
import com.hungpham.ecommerce.exception.BusinessException;
import com.hungpham.ecommerce.exception.ErrorCode;
import com.hungpham.ecommerce.model.response.ErrorResponse;
import com.hungpham.ecommerce.util.RequestLOG;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<ErrorResponse> beHandler(HttpServletRequest request, BusinessException ex) {
        return makeResponseError(request, ex.getErrorCode(), ex);
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> meHandler(HttpServletRequest request, MethodArgumentTypeMismatchException ex) {
        return makeResponseError(request, ErrorCode.INPUT_DATA_FORMAT_ERROR, ex);
    }

    private ResponseEntity<ErrorResponse> makeResponseError(HttpServletRequest request, BusinessErrorCode errorCode, Throwable ex) {
        ErrorResponse err = createErrorResponse(request, errorCode, ex);
        return new ResponseEntity<>(err, HttpStatus.valueOf(errorCode.httpStatus()));
    }

    private ErrorResponse createErrorResponse(HttpServletRequest request, BusinessErrorCode errorCode, Throwable ex) {
        ErrorResponse errResp;
        if (ex == null) {
            errResp = new ErrorResponse(errorCode.code(), errorCode.description());
        } else {
            errResp = new ErrorResponse(errorCode.code(), errorCode.description(), ex.getMessage());
        }
        RequestLOG.error(request, errorCode.httpStatus(), errResp, ex);
        return errResp;
    }
}
