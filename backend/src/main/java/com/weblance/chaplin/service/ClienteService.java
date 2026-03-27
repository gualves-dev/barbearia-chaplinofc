package com.weblance.chaplin.service;

import com.weblance.chaplin.model.Cliente;
import com.weblance.chaplin.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private BarbeariaStatusService barbeariaService;

    @Autowired
    private ProfissionalService profissionalService;

    public Cliente entrarNaFila(Cliente cliente) {
        // 1. REGRA: A barbearia tá aberta?
        if (!barbeariaService.isBarbeariaOpen()) {
            throw new RuntimeException("Barbearia fechada no momento!");
        }

        // 2. REGRA: O profissional escolhido pode atender?
        // Aqui usamos o ID do profissional que veio no objeto cliente
        profissionalService.verificarStatusPorNome(cliente.getProfissional());

        // 3. Configurações iniciais do cliente na fila
        cliente.setStatus("AGUARDANDO");
        
        // 4. Salva o cliente e retorna para o Front-end
        return clienteRepository.save(cliente);
    }

    // Lógica para quando o barbeiro clica em "CHAMAR"
    public void chamarCliente(Long clienteId, Long profissionalId) {
        var cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        
        // Muda status do cliente para ATENDIMENTO
        cliente.setStatus("EM_ATENDIMENTO");
        clienteRepository.save(cliente);

        // Muda status do profissional para ATENDENDO
        profissionalService.emAtendimentoStatus(profissionalId);
        
        // DICA: Aqui no Front você gera o link do WhatsApp com o tel do cliente!
    }


    // ESSA É A FUNÇÃO QUE "LIMPA" O SISTEMA
    public void finalizarAtendimento(Long clienteId, Long profissionalId) {
        
        // 1. Verifica se o cliente existe antes de tentar apagar (evita erro)
        if (!clienteRepository.existsById(clienteId)) {
            throw new RuntimeException("Cliente não encontrado na fila.");
        }

        // 2. DELETA O CLIENTE (Ele some do MySQL aqui)
        clienteRepository.deleteById(clienteId);
        
        System.out.println("Cliente " + clienteId + " removido com sucesso. Fila atualizada!");

        // 3. LIBERA O PROFISSIONAL
        // Chamamos a função que você já criou no ProfissionalService
        profissionalService.disponivelStatus(profissionalId);
    }
}
