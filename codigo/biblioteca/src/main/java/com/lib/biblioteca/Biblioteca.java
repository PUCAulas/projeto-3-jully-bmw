package com.lib.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.lib.item.Item;
import com.lib.item.Item.ETipoItem;
import com.lib.usuario.Usuario;

public class Biblioteca {
    private List<Item> acervo;
    private List<Usuario> usuarios;

    public Biblioteca() {
        acervo = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void pesquisarItens() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção de pesquisa:");
            System.out.println("1. Por título");
            System.out.println("2. Por autor");
            System.out.println("3. Por ano de publicação");
            System.out.println("4. Por tipo de item");
            System.out.println("0. Voltar ao menu principal");

            int opcaoPesquisa = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoPesquisa) {
                case 1:
                    pesquisarPorTitulo();
                    break;
                case 2:
                    pesquisarPorAutor();
                    break;
                case 3:
                    pesquisarPorAno();
                    break;
                case 4:
                    pesquisarPorTipo();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            scanner.close();
        }
    }

    private void pesquisarPorTitulo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o título a ser pesquisado:");
        String titulo = scanner.nextLine();
        List<Item> resultados = new ArrayList<>();

        for (Item item : acervo) {
            if (item.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(item);
            }
        }

        exibirResultadosPesquisa(resultados);
        scanner.close();
    }

    private void pesquisarPorAutor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o autor a ser pesquisado:");
        String autor = scanner.nextLine();
        List<Item> resultados = new ArrayList<>();

        for (Item item : acervo) {
            if (item.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.add(item);
            }
        }

        exibirResultadosPesquisa(resultados);
        scanner.close();
    }

    private void pesquisarPorAno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o ano de publicação a ser pesquisado:");
        int ano = scanner.nextInt();
        List<Item> resultados = new ArrayList<>();

        for (Item item : acervo) {
            if (item.getAnoPublicacao() == ano) {
                resultados.add(item);
            }
        }

        exibirResultadosPesquisa(resultados);
        scanner.close();
    }

    private void pesquisarPorTipo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o tipo de item a ser pesquisado (livro, revista, etc.):");
        String tipo = scanner.nextLine();
        List<Item> resultados = new ArrayList<>();

        for (Item item : acervo) {
            if (item.getTipo().toString().equalsIgnoreCase(tipo)) {
                resultados.add(item);
            }
        }

        exibirResultadosPesquisa(resultados);
        scanner.close();
    }

    private void exibirResultadosPesquisa(List<Item> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("Nenhum resultado encontrado.");
        } else {
            Collections.sort(resultados, (item1, item2) -> item1.getTitulo().compareTo(item2.getTitulo()));
            System.out.println("\nResultados da pesquisa:");
            for (Item item : resultados) {
                System.out.println(" - Título: " + item.getTitulo() +
                        ", Autor: " + item.getAutor() +
                        ", Ano de Publicação: " + item.getAnoPublicacao() +
                        ", Tipo: " + item.getTipo());
            }
        }
    }

    public void relatorioPorItem() {
        System.out.println("Relatório por Item:");

        for (ETipoItem tipo : ETipoItem.values()) {
            relatorioPorTipoDeItem(tipo);
        }
    }

    private void relatorioPorTipoDeItem(ETipoItem tipo) {
        List<Item> itensDoTipo = filtrarItensPorTipo(tipo);

        if (!itensDoTipo.isEmpty()) {
            Collections.sort(itensDoTipo,
                    (item1, item2) -> Integer.compare(item1.getAnoPublicacao(), item2.getAnoPublicacao()));

            System.out.println("\nTipo de Item: " + tipo);
            for (Item item : itensDoTipo) {
                System.out.println(" - Título: " + item.getTitulo() +
                        ", Ano de Publicação: " + item.getAnoPublicacao() +
                        ", Quantidade de vezes emprestado: " + item.getQntdDeVezesEmprestado());
            }
        }
    }

    private List<Item> filtrarItensPorTipo(ETipoItem tipo) {
        List<Item> itensDoTipo = new ArrayList<>();
        for (Item item : acervo) {
            if (item.getTipo() == tipo) {
                itensDoTipo.add(item);
            }
        }
        return itensDoTipo;
    }

    public void relatorioPorUsuario(String nomeUsuario) {
        Usuario usuario = buscarUsuario(nomeUsuario);

        if (usuario != null) {
            List<Item> historicoItens = usuario.getHistoricoDeItens();
            Collections.sort(historicoItens, (item1, item2) -> item1.getTitulo().compareTo(item2.getTitulo()));

            System.out.println("Relatório para o usuário " + nomeUsuario + ":");
            for (Item item : historicoItens) {
                System.out.println(" - " + item.getTitulo());
            }
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    private Usuario buscarUsuario(String nomeUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Item> getAcervo() {
        return acervo;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
