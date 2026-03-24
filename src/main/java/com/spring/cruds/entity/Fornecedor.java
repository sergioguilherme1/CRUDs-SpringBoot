package com.spring.cruds.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity(name = "Fornecedor")
@Table(name = "tb_fornecedor")
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "txt_nome_fantasia") // Nome diferente do atributo
    private String nomeFantasia;

    @Column(name = "txt_cnpj") // Nome diferente do atributo
    private String cnpj;

    private String contato;

    public Fornecedor() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNomeFantasia() { return nomeFantasia; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }
}