package br.com.devsuperior.desafio03.services;

import br.com.devsuperior.desafio03.dto.ClientDTO;
import br.com.devsuperior.desafio03.entities.Client;
import br.com.devsuperior.desafio03.repositories.ClientRepository;
import br.com.devsuperior.desafio03.services.exceptions.DatabaseException;
import br.com.devsuperior.desafio03.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public ClientDTO findById(Long id){
        return new ClientDTO(clientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Recurso não encontrado")));
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findPageable(Pageable pageable) {
        Page<Client> result = clientRepository.findAll(pageable);
        return result.map(x-> new ClientDTO(x));
    }

    @Transactional
    public ClientDTO insert(ClientDTO dto){
        return new ClientDTO(clientRepository.save(new Client(dto)));
    }

    @Transactional
    public ClientDTO update(Long id, ClientDTO dto){
        try {
            Client clientToUpdate = clientRepository.getReferenceById(id);
            clientToUpdate.setName(dto.getName());
            clientToUpdate.setChildren(dto.getChildren());
            clientToUpdate.setCpf(dto.getCpf());
            clientToUpdate.setIncome(dto.getIncome());
            clientToUpdate.setBirthDate(dto.getBirthDate());

            return new ClientDTO(clientRepository.save(clientToUpdate));
        }catch (EntityNotFoundException e){
             throw new ResourceNotFoundException("ID não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteById(Long id) {
        /*if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("ID não encontrado");
        }*/
        try {
            clientRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }
}
