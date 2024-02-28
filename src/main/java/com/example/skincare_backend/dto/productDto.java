package com.example.skincare_backend.dto;

import lombok.*;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class productDto {
    private Integer itemId;
    @NotNull
    private String itemName;
    @NotNull
    private String image;
    @NotNull
    private String price;
    @NotNull
    private String description;

}
