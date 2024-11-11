package com.example.demo.layers.services;

import com.example.demo.exceptions.ValidacaoException;
import com.example.demo.layers.entities.Produto;
import com.example.demo.layers.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto cadastrarProduto(Produto produto) {
        validarProduto(produto);
        return produtoRepository.save(produto);
    }

    private void validarProduto(Produto produto) {
        if (produto.getNome() == null || produto.getNome().isBlank()) {
            throw new ValidacaoException("Nome do produto é obrigatório");
        }
        if(produto.getDescricao() == null || produto.getDescricao().isBlank()){
            throw new ValidacaoException("Descrição do produto é obrigatório");
        }
    }
}
