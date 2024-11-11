package com.example.demo.layers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.ValidacaoException;
import com.example.demo.layers.entities.Cliente;
import com.example.demo.layers.repositories.ClienteRepository;

import br.com.caelum.stella.validation.CPFValidator;

import java.time.LocalDate;
import java.time.Period;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    private final CPFValidator cpfValidator = new CPFValidator();

    void validarInformacaoCliente(Cliente cliente) {
        // Validação do CPF
        if (!cpfValidator.isEligible(cliente.getCpf())) {
            throw new ValidacaoException("CPF inválido");
        }

        // Validação do Nome
        if (cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new ValidacaoException("Nome inválido");
        }

        // Validação da Idade
        if (cliente.getDataNascimento() == null || !isMaiorDeIdade(cliente.getDataNascimento())) {
            throw new ValidacaoException("Cliente deve ser maior de 18 anos");
        }
    }

    public Cliente cadastrarCliente(Cliente cliente) {
        validarInformacaoCliente(cliente);
        cpfValidator.assertValid(cliente.getCpf());
        clienteRepository.save(cliente);
        return cliente;
    }

    private boolean isMaiorDeIdade(LocalDate dataNascimento) {
        // Calcula a idade a partir da data de nascimento
        return Period.between(dataNascimento, LocalDate.now()).getYears() >= 18;
        
    }
}
