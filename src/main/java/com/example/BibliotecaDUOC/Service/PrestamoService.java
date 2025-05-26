package com.example.BibliotecaDUOC.Service;


import com.example.BibliotecaDUOC.Model.Prestamo;
import com.example.BibliotecaDUOC.Repository.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PrestamoService {
    @Autowired
    private PrestamoRepository prestamoRepository;

    public List<Prestamo> getPrestamos() {
        return prestamoRepository.obtenerPrestamos();
    }

    public Prestamo getPrestamoId(int id) {
        return prestamoRepository.buscarPorId(id);
    }

    public Prestamo savePrestamo(Prestamo prestamo) {
        return prestamoRepository.guardar(prestamo);
    }

    public Prestamo updatePrestamo(Prestamo prestamo) {
        return prestamoRepository.actualizar(prestamo);
    }

    public String deletePrestamo(int id) {
        prestamoRepository.eliminar(id);
        return "Préstamo eliminado correctamente (ID: " + id + ")";
    }
}
