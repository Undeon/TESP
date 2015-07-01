package br.unibh.escola.visao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;

import br.unibh.escola.entidades.Aluno;
import br.unibh.escola.negocio.ServicoAluno;

@FacesConverter("ConversorAluno")
public class ConversorAluno implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent componente,
			String valor) {
		try {
			ServicoAluno sa = (ServicoAluno) new InitialContext()
					.lookup("java:global/escola-phs/ServicoAluno");
			return sa.find(new Long(valor));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent componete,
			Object valor) {
		if (valor != null) {
			Aluno a = (Aluno) valor;
			if (a.getId() != null) {
				return a.getId().toString();
			}
		}
		return null;
	}

}