package com.lib.biblioteca;

import java.util.ArrayList;
import java.util.List;

import com.lib.itemBiblioteca.ItemBiblioteca;
import com.lib.usuario.Usuario;

public class Biblioteca {
    private List<ItemBiblioteca> acervo;
    private List<Usuario> usuarios;

    public Biblioteca() {
        acervo = new ArrayList<>();
        usuarios = new ArrayList<>();
    }
}
