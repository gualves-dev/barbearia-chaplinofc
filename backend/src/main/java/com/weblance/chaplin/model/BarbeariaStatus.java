package com.weblance.chaplin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "barbeariastatus")
@Data 
public class BarbeariaStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aberto", nullable = false) // Mapeando para a coluna 'aberto' do seu SQL
    private boolean aberto;

    // Se você quiser usar a coluna 'sistema_aberto' do SQL no Java, 
    // você precisaria de outro atributo aqui. 
    // Se não for usar, pode deixar assim.
}