package com.weblance.chaplin.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "profissionais")
@Data
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_funcionario", nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String senha;

    @Column(name = "page_html", nullable = false)
    private String pageHtml;

    private String status = "DISPONIVEL";
}