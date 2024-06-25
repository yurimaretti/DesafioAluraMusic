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

    public Musica(Long id, String titulo, Artista artista) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
    }

    //Métodos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "[ Música: " +
                "Título = " + titulo +
                ", Artista = " + artista +
                " ]";
    }
}
