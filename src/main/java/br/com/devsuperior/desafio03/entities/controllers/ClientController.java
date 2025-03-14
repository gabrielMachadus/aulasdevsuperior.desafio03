package br.com.devsuperior.desafio03.entities.controllers;

import br.com.devsuperior.desafio03.dto.ClientDTO;
import br.com.devsuperior.desafio03.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ClientDTO findById(@PathVariable Long id){
        ClientDTO clientDTO = clientService.findById(id);
        return clientDTO;
    }

    @GetMapping
    public Page<ClientDTO> findPageable(Pageable page){
        return  clientService.findPageable(page);
    }

    @PostMapping
    public ClientDTO insert(@RequestBody ClientDTO clientDTO){
        return clientService.insert(clientDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteByID(@PathVariable Long id){
        clientService.deleteById(id);
    }



}
