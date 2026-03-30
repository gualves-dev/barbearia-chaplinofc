package com.weblance.chaplin.service;

import com.weblance.chaplin.repository.BarbeariaStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalTime;

@Service
public class BarbeariaStatusService {

    @Autowired
    private BarbeariaStatusRepository repository;

    public boolean isBarbeariaOpen() {

        boolean statusNoBanco = repository.findById(1L).map(status -> status.isAberto()).orElse(false);

        LocalTime timeAgora = LocalTime.now();

        boolean horarioValido = timeAgora.isAfter(LocalTime.of(11, 29)) && timeAgora.isBefore(LocalTime.of(22, 30));

        return statusNoBanco && horarioValido;

    }

    public void closeNow() {

        var status = repository.findById(1L).orElseThrow(() -> new RuntimeException("Status nao encontrado"));

        status.setAberto(false);

        repository.save(status);

    }

    public void openNow() {

        var status = repository.findById(1L).orElseThrow(() -> new RuntimeException("Status nao encontrado"));

        status.setAberto(true);

        repository.save(status);

    }

}
