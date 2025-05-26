package com.example.BibliotecaDUOC.Repository;

import com.example.BibliotecaDUOC.Model.Prestamo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class PrestamoRepository {
    private List<Prestamo> listaPrestamos = new ArrayList<>();

    public List<Prestamo> obtenerPrestamos() {
        return listaPrestamos;
    }

    public Prestamo guardar(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
        return prestamo;
    }

    public Prestamo buscarPorId(int id) {
        for (Prestamo p : listaPrestamos) {
            if (p.getId_prestamo() == id) {
                return p;
            }
        }
        return null;
    }

    public Prestamo actualizar(Prestamo prestamo) {
        int posicion = -1;
        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (listaPrestamos.get(i).getId_prestamo() == prestamo.getId_prestamo()) {
                posicion = i;
                break;
            }
        }

        if (posicion != -1) {
            listaPrestamos.set(posicion, prestamo);
            return prestamo;
        }

        return null;
    }

    public void eliminar(int id) {
        Prestamo prestamo = buscarPorId(id);
        if (prestamo != null) {
            listaPrestamos.remove(prestamo);
        }
    }
}
