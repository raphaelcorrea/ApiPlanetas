package br.com.api.apirest.model;

import javax.persistence.*;


@Entity
@Table(name = "planeta")
public class Planeta {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="planetaSequence")
    @SequenceGenerator(name="planetaSequence", sequenceName="planetaSequence")
    private Long id;
    private String clima;
    private String terreno;
    private String nome;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getTerreno() {
        return terreno;
    }

    public void setTerreno(String terreno) {
        this.terreno = terreno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
