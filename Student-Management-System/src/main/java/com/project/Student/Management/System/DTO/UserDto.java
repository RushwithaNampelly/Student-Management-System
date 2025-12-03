package com.project.Student.Management.System.DTO;

import lombok.*;

@Data
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String email;
    private String role;
}
