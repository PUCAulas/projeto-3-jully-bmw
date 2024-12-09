package com.lib.estante;

import com.lib.item.Item;
import com.lib.itemBiblioteca.ItemBiblioteca;

public class Revista extends Item implements ItemBiblioteca {

    public Revista(String titulo, String autor, int anoPublicacao) {
        this.tipo = ETipoItem.REVISTA;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidade = 3;
        this.emprestavel = false;
    }

    @Override
    public void emprestar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'emprestar'");
    }

    @Override
    public void devolver() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'devolver'");
    }

    @Override
    public boolean isEmprestavel() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isEmprestavel'");
    }

}