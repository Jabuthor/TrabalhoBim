package br.univel.TrabalhoBIM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
	
	
	public void inserir(Cliente c){
		Connection con = ConexaoDB.getInstance().getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO CLIENTE (ID_CLIENTE, NOME) VALUES (?, ?);");
			ps.setInt(1, c.getId());
			ps.setString(2, c.getNome());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Cliente> buscartodos(){
		Connection con = ConexaoDB.getInstance().getConnection();
		
		List<Cliente> lista = new ArrayList<Cliente>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM CLIENTE");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Cliente c = new Cliente();
				
				c.setId(rs.getInt(1));
				c.setNome(rs.getString(2));
				lista.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
