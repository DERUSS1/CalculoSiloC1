package com.example.demo.layers.repositories;

import com.example.demo.layers.entities.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, Long> {
}
