package br.com.deivity.jupiter.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.deivity.jupiter.armazenamento.SalvaDados;
import br.com.deivity.jupiter.model.EnumTipoPerfumeModel;
import br.com.deivity.jupiter.model.PerfumeModel;

@RestController
@RequestMapping("/perfume")
public class PerfumeController {

	@GetMapping("/cadastrar-perfume")
	public PerfumeModel Cadastrar(
			@RequestParam String nome,
			@RequestParam EnumTipoPerfumeModel tipo,
			@RequestParam BigDecimal valor
			) {
		PerfumeModel perfume = new PerfumeModel(nome, valor, tipo);
		SalvaDados.perfumes.add(perfume);
		return perfume;
	}
	@GetMapping("/listar")
	public List<PerfumeModel> listar(){
		return SalvaDados.perfumes;
	}
	@GetMapping("/alterar")
	public PerfumeModel alterar(
			@RequestParam Long id,
			@RequestParam String nome,
			@RequestParam EnumTipoPerfumeModel tipo,
			@RequestParam BigDecimal valor) {
		PerfumeModel perfume = SalvaDados.perfumes
				.stream()
				.filter(p -> id.equals(p.getId()))
				.findFirst()
				.orElse(null);
		if (Objects.isNull(perfume)) {
			return null;
		}
		perfume.alterar(nome, valor, tipo);
		return perfume;
	}
	@GetMapping("/remover")
	public PerfumeModel remover(@RequestParam Long id) {
		PerfumeModel perfume = SalvaDados.perfumes
				.stream()
				.filter(p -> id.equals(p.getId()))
				.findFirst()
				.orElse(null);
		if (Objects.isNull(perfume)) {
			return null;
		}
		SalvaDados.perfumes.remove(perfume);
		return perfume;
	}
}