package br.com.devsuperior.desafio03.entities;

import br.com.devsuperior.desafio03.dto.ClientDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Campo não pode ser vazio")
    @Size(min = 3,max = 80, message = "Nome deve ter de 5 a 80 caracteres.")
    private String name;
    @NotEmpty(message = "Obrigatório informar um CPF.")
    private String cpf;
    @Positive(message = "Um valor positivo e maior que zero deve ser informado.")
    private Double income;
    @PastOrPresent(message = "Campo de nascimento não pode ter data futura.")
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @PositiveOrZero(message = "Deve ser 0 ou maior")
    private Integer children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public Client() {
    }

    public Client(ClientDTO dto){
        this.name = dto.getName();
        this.cpf = dto.getCpf();
        this.income =  dto.getIncome();
        this.birthDate = dto.getBirthDate();
        this.children = dto.getChildren();
    }
}
