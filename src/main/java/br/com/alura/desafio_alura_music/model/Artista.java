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

    public Artista(Long id, String nome, TipoArtista tipo) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
    }

    //Métodos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public void setTipo(TipoArtista tipo) {
        this.tipo = tipo;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        musicas.forEach(m -> m.setArtista(this));
        this.musicas = musicas;
    }

    @Override
    public String toString() {
        return "[ Artista: " +
                "Nome = " + nome +
                ", Tipo = " + tipo +
                " ]";
    }
}
