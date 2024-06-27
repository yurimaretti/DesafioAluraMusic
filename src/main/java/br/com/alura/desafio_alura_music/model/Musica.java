package br.com.alura.desafio_alura_music.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    private Artista artista;

    //Construtores

    public Musica() {
    }

    public Musica(String titulo, Artista artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    //Métodos

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return "Título = " + titulo +
                ", Artista = " + artista.getNome();
    }
}
