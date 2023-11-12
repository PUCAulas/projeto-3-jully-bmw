package com.lib.item;

public abstract class Item {

    protected ETipoItem tipo;
    protected String titulo;
    protected String autor;
    protected int anoPublicacao;
    protected int quantidade;
    protected int qntdDeVezesEmprestado;
    protected boolean emprestavel;

    public abstract boolean isEmprestavel();

    public boolean podeSerEmprestado() {
        return emprestavel && quantidade > 1;
    }

    public void emprestarItem() {

    }

    public enum ETipoItem {
        LIVRO,
        TESE,
        REVISTA,
        CD,
        DVD
    }

    public ETipoItem getTipo() {
        return tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getQntdDeVezesEmprestado() {
        return qntdDeVezesEmprestado;
    }

    public void atualizarQntdDeVezesEmprestado(int qntd) {
        this.qntdDeVezesEmprestado += qntd;
    }
}
