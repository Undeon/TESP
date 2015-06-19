package br.unibh.escola.entidades;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TB_PROFESSOR")

public class Professor extends Pessoa {
	
	private BigDecimal salario;
	public static Double Bonus = 0.1D;

	public Professor(){
		super(null, null, null);
	}
	
	public Professor(Long id, String nome, String cpf, BigDecimal salario) {
		super(id, nome, cpf);
		this.salario = salario;
	}
	
	public Professor(Long id, String nome, String cpf) {
		super(id, nome, cpf);
	}

	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return super.toString() + " - Professor Salario = " + salario + "]";
	}

}
