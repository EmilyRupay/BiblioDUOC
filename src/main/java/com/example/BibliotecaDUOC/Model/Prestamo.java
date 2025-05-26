package com.example.BibliotecaDUOC.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Prestamo {
    private int id_prestamo;             // Id autoincrementable
    private int id_libro;                // FK a Libro (puedes luego mapear como objeto si usas JPA)
    private String run_solicitante;
    private LocalDate fecha_solicitud;
    private LocalDate fecha_entrega;     // Puede ser null
    private int cantidad_dias;
    private int multas;                  // >= 0
}
