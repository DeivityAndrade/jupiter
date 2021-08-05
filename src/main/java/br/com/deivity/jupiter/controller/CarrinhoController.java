package br.com.deivity.jupiter.controller;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.deivity.jupiter.armazenamento.SalvaDados;
import br.com.deivity.jupiter.model.CarrinhoModel;
import br.com.deivity.jupiter.model.PerfumeModel;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

	@GetMapping("/add-perfume")
	public CarrinhoModel addPerfume(@RequestParam Long id,
			@RequestParam Integer qtd) {

		PerfumeModel perfume = SalvaDados.perfumes.stream()
				.filter(p -> id.equals(p.getId()))
				.findFirst()
				.orElse(null);
		if (Objects.isNull(perfume)) {
			return null;
		}
		CarrinhoModel c = SalvaDados.carrinho;
		c.addPerfume(perfume, qtd);
		return c;

	}
	@GetMapping("/finalizar")
	public CarrinhoModel finalizar() {		
		CarrinhoModel c = SalvaDados.carrinho;
		c.finalizar();
		SalvaDados.carrinho = new CarrinhoModel();
		return c;
	}
	@GetMapping("/ver")
	public CarrinhoModel ver() {
		return SalvaDados.carrinho;
	}
}

