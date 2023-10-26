package com.lib.item;

public abstract class Item {

    private ETipoItem tipo;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int quantidade;
    private boolean emprestavel;

    public abstract boolean isEmprestavel();

    public boolean podeSerEmprestado() {
        return emprestavel && quantidade > 1;
    }

    public enum ETipoItem {
        LIVRO,
        TESE,
        REVISTA,
        CD,
        DVD
    }
}
