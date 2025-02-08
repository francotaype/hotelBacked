package com.francode.hotelBacked.presentation.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FloorRoomsRequestDTO {

    @NotEmpty(message = "El piso no puede estar vacío")
    private Integer number;
}


