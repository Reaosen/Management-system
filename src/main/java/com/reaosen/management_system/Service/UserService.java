package com.reaosen.management_system.Service;

import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.DTO.PaginationDTO;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserService {
    PaginationDTO employeePagination(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch);

    void updateStatusByAccountId(UserDTO userDTO);

    PaginationDTO employeeWorkPagination(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch);
}
