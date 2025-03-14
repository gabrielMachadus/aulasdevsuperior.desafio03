package br.com.devsuperior.desafio03.services;

import br.com.devsuperior.desafio03.dto.ClientDTO;
import br.com.devsuperior.desafio03.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public ClientDTO findById(Long id){
        return new ClientDTO(clientRepository.findById(id).get());
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
}
