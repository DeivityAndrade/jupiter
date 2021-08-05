package br.com.deivity.jupiter.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class CarrinhoModel {

	private Long id;
	private EnumStatusItemCarrinhoModel status;
	private Integer qtd;
	private PerfumeModel perfume ;
	public static List<ItemCarrinhoModel> itens;
	 private static  long gerador = 0;

	public CarrinhoModel() {
		this.itens = new ArrayList<ItemCarrinhoModel>();
		this.id = gerador++;
		this.status = EnumStatusItemCarrinhoModel.INICIALIZADO;
	}

	public void addPerfume(PerfumeModel perfume, Integer qtd) {
		if (EnumStatusItemCarrinhoModel.FINALIZADO.equals(this.status)) {
			throw new RuntimeException("Carrinho finalizado");
		}
		this.itens.add(new ItemCarrinhoModel(perfume, qtd));
	}

	public void finalizar() {
		this.status = EnumStatusItemCarrinhoModel.FINALIZADO;
	}

	public BigDecimal getValorTotal() {
		BigDecimal soma = BigDecimal.ZERO;
		for(ItemCarrinhoModel i : itens) {
			soma = soma.add(i.getValorTotal());
		}
		return soma;
	}
	public List<ItemCarrinhoModel> getItens() {
		return itens;
	}
	public Long getId() {
		return id;
	}
	public EnumStatusItemCarrinhoModel getStatus() {
		return status;
	}
	public Integer getQtd() {
		return qtd;
	}
	public PerfumeModel getPerfume() {
		return perfume;
	}
}


