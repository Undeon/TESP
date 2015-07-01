package br.unibh.escola.entidades;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TB_SALA", uniqueConstraints = @UniqueConstraint(columnNames = "codigo"))
@NamedQueries({ @NamedQuery(name = "Sala.findByCapacidade", query = "select s from Sala s where s.capacidade >= :capacidade") })
public class Sala {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private Long id;

	@Column(name = "CODIGO", nullable = false, columnDefinition = "VARCHAR(10)")
	@NotNull
	private String codigo;

	@Column(name = "CAPACIDADE", nullable = false, columnDefinition = "INT")
	@NotNull
	private Integer capacidade;

	@Column(name = "POSSUIQUADROBRANCO", nullable = true, columnDefinition = "BOOLEAN")
	@NotNull
	private boolean possuiQuadroBranco;

	@Column(name = "POSSUIDATASHOW", nullable = true, columnDefinition = "BOOLEAN")
	@NotNull
	private boolean possuiDataShow;

	@Column(name = "POSSUICOMPUTADOR", nullable = true, columnDefinition = "BOOLEAN")
	@NotNull
	private boolean possuiComputador;

	@Column(name = "OBSERVACAO", nullable = true, columnDefinition = "VARCHAR(255)")
	@NotNull
	private String observacao;

	@Column(name = "STATUS", nullable = false, columnDefinition = "INT")
	@NotNull
	private int status;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATATERMINOMANUTENCAO", nullable = true, columnDefinition = "DATE")
	private Date dataTerminoManutencao;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "sala")
	private List<Disciplina> disciplinas;

	@Version
	@Column(name = "VERSAO")
	private int versao;

	public Sala() {
	}

	public Sala(Long id, String codigo, Integer capacidade,
			boolean possuiQuadroBranco, boolean possuiDataShow,
			boolean possuiComputador, String observacao, int status,
			Date dataTerminoManutencao) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.capacidade = capacidade;
		this.possuiQuadroBranco = possuiQuadroBranco;
		this.possuiDataShow = possuiDataShow;
		this.possuiComputador = possuiComputador;
		this.observacao = observacao;
		this.status = status;
		this.dataTerminoManutencao = dataTerminoManutencao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public boolean isPossuiQuadroBranco() {
		return possuiQuadroBranco;
	}

	public void setPossuiQuadroBranco(boolean possuiQuadroBranco) {
		this.possuiQuadroBranco = possuiQuadroBranco;
	}

	public boolean isPossuiDataShow() {
		return possuiDataShow;
	}

	public void setPossuiDataShow(boolean possuiDataShow) {
		this.possuiDataShow = possuiDataShow;
	}

	public boolean isPossuiComputador() {
		return possuiComputador;
	}

	public void setPossuiComputador(boolean possuiComputador) {
		this.possuiComputador = possuiComputador;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getDataTerminoManutencao() {
		return dataTerminoManutencao;
	}

	public void setDataTerminoManutencao(Date dataTerminoManutencao) {
		this.dataTerminoManutencao = dataTerminoManutencao;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", codigo=" + codigo + ", capacidade="
				+ capacidade + ", possuiQuadroBranco=" + possuiQuadroBranco
				+ ", possuiDataShow=" + possuiDataShow + ", possuiComputador="
				+ possuiComputador + ", observacao=" + observacao + ", status="
				+ status + ", dataTerminoManutencao=" + dataTerminoManutencao
				+ "]";
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((capacidade == null) ? 0 : capacidade.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime
				* result
				+ ((dataTerminoManutencao == null) ? 0 : dataTerminoManutencao
						.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		result = prime * result + (possuiComputador ? 1231 : 1237);
		result = prime * result + (possuiDataShow ? 1231 : 1237);
		result = prime * result + (possuiQuadroBranco ? 1231 : 1237);
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sala other = (Sala) obj;
		if (capacidade == null) {
			if (other.capacidade != null)
				return false;
		} else if (!capacidade.equals(other.capacidade))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataTerminoManutencao == null) {
			if (other.dataTerminoManutencao != null)
				return false;
		} else if (!dataTerminoManutencao.equals(other.dataTerminoManutencao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		if (possuiComputador != other.possuiComputador)
			return false;
		if (possuiDataShow != other.possuiDataShow)
			return false;
		if (possuiQuadroBranco != other.possuiQuadroBranco)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

}