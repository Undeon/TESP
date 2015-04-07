package br.unibh.persistencia;

import java.sql.PreparedStatement;

public class JDBCTestes {

	public static void limparBanco(String t){
		try {
			PreparedStatement ps = JDBCUtil.getConnection().prepareStatement("TRUNCATE " + t);
			ps.execute();
			
			JDBCUtil.closeConnection();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not truncate");
		}
	}
	
}