package com.lib;

import java.util.Scanner;

import com.lib.biblioteca.Biblioteca;
import com.lib.estante.Cd;
import com.lib.estante.Dvd;
import com.lib.estante.Livro;
import com.lib.estante.Revista;
import com.lib.estante.Tese;
import com.lib.usuario.Usuario;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        for (int i = 1; i <= 3; i++) {
            biblioteca.getAcervo().add(new Livro("Livro " + i, "Autor " + i, 2000 + i * 5));
            biblioteca.getAcervo().add(new Revista("Revista " + i, "Editora " + i, 2010 + i * 3));
            biblioteca.getAcervo().add(new Tese("Tese " + i, "Pesquisador " + i, 2015 + i));
            biblioteca.getAcervo().add(new Cd("CD " + i, "Artista " + i, 2008 + i));
            biblioteca.getAcervo().add(new Dvd("DVD " + i, "Diretor " + i, 2012 + i));
        }

        biblioteca.getUsuarios().add(new Usuario("belle", 0, false));
        biblioteca.getUsuarios().add(new Usuario("jully", 0, false));
        biblioteca.getUsuarios().add(new Usuario("leo", 0, false));
        biblioteca.getUsuarios().add(new Usuario("maria", 0, false));

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Gerenciar itens");
            System.out.println("2. Gerenciar usuários");
            System.out.println("3. Pesquisar itens da biblioteca");
            System.out.println("4. Fazer empréstimo");
            System.out.println("5. Devolver empréstimo");
            System.out.println("6. Emitir relatórios");
            System.out.println("0. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // ger user

                    break;
                case 2:
                    // ger itens
                    break;
                case 3:
                    biblioteca.pesquisarItens();
                    break;
                case 4:
                    // emprestar item
                    break;
                case 5:
                    // devolver item
                    break;

                case 6:
                    subMenuRelatorio(biblioteca);
                    break;

                case 0:
                    System.out.println("Finalizando atendimento... Até mais!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            scanner.close();
        }

    }

    public static void subMenuRelatorio(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma opção de relatório:");
            System.out.println("1. Por item");
            System.out.println("2. Por usuário");
            System.out.println("0. Voltar ao menu principal");

            int opcaoSubMenuRelatorio = scanner.nextInt();

            switch (opcaoSubMenuRelatorio) {
                case 1:
                    biblioteca.relatorioPorItem();
                    break;
                case 2:
                    System.out.println("Digite o nome do Aluno");
                    String nomeAluno = scanner.nextLine();

                    biblioteca.relatorioPorUsuario(nomeAluno);

                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            if (opcaoSubMenuRelatorio == 0) {
                break;
            }
        }
        scanner.close();
    };

}
