package com.example.BibliotecaDUOC.Repository;

import com.example.BibliotecaDUOC.Model.Usuario;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class UsuarioRepository {
      // Lista que guardará todos los usuarios
    private List<Usuario> listaUsuarios = new ArrayList<>();

    public UsuarioRepository() {
        // Datos de ejemplo para usuarios
        listaUsuarios.add(new Usuario(1, "Juan Perez", "juan.perez@mail.com", "Admin"));
        listaUsuarios.add(new Usuario(2, "Maria Gomez", "maria.gomez@mail.com", "Usuario"));
        listaUsuarios.add(new Usuario(3, "Carlos Sanchez", "carlos.sanchez@mail.com", "Usuario"));
    }

    // Método que retorna todos los usuarios
    public List<Usuario> obtenerUsuarios() {
        return listaUsuarios;
    }

    // Buscar usuario por id
    public Usuario buscarPorId(int id) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    // Buscar usuario por email
    public Usuario buscarPorEmail(String email) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getCorreo().equalsIgnoreCase(email)) {
                return usuario;
            }
        }
        return null;
    }

    // Método que guarda un usuario en la lista y lo retorna
    public Usuario guardar(Usuario usuario) {
        listaUsuarios.add(usuario);
        return usuario;
    }

    // Método que actualiza un usuario por id, retorna el usuario actualizado
    public Usuario actualizar(Usuario usuario) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getId() == usuario.getId()) {
                id = usuario.getId();
                idPosicion = i;
                break;
            }
        }

        Usuario usuarioActualizado = new Usuario();
        usuarioActualizado.setId(id);
        usuarioActualizado.setNombre(usuario.getNombre());
        usuarioActualizado.setCorreo(usuario.getCorreo());
        

        listaUsuarios.set(idPosicion, usuarioActualizado);
        return usuarioActualizado;
    }

    // Método que elimina un usuario por id
    public void eliminar(int id) {
        Usuario usuario = buscarPorId(id);
        if (usuario != null) {
            listaUsuarios.remove(usuario);
        }
    }

}
