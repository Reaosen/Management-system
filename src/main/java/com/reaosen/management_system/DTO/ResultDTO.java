package com.reaosen.management_system.DTO;

import com.reaosen.management_system.Exception.CustomizeErrorCode;
import com.reaosen.management_system.Exception.CustomizeException;
import lombok.Data;

@Data
public class ResultDTO<T> {
    private Integer code;
    private String message;
    private T data;
    private Integer status;

    public static ResultDTO errorOf(Integer code, String massage, Integer status){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMessage(massage);
        resultDTO.setStatus(status);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeErrorCode errorCode, Integer status) {
        return errorOf(errorCode.getCode(), errorCode.getMessage(), status);
    }

    public static ResultDTO okOf(){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        resultDTO.setStatus(200);
        return resultDTO;
    }
    public static <T> ResultDTO okOf(T t){
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(200);
        resultDTO.setMessage("请求成功");
        resultDTO.setData(t);
        resultDTO.setStatus(200);
        return resultDTO;
    }

    public static ResultDTO errorOf(CustomizeException ex) {
        return errorOf(ex.getCode(), ex.getMessage(), ex.getHttpStatus());
    }
}
