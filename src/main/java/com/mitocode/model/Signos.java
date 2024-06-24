package com.mitocode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Signos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idSigno;

    @Column(nullable = false)
    private Double temperatura;

    @Column(nullable = false)
    private Integer pulso;

    @Column(nullable = false)
    private Integer ritmo;

    @Column(nullable = true, length = 255)
    private LocalDateTime fecha;

    @ManyToOne //FK
    @JoinColumn(name = "id_patient", nullable = false, foreignKey = @ForeignKey(name = "FK_SIGNOS_PATIENT"))
    private Patient patient;
}
