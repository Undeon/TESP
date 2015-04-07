package br.unibh;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Date;

import br.unibh.entidades.Aluno;
import br.unibh.entidades.Professor;
import br.unibh.persistencia.JDBCUtil;

public class aula1 {

	public static void main(String[] args) {

		Aluno a1 = new Aluno(1L, 1234L, "João", "14725836928", new Date());
		Aluno a2 = new Aluno(2L, 5678L, "Maria", "47659730198");

		Professor p1 = new Professor(4L, "Marcos", "7948560", new BigDecimal(
				"785946287"));

		System.out.println("BÔNUS ===== " + Professor.Bonus);
		System.out.println(Aluno.verificaMatricula(("16798562487")));
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(p1);
		
		try {
			ResultSet rs = JDBCUtil.getConnection().prepareStatement("SELECT * FROM tb_aluno;").executeQuery();
			while(rs.next()){
				System.out.println(rs.getLong("ID") + "\t" + rs.getString("NOME"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

		// for(int i = 0; i < 10; i++)
		// System.out.println("Alô mundo");
	}

}