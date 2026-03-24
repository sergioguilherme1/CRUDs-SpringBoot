package com.spring.cruds.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "Departamento")
@Table(name = "tb_departamento")
public class Departamento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nm_departamento") // Nome diferente do atributo
    private String nome;

    @Column(name = "txt_localizacao") // Nome diferente do atributo
    private String localizacao;

    public Departamento() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
}