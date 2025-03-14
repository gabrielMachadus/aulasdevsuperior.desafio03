package br.com.devsuperior.desafio03.dto;

import br.com.devsuperior.desafio03.entities.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
public class ClientDTO {
    private Long id;
    private String name;
    private String cpf;
    private LocalDate birthDate;
    private Integer children;

    public ClientDTO(Client entity) {
        id = entity.getId();
        name = entity.getName();
        cpf = entity.getCpf();
        birthDate = entity.getBirthDate();
        children = entity.getChildren();
    }
}
