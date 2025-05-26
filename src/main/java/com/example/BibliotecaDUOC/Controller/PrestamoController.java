package com.example.BibliotecaDUOC.Controller;

import com.example.BibliotecaDUOC.Model.Prestamo;
import com.example.BibliotecaDUOC.Service.PrestamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/prestamos")

public class PrestamoController {

     @Autowired
    private PrestamoService prestamoService;

    @GetMapping
    public List<Prestamo> listarPrestamos() {
        return prestamoService.getPrestamos();
    }

    @PostMapping
    public Prestamo guardarPrestamo(@RequestBody Prestamo prestamo) {
        return prestamoService.savePrestamo(prestamo);
    }

    @GetMapping("{id}")
    public Prestamo obtenerPrestamo(@PathVariable int id) {
        return prestamoService.getPrestamoId(id);
    }

    @PutMapping("{id}")
    public Prestamo actualizarPrestamo(@PathVariable int id, @RequestBody Prestamo prestamo) {
        return prestamoService.updatePrestamo(prestamo);
    }

    @DeleteMapping("{id}")
    public String eliminarPrestamo(@PathVariable int id) {
        return prestamoService.deletePrestamo(id);
    }

}
