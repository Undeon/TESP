package br.unibh.escola.visao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.InitialContext;

import br.unibh.escola.entidades.Professor;
import br.unibh.escola.negocio.ServicoProfessor;

@FacesConverter("ConversorProfessor")
public class ConversorProfessor implements Converter {

	@Override
	public Object getAsObject(FacesContext ctx, UIComponent componente,
			String valor) {
		try {
			ServicoProfessor sp = (ServicoProfessor) new InitialContext()
					.lookup("java:global/escola-phs/ServicoProfessor");

			return sp.find(new Long(valor));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext ctx, UIComponent component,
			Object valor) {
		if (valor != null) {
			Professor p = (Professor) valor;
			if (p.getId() != null) {
				return p.getId().toString();
			}
		}
		return null;
	}

}