package br.com.deivity.jupiter.model;



import java.math.BigDecimal;
import java.util.SplittableRandom;


public class PerfumeModel {

    private Long id;
    private String nome;
    private BigDecimal valor;
    private EnumTipoPerfumeModel tipo;
    
    private static  long gerador = 0;

    public PerfumeModel(String nome, BigDecimal valor, EnumTipoPerfumeModel tipo) {
        this.id = ++gerador;
        this.nome = nome;
        this.valor = valor;
        this.tipo = tipo;
    }

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EnumTipoPerfumeModel getTipo() {
		return tipo;
	}

	public static long getGerador() {
		return gerador;
	}
	public void alterar(String nome,BigDecimal valor,EnumTipoPerfumeModel tipo) {
		this.nome=nome;
		this.valor=valor;
		this.tipo=tipo;
	}
	public void remover(Long id) {
		this.id=id;
	}
    
}