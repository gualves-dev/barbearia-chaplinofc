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

    @Column(name = "usuario", nullable = false, unique = true) // 'name' adicionado para segurança
    private String usuario;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "page_html", nullable = false)
    private String pageHtml;

    @Column(name = "status") // Adicionado para garantir o match com o SQL
    private String status = "DISPONIVEL";
}