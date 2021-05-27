package com.example.evolent.contact.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private boolean status;
}
