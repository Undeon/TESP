package br.unibh.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.unibh.entidades.Professor;

public class ProfessorDAO implements DAO<Professor, Long> {

	public Professor find(Long id) {
		try {
			PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(
					"SELECT * FROM TB_PROFESSOR WHERE ID = ?");
			ps.setLong(1, id);

			ResultSet row = ps.executeQuery();

			if (row.next()) {
				return new Professor(row.getLong("ID"), row.getString("NOME"),
						row.getString("CPF"), row.getBigDecimal("SALARIO"));
			}

		} catch (Exception e) {

		}

		return null;
	}

	public Professor findByCPF(String cpf) {
		try {
			PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(
					"SELECT * FROM TB_PROFESSOR WHERE CPF = ?");
			ps.setString(1, cpf);

			ResultSet row = ps.executeQuery();

			if (row.next()) {
				return new Professor(row.getLong("ID"), row.getString("NOME"),
						row.getString("CPF"), row.getBigDecimal("SALARIO"));
			}

		} catch (Exception e) {

		}

		return null;
	}

	public void insert(Professor t) {
		try {
			PreparedStatement ps = JDBCUtil
					.getConnection()
					.prepareStatement(
							"INSERT INTO TB_PROFESSOR (NOME, CPF, SALARIO) VALUES(?, ?, ?);");
			ps.setString(1, t.getNome());
			ps.setString(2, t.getCpf());
			ps.setBigDecimal(3, t.getSalario());

			ps.executeUpdate();

			JDBCUtil.closeConnection();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void update(Professor t) {

		try {

			String sql = "UPDATE TB_PROFESSOR SET NOME = ?, CPF = ?, SALARIO = ? WHERE ID = ? LIMIT 1;";

			PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(
					sql);

			ps.setString(1, t.getNome());
			ps.setString(2, t.getCpf());
			ps.setBigDecimal(3, t.getSalario());
			ps.setLong(4, t.getId());

			ps.executeUpdate();

			JDBCUtil.closeConnection();

		} catch (Exception e) {

		}

	}

	public void delete(Professor t) {
		try {
			String sql = "DELETE FROM TB_PROFESSOR WHERE ID = ? LIMIT 1;";
			PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(
					sql);
			ps.setLong(1, t.getId());

			ps.executeUpdate();

			JDBCUtil.closeConnection();

		} catch (Exception e) {
		}
	}

	public List<Professor> findAll() {
		ArrayList<Professor> rows = new ArrayList<Professor>();

		try {
			PreparedStatement ps = JDBCUtil.getConnection().prepareStatement(
					"SELECT * FROM TB_PROFESSOR;");

			ResultSet row = ps.executeQuery();

			while (row.next()) {
				rows.add(new Professor(row.getLong("ID"), row.getString("NOME"),
						row.getString("CPF"), row.getBigDecimal("SALARIO")));
			}

			JDBCUtil.closeConnection();
			
			return rows;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}