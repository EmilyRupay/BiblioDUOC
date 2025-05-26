package com.example.BibliotecaDUOC.Service;
import com.example.BibliotecaDUOC.Model.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service


public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public boolean eliminarUsuario(int id) {
        return usuarios.removeIf(usuario -> usuario.getId() == id);
    }

    public boolean actualizarUsuario(int id, Usuario nuevoUsuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == id) {
                usuarios.set(i, nuevoUsuario);
                return true;
            }
        }
        return false;
    }

}
