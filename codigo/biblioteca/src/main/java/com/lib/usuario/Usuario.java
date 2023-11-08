package com.lib.usuario;
import java.utils.*;

public class Usuario {
    private String nome;
    private int qntItensEmprestados;
    private boolean isEmprestimoAtraso;
    private List historicoDeItens<Item>;
    private List itensEmEmprestismo<Item>

    public Usuario(String nome, int qntItensEmprestados, boolean isEmprestimoAtraso) {
        this.nome = nome;
        this.qntItensEmprestados = qntItensEmprestados;
        this.isEmprestimoAtraso = isEmprestimoAtraso;

    }

    public boolean pegarMaisUmItem() {
        return !isEmprestimoAtraso && qntItensEmprestados < 3;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQntItensEmprestados() {
        return qntItensEmprestados;
    }

    public void setQntItensEmprestados(int qntItensEmprestados) {
        this.qntItensEmprestados = qntItensEmprestados;
    }

    public boolean isEmprestimoAtraso() {
        return isEmprestimoAtraso;
    }

    public void setEmprestimoAtraso(boolean emprestimoAtraso) {
        this.isEmprestimoAtraso = emprestimoAtraso;
    }
}