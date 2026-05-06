package com.adrieldsa88.caduse.business.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDTO {
    private int id;
    private String number;
    private String ddd;
}
