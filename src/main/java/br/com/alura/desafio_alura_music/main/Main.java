package br.com.alura.desafio_alura_music.main;

import br.com.alura.desafio_alura_music.model.Artista;
import br.com.alura.desafio_alura_music.model.Musica;
import br.com.alura.desafio_alura_music.model.TipoArtista;
import br.com.alura.desafio_alura_music.repository.ArtistaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private final ArtistaRepository repositorio;
    Scanner leitura = new Scanner(System.in);

    public Main(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

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
            leitura.nextLine();

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
        System.out.println("Qual o nome do artista?");
        var nome = leitura.nextLine();
        List<Musica> musicas = repositorio.buscaMusicasPorArtista(nome);
        musicas.forEach(System.out::println);
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void incluirMusica() {
        System.out.println("Cadastrar música de qual artista?");
        var nome = leitura.nextLine();
        Optional<Artista> nomeArtista = repositorio.findByNomeContainingIgnoreCase(nome);

        if (nomeArtista.isPresent()) {
            System.out.println("Informe o nome da música:");
            var nomeMusica = leitura.nextLine();
            var artista = nomeArtista.get();

            Musica musica = new Musica(nomeMusica, artista);
            artista.getMusicas().add(musica);

            repositorio.save(artista);
            System.out.println("Música cadastrada com sucesso.\n");
        } else {
            System.out.println("Artista não encontrado.\n");
        }
    }

    private void incluirArtista() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")){
            System.out.println("Informe o nome do artista:");
            var nome = leitura.nextLine();
            System.out.println("Informe o tipo do artista: " + Arrays.toString(TipoArtista.values()));
            var tipo = leitura.nextLine();

            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nome, tipoArtista);

            repositorio.save(artista);
            System.out.println("Artista cadastrado com sucesso.\n");

            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }
    }
}
