package br.unibh.escola.visao;


import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.unibh.escola.entidades.Aluno;
import br.unibh.escola.entidades.Disciplina;
import br.unibh.escola.entidades.Professor;
import br.unibh.escola.entidades.Sala;
import br.unibh.escola.negocio.ServicoAluno;
import br.unibh.escola.negocio.ServicoDisciplina;
import br.unibh.escola.negocio.ServicoProfessor;
import br.unibh.escola.negocio.ServicoSala;

@ManagedBean(name = "disciplinaMb")
@ViewScoped
public class ControleDisciplina {
	@Inject
	private Logger log;

	@Inject
	private ServicoDisciplina sd;

	@Inject
	private ServicoSala ss;

	@Inject
	private ServicoAluno sa;

	@Inject
	private ServicoProfessor sp;

	private Disciplina disciplina;
	private Long id;
	private String nomeDisciplina;
	private String nomeCurso;
	private List<Disciplina> disciplinas;
	private List<Professor> professores;
	private List<Sala> salas;
	private List<Aluno> alunos;

	public ServicoDisciplina getSd() {
		return sd;
	}

	public void setSd(ServicoDisciplina sd) {
		this.sd = sd;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public ServicoAluno getSa() {
		return sa;
	}

	public void setSa(ServicoAluno sa) {
		this.sa = sa;
	}

	public ServicoProfessor getSp() {
		return sp;
	}

	public void setSp(ServicoProfessor sp) {
		this.sp = sp;
	}

	public ServicoSala getSs() {
		return ss;
	}

	public void setSs(ServicoSala ss) {
		this.ss = ss;
	}

	public List<Professor> getProfessores() {
		try {
			return sp.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Sala> getSalas() {
		try {
			return ss.findAll();
		} catch (Exception e) {
		}
		return salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public List<Aluno> getAlunos() {
		try {
			return sa.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public String getTipo(int n) {
		switch (n) {
		case 1:
			return "Presencial";
		case 2:
			return "À distância";
		case 3:
			return "Presencial e à distância";
		default:
			return "";
		}

	}

	@PostConstruct
	public void listaDisciplina() {
		log.info("excutando o MB de disciplina");
		try {
			disciplinas = sd.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String gravar() {
		FacesMessage facesMsg;
		try {
			if (disciplina.getId() == null) {
				disciplina = sd.insert(disciplina);
			} else {
				disciplina = sd.update(disciplina);
			}
		} catch (Exception e) {
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: "
					+ e.getMessage(), "");

			FacesContext.getCurrentInstance().addMessage("messagePanel",
					facesMsg);
			return "disciplina";
		}
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Disciplina gravada com sucesso!", "");

		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);
		return "disciplina";
	}

	public void pesquisa() {
		try {
			disciplinas = sd.findByNameECurso(nomeDisciplina, nomeCurso);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		disciplina = new Disciplina();
	}

	public void editar() {
		try {
			disciplina = sd.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
	}

	public void excluir() {
		try {
			sd.Delete(sd.find(id));
			disciplinas = sd.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		disciplina = null;
	}

	public String cancelar() {
		// disciplina = null;
		return "disciplina";
	}

}