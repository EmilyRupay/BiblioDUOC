package com.example.BibliotecaDUOC.Service;

import com.example.BibliotecaDUOC.Model.Libro;
import com.example.BibliotecaDUOC.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> getlibros(){
        return libroRepository.obtenerLibros();
    }
    public Libro saveLibro(Libro libro){
        return libroRepository.guardar(libro);
    }
    public Libro getLibroId( int id){
        return libroRepository.buscarPorId(id);
    }
    public Libro updateLibro (Libro libro){
        return libroRepository.actualizar(libro);
    }
    public String deleteLibro(int id){
        libroRepository.eliminar(id);
        return "Producto eliminado";
    }

    public int totalLibrosV1(){
        return libroRepository.obtenerLibros().size();
    }

}
