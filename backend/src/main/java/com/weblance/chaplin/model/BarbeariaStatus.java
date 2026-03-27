package com.weblance.chaplin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType; // Faltava esse!
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "barbeariastatus")
@Data // Isso gera automaticamente Getters, Setters, ToString etc.
public class BarbeariaStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private boolean aberto;

    // Se o @Data não funcionar (ficar sublinhado de vermelho), 
    // apague ele e clique com o botão direito -> Source Action -> Generate Getters and Setters
}