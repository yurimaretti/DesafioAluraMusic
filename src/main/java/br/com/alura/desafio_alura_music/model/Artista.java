package br.com.alura.desafio_alura_music.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artistas")
public class Artista {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @Enumerated(value = EnumType.STRING)
    private TipoArtista tipo;

    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    //Construtores

    public Artista() {
    }

    public Artista(String nome, TipoArtista tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    //Métodos

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    @Override
    public String toString() {
        return "Artista = " + nome +
                ", Tipo = " + tipo +
                ", Músicas = " + musicas;
    }
}
