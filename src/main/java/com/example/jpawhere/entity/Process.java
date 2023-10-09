package com.example.jpawhere.entity;

import java.util.List;
import java.util.stream.Stream;

public class Process {
    List<CompanyRole> companyRole;
    Category category;
    List<Process> parentProcess;


    public boolean canAccessRoles(boolean lookUp, List<CompanyRole> userCompanyRoles) {
        boolean canAccessParent = lookUp
                && parentProcess.stream().anyMatch(parent -> parent.canAccessRoles(false, userCompanyRoles));
        Stream<CompanyRole> currentCompanyRoleStream = Stream.concat(companyRole.stream(),category.companyRole.stream());

        return canAccessParent || currentCompanyRoleStream.anyMatch(userCompanyRoles::contains);
    }
}
