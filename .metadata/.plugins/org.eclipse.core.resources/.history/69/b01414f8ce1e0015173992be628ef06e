package br.unibh.escola.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "TB_DISCIPLINA")
@NamedQueries({ @NamedQuery(name = "Disciplina.findByNameECurso", query = "SELECT d FROM Disciplina d WHERE d.nome LIKE :nome AND d.curso LIKE :curso") })
public class Disciplina {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@NotNull
	@Size(min = 2, max = 100, message = "No minimo 2 no maximo 100 caracters")
	@Pattern(regexp = "[a-zA-Zà-úÀ-Ú ]*", message = "Somente letra e espaço")
	@Column(name = "NOME", columnDefinition = "VARCHAR(100)", length = 100, nullable = false)
	private String nome;

	@NotNull
	@Size(min = 2, max = 100, message = "No minimo 2 no maximo 100 caracters")
	@Pattern(regexp = "[A-Za-z ]*", message = "Somente letra e espaço sem acentos")
	@Column(name = "CURSO", columnDefinition = "VARCHAR(100)", length = 100, nullable = false)
	private String curso;

	@Column(name = "CARGAHORARIA", columnDefinition = "INT(3)", length = 3, nullable = false)
	@DecimalMax(value = "160.00")
	@NotNull
	private int cargaHoraria;

	@Column(name = "TIPO", columnDefinition = "INT(1)", length = 1, nullable = false)
	@NotNull
	private int tipo;

	@NotNull
	@Size(min = 10, max = 4000, message = "Você excedeu o número de caracteres")
	@Column(name = "EMENTA", columnDefinition = "VARCHAR(4000)", length = 4000, nullable = false)
	private String ementa;

	@NotNull
	@Size(min = 10, max = 4000, message = "Você excedeu o número de caracteres")
	@Column(name = "BIBLIOGRAFIA", columnDefinition = "VARCHAR(4000)", length = 4000, nullable = false)
	private String bibliografia;

	@NotNull
	@Size(min = 10, max = 4000, message = "Você excedeu o número de caracteres")
	@Column(name = "DISTRIBUICAO_AVALIACAO", columnDefinition = "VARCHAR(4000)", length = 4000, nullable = false)
	private String distribuicaoAvalicao;

	@Size(max = 4000, message = "Você excedeu o número de caracteres")
	@Column(name = "OBS", columnDefinition = "VARCHAR(4000)", length = 4000, nullable = false)
	private String observacao;

	@ManyToOne
	@NotNull
	private Sala sala;

	@ManyToOne
	@NotNull
	private Professor professor;

	@NotNull
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "TB_DISCIPLINA_ALUNO", joinColumns = { @JoinColumn(name = "DISCIPLINA_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "ALUNO_ID", nullable = false, updatable = false) })
	private List<Aluno> alunos;

	@Version
	@Column(name = "VERSAO")
	private int versao;

	public Disciplina() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getEmenta() {
		return ementa;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(String bibliografia) {
		this.bibliografia = bibliografia;
	}

	public String getDistribuicaoAvalicao() {
		return distribuicaoAvalicao;
	}

	public void setDistribuicaoAvalicao(String distribuicaoAvalicao) {
		this.distribuicaoAvalicao = distribuicaoAvalicao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + id + ", nome=" + nome + ", curso=" + curso
				+ ", cargaHoraria=" + cargaHoraria + ", tipo=" + tipo
				+ ", ementa=" + ementa + ", bibliografia=" + bibliografia
				+ ", distribuicaoAvalicao=" + distribuicaoAvalicao
				+ ", observacao=" + observacao + "]";
	}

}