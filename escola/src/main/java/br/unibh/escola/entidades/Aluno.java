package br.unibh.escola.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TB_ALUNO", uniqueConstraints = @UniqueConstraint(columnNames = "matricula"))
@NamedQueries({@NamedQuery(name="Aluno.findbyName", query = "select a from Aluno a where a.nome like :nome)")})
@PrimaryKeyJoinColumn

public class Aluno extends Pessoa {

	@NotNull
	@Column(name="MATRICULA", unique=true, nullable=false)
	private Long matricula;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name="DATA_ANIVERSARIO", nullable=false, columnDefinition="DATE")
	private Date dataAniversario;

	public Aluno() {
		super(null, null, null);
	}
	
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