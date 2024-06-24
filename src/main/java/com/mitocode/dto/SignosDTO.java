package com.mitocode.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SignosDTO {

    @EqualsAndHashCode.Include
    private Integer idSigno;

    @NotNull
    private Double temperatura;

    @NotNull
    private Integer pulso;

    @NotNull
    private Integer ritmo;

    @NotNull
    private LocalDateTime fecha;

    @NotNull
    private PatientDTO patient;
}
