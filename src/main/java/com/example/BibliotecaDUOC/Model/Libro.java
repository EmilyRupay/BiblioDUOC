package com.example.BibliotecaDUOC.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Genera getters , setters , etc
@AllArgsConstructor //Genera un constructor con todos los campos.
@NoArgsConstructor //Genera un constructor con todos los campos.

public class Libro {
    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;

}
