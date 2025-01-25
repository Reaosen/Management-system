package com.reaosen.management_system.Controller;

import com.reaosen.management_system.DTO.ResultDTO;
import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.Exception.CustomizeException;
import com.reaosen.management_system.Service.IndexService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class indexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @ResponseBody
    public Object index(@RequestBody UserDTO userDTO, HttpServletResponse response, HttpSession session) {
        try {
            UserDTO user = (UserDTO) indexService.index(userDTO);
            session.setAttribute("user", user);
            return ResponseEntity.ok(ResultDTO.okOf());
        } catch (CustomizeException ex) {
            ResultDTO resultDTO = ResultDTO.errorOf(ex);
            return new ResponseEntity<>(resultDTO, HttpStatus.valueOf(ex.getHttpStatus()));
        }
    }
}
