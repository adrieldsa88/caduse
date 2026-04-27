package com.adrieldsa88.caduse.business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDTO {

    private String street;
    private String number;
    private String city;
    private String state;
    private String country;
    private String cep;

}
