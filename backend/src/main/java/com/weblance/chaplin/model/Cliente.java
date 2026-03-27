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

    @Column(nullable = false)
    private String servico;

    @Column(nullable = false)
    private String profissional;

    @Column(name = "tempo_estimado", nullable = false)
    private Integer tempo;

    @Column(nullable = false)
    private String status = "AGUARDANDO";

    @Column(name = "numero", nullable = false)
    private String numero;
}