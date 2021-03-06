package br.unibh.escola.visao;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.unibh.escola.entidades.Professor;
import br.unibh.escola.negocio.ServicoProfessor;

@ManagedBean(name = "professorMb")
@ViewScoped
public class ControleProfessor {

	@Inject
	ServicoProfessor sp;

	@Inject
	private Logger log;

	private Professor professor;
	private Long id;
	private String nomeArg; // pesquisa por nome
	private List<Professor> professores;

	public String getNomeArg() {
		return nomeArg;
	}

	public void setNomeArg(String nomeArg) {
		this.nomeArg = nomeArg;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	@PostConstruct
	public void inicializa() {
		log.info("Executa o MB de professor");
		try {
			professores = sp.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String gravar() {

		FacesMessage facesMsg;
		try {
			if (professor.getId() == null) {
				professor = sp.insert(professor);
			} else {
				professor = sp.update(professor);
			}
		} catch (Exception e) {
			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro: "
					+ e.getMessage(), "");

			FacesContext.getCurrentInstance().addMessage("messagePanel",
					facesMsg);
			return "professor";
		}
		facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				"Professor " + professor.getNome() + " gravado com sucesso!",
				"");

		FacesContext.getCurrentInstance().addMessage("messagePanel", facesMsg);

		return "professor";
	}

	public void pesquisar() {
		try {
			professores = sp.findByName(nomeArg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		professor = new Professor();
	}

	public void cancelar() {
		professor = null;
	}

	public void editar() {
		try {
			professor = sp.find(id);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir() {
		try {
			sp.Delete(sp.find(id));
			professores = sp.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}