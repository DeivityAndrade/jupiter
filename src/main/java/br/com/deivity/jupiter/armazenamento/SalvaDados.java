package br.com.deivity.jupiter.armazenamento;

import java.util.ArrayList;
import java.util.List;

import br.com.deivity.jupiter.model.CarrinhoModel;
import br.com.deivity.jupiter.model.PerfumeModel;
import br.com.deivity.jupiter.model.PessoaFisicaModel;
import br.com.deivity.jupiter.model.PessoaJuridicaModel;

public class SalvaDados {

	private SalvaDados() {}
	
	public static List<PerfumeModel> perfumes = new ArrayList<PerfumeModel>();
	public static List<PessoaFisicaModel> pessoasFisicas = new ArrayList<>();
	public static List<PessoaJuridicaModel> pessoasJuridicas = new ArrayList<>();
	public static CarrinhoModel carrinho = new CarrinhoModel();
}
