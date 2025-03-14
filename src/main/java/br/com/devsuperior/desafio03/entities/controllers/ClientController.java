package br.com.devsuperior.desafio03.entities.controllers;

import br.com.devsuperior.desafio03.dto.ClientDTO;
import br.com.devsuperior.desafio03.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<ClientDTO> findAll(){
        return clientService.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteByID(@PathVariable Long id){
        clientService.deleteById(id);
    }



}
