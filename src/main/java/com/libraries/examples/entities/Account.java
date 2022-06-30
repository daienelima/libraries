package com.libraries.examples.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Account {

    private Integer id;
    private String name;
    private String iban;
    private String accountNumber;
}
