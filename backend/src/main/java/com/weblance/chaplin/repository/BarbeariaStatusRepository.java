package com.weblance.chaplin.repository;


import com.weblance.chaplin.model.BarbeariaStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface BarbeariaStatusRepository extends JpaRepository<BarbeariaStatus, Long> {

    // Aqui o Spring já te dá o save(), findById(), etc.

}






    

