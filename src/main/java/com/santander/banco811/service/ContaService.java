package com.santander.banco811.service;

import com.santander.banco811.dto.ContaRequest;
import com.santander.banco811.model.Conta;

import java.util.List;

public interface ContaService {
    Conta create(ContaRequest contaRequest, String username);

    List<Conta> getAll(String nome);
}
