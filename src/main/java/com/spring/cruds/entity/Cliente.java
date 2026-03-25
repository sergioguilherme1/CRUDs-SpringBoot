package com.spring.cruds.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "Cliente")
@Table(name = "tb_cliente")
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "cli_email") // Nome da coluna diferente do atributo
    private String email;

    @Column(name = "cli_telefone") // Nome da coluna diferente do atributo
    private String telefone;

    public Cliente() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}