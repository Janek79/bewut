package com.micro.bewut.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    private String title;

    private Integer yearOfPublishing;

    private Integer pageAmount;

    private Author author;

}
