package com.antonia.loja.repository;

import com.antonia.loja.domain.CadastroFuncionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CadastroFuncionarioRepository extends JpaRepository<CadastroFuncionario, Long> {
    Optional<CadastroFuncionario> findByEmail(String email);

    boolean existsByEmail(String email);

    boolean existsByCpf(String cpf);
}
