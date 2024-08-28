package com.remedios.camille.curso.remedio;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="remedios")
@Table(name="remedio")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of= "id")
@Setter
@Getter


public class Remedio {

	public Remedio() {
    }
	
	public Remedio(DadosCadastroRemedio dados) {
		this.setAtivo(true);
		this.nome = dados.nome();
		this.via = dados.via();
		this.lote = dados.lote();
		this.setQuantidade(dados.quantidade());
		this.validade = dados.validade();
		this.laboratorio = dados.laboratorio();
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@Enumerated(EnumType.STRING)
	private Via via;
	private String lote;
	private int quantidade;
	private LocalDate validade;
	
	@Enumerated(EnumType.STRING)
	private Laboratorio laboratorio;
	
	private Boolean ativo;

	public String getNome() {
		return nome;
	}

	public Via getVia() {
		return via;
	}

	public String getLote() {
		return lote;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public Long getId() {
		return id;
	}

	public void atualizarInformacoes(@Valid DadosAtualizarRemedio dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.via() != null) {
			this.via = dados.via();
		}
		
	}

	public void inativar() {
		this.setAtivo(false);
	}
	
	public void reativar() {
		this.setAtivo(true);
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
