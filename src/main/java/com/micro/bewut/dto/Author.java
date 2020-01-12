package com.micro.bewut.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Author {

    private String firstName;

    private String lastName;

    private Integer yearOfBirth;

    private Address address;

}
