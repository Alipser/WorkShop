package com.riwi.workshop.api.dtos.responses;

import com.riwi.workshop.utils.enums.RoleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseBasic {

    private Integer id;
    private String username;
    private String email;
    private String fullName;
    private RoleType role;

}
