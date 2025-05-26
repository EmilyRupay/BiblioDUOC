package com.example.BibliotecaDUOC.Controller;
import com.example.BibliotecaDUOC.Model.Usuario;
import com.example.BibliotecaDUOC.Service.UsuarioService;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario obtenerPorId(@PathVariable int id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }
    
    @PostMapping
    public void agregarUsuario(@RequestBody Usuario usuario) {
        usuarioService.agregarUsuario(usuario);
    }

    @PutMapping("/{id}")
    public void actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuarioService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
    }

}
