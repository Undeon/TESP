package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_ALUNO")
@PrimaryKeyJoinColumn

public class Aluno extends Pessoa {

	@Column(name="matricula", unique=true)
	@NotNull
	private Long matricula;

	private Date dataAniversario;

	public Aluno(Long id, Long matricula, String nome, String cpf, Date dataAniversario) {
		super(id, nome, cpf);
		this.matricula = matricula;
		this.dataAniversario = dataAniversario;
	}

	public Aluno(Long id, Long matricula, String nome, String cpf) {
		super(id, nome, cpf);
		this.matricula = matricula;
	}

	public Aluno(Long id, Long matricula, String nome) {
		super(id, nome, null);
		this.matricula = matricula;
	}

	public static boolean verificaMatricula(String matricula) {
		return matricula != null && !matricula.isEmpty() && matricula.matches("^\\d+$");
	}

	public Long getMatricula() {
		return matricula;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return super.toString() + "Aluno [matricula=" + matricula + ", dataAniversario=" + dataAniversario + "]";
	}
}