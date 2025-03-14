package br.com.devsuperior.desafio03.dto;

import br.com.devsuperior.desafio03.entities.Client;
import java.time.LocalDate;

public class ClientDTO {
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private Integer children;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public ClientDTO() {
    }

    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }
}
