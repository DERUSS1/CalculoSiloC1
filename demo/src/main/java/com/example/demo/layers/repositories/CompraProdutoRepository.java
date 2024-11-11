package com.example.demo.layers.repositories;

import com.example.demo.layers.entities.CompraProduto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraProdutoRepository extends JpaRepository<CompraProduto, Long> {
    
}
