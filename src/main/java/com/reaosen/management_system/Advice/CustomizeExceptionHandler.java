package com.reaosen.management_system.Advice;

import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.Exception.CustomizeErrorCode;
import com.reaosen.management_system.Exception.CustomizeException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizeExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handle(Throwable ex, HttpServletRequest request) {
        String contentType = request.getContentType();
        if ("application/json".equals(contentType)) {
            if (ex instanceof CustomizeException) {
                CustomizeException customizeException = (CustomizeException) ex;
                ResultDTO resultDTO = (ResultDTO) ResultDTO.errorOf(customizeException);
                return new ResponseEntity<>(resultDTO, HttpStatus.valueOf(customizeException.getCode()));
            } else {
                ResultDTO resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR, 500);
                return new ResponseEntity<>(resultDTO, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            if (ex instanceof CustomizeException) {
                ModelAndView modelAndView = new ModelAndView("error");
                modelAndView.addObject("message", ex.getMessage());
                return new ResponseEntity<>(modelAndView, HttpStatus.valueOf(((CustomizeException) ex).getCode()));
            } else {
                ModelAndView modelAndView = new ModelAndView("error");
                modelAndView.addObject("message", CustomizeErrorCode.SYS_ERROR.getMessage());
                return new ResponseEntity<>(modelAndView, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }
}