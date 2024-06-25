package br.com.alura.desafio_alura_music.main;

import java.util.Scanner;

public class Main {
    Scanner leitura = new Scanner(System.in);

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    *** Alura Music ***
                    
                    1 - Cadastrar Artistas
                    2 - Cadastrar Músicas
                    3 - Listar Músicas
                    4 - Buscar músicas por artista
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    incluirArtista();
                    break;
                case 2:
                    incluirMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    listarMusicasPorArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private void listarMusicasPorArtista() {
    }

    private void listarMusicas() {
    }

    private void incluirMusica() {
    }

    private void incluirArtista() {
    }
}
