package com.santander.banco811.controller;

import com.santander.banco811.dto.ContaRequest;
import com.santander.banco811.model.Conta;
import com.santander.banco811.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    private static final String USERNAME = "USERNAME";

    @Autowired
    ContaService contaService;

    @GetMapping
    public List<Conta> getAll(
            @RequestParam(required = false) String nome)
    {
        return contaService.getAll(nome);
    }

    @PostMapping
    public Conta create(@RequestBody ContaRequest contaRequest) {
        var username = RequestContextHolder
                .getRequestAttributes()
                .getAttribute(USERNAME, RequestAttributes.SCOPE_REQUEST)
                .toString();
        return contaService.create(contaRequest, username);
    }
}
