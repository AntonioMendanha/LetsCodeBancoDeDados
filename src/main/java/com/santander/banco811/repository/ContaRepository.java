package com.santander.banco811.repository;

import com.santander.banco811.model.Conta;
import com.santander.banco811.model.TipoConta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {
    List<Conta> findBySaldoLessThan(BigDecimal saldo);
    List<Conta> findBySaldoLessThanEqual(BigDecimal saldo);

    List<Conta> findByTipoContaAndSaldoBetweenOrderBySaldo(TipoConta tipoConta, BigDecimal saldoInicial, BigDecimal saldoFinal);

    List<Conta> findByUsuario_cpf(String cpf);

    Boolean existsByTipoConta(TipoConta tipoConta);

    @Query("select c from Conta c where c.tipoConta = :tipoConta and c.usuario.cpf = :cpf or c.tipoConta = :tipoConta or c.saldo = :saldo")
    List<Conta> findByTipoContaAndCpfOrTipoContaAndSaldo(
            @Param("tipoConta") TipoConta tipoConta,
            @Param("cpf") String cpf,
            @Param("saldo") BigDecimal saldo);

    @Query("select c from Conta c where c.tipoConta = :tipoConta AND c.usuario.nome = :nome")
    List<Conta> findByTipoContaAndUsuarioName(
            @Param("tipoConta") TipoConta tipoConta,
            @Param("nome") String nome
            );

}
