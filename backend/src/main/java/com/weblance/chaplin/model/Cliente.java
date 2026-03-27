package com.weblance.chaplin.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fila")
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cliente", nullable = false)
    private String nome;

    @Column(name = "servico", nullable = false) // Adicionei a vírgula que faltava aqui
    private String servico;

    @Column(name = "profissional", nullable = false) // Forçando o nome igual ao seu SQL
    private String profissional;

    @Column(name = "tempo_estimado", nullable = false)
    private Integer tempo;

    @Column(name = "status", nullable = false) // Forçando o nome igual ao seu SQL
    private String status = "AGUARDANDO";

    @Column(name = "numero", nullable = false)
    private String numero;
}