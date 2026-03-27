package com.weblance.chaplin.repository;

import com.weblance.chaplin.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List; // Não esqueça de importar o List!

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    // Essa é a "mágica" que o Spring faz: ele cria o SQL sozinho baseado no nome do método
    List<Cliente> findByProfissionalIgnoreCaseOrProfissionalIgnoreCaseOrderByIdAsc(String profissional, String nenhum);
}