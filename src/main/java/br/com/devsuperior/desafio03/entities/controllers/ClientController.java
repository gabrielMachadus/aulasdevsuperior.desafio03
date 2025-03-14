package br.com.devsuperior.desafio03.entities.controllers;

import br.com.devsuperior.desafio03.entities.Client;
import br.com.devsuperior.desafio03.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping
    public List<Client> list() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream().toList();
    }


}
