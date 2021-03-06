package com.dev.republica.service;

import java.util.List;

import javax.validation.constraints.Min;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import com.dev.republica.model.Morador;
import com.dev.republica.model.ReceitaDespesa;
import com.dev.republica.model.Republica;

@Validated
public interface ReceitaDespesaService {

	List<ReceitaDespesa> getAllReceitaDespesas();

	ReceitaDespesa getReceitaDespesa(@Min(value = 1L, message = "ID ReceitaDespesa inválido.") Long id);

	ReceitaDespesa save(ReceitaDespesa receitaDespesa);

	ResponseEntity<ReceitaDespesa> update(Long id, ReceitaDespesa receitaDespesa);

	ResponseEntity<?> deleteById(Long id);

	List<ReceitaDespesa> getReceitaDespesaByRepublica(Republica republica);

	List<ReceitaDespesa> getReceitaDespesaByRepublicaAndMorador(Republica republica, Morador morador);

}
