package com.example.jpawhere.entity;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

public class ProcessService {
    public List<Process> getAllBy() {
        Page<Process> repositoryReturn = new PageImpl<>(List.of());
        return getFiltered(repositoryReturn);
    }


    public List<Process> getFiltered(Page<Process> result) {
        // UserDto authenticatedUser = userService.getAuthenticatedUserDto();
        List<CompanyRole> userRole = List.of();
        return result.filter(process -> process.canAccessRoles(true,userRole)).stream().toList();
    }
}
