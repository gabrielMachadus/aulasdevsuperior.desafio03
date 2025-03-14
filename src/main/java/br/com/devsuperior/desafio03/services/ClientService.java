package br.com.devsuperior.desafio03.services;

import br.com.devsuperior.desafio03.dto.ClientDTO;
import br.com.devsuperior.desafio03.entities.Client;
import br.com.devsuperior.desafio03.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional(readOnly = true)
    public Page<ClientDTO> findPageable(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x-> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        Client client = new Client(dto);
        client = clientRepository.save(client);
        return new ClientDTO(client);
    }

    public void deleteById(Long id){
        clientRepository.deleteById(id);
    }
}
