package com.reaosen.management_system.Service;

import com.reaosen.management_system.Annotation.AutoFill;
import com.reaosen.management_system.DTO.UserContributionDTO;
import com.reaosen.management_system.DTO.UserDTO;
import com.reaosen.management_system.DTO.PaginationDTO;
import com.reaosen.management_system.Enumeration.OperationType;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserService {
    PaginationDTO employeePagination(Integer sEcho, Integer iDisplayStart, Integer iDisplayLength, String sSearch);

    void updateStatusByAccountId(UserDTO userDTO);

    UserDTO getUserByAccountId(Integer accountId);

    Integer getWorkUsersCountByTime(String timeType);

    List<UserContributionDTO> getUsersWeeklyContribution();
}
