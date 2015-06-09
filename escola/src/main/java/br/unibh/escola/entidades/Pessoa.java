package br.unibh.escola.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="TB_PESSOA")

public abstract class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Long id;
	
	@NotNull
	@Size(min= 50, max=100)
	@Pattern(regexp= "[A-Za-z ]*", message = "must contain only letters and spaces")
	private String nome;
	
	@Column(name="CPF", unique=true, columnDefinition="CHAR(14)", length=14, nullable=false)
	@NotBlank
	@Size(min=14, max=14)
	@Pattern(regexp = "^\\d{3},\\d{3}-\\d{2}$")
	private String cpf;

	
	public Pessoa(Long id, String nome, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Pessoa [Nome = " + nome + " - ID = " + id + " - CPF = " + cpf;
	}

}
