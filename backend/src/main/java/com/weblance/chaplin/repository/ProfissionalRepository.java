package com.weblance.chaplin.repository;


import com.weblance.chaplin.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    // Usar Optional é mais seguro para o Service tratar se o barbeiro não existir
    Optional<Profissional> findByUsuario(String usuario);
}