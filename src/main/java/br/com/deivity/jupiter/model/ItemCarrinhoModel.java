package br.com.deivity.jupiter.model;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class ItemCarrinhoModel {
	
	private Long id;
    private PerfumeModel perfume;
    private Integer qtd;
    private BigDecimal valorTotal;
    
    private static long gerador = 0;

    public ItemCarrinhoModel(PerfumeModel p, final Integer qtd) {
        this.id = ++gerador;
        this.perfume = p;
        this.qtd = qtd;
        this.valorTotal = p.getValor().multiply(BigDecimal.valueOf(qtd));
    }

	public Long getId() {
		return id;
	}

	public PerfumeModel getPerfume() {
		return perfume;
	}

	public Integer getQtd() {
		return qtd;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public static long getGerador() {
		return gerador;
	}
}

