package br.univel.TrabalhoBIM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {
	
	public void inserir(Produto p) {
		Connection con = ConexaoDB.getInstance().getConnection();
		try  {
			PreparedStatement ps = con.prepareStatement("INSERT INTO PRODUTO(id_produto, descricao, valor) VALUES(?, ?, ?)");
			ps.setLong(1, p.getId());
			ps.setString(2, p.getDescricao());
			ps.setBigDecimal(3, p.getValorDolar());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

	public void atualizar(Produto p) {
		
	}

	public void excluir(Produto p) {
		
	}

	public Produto buscar(int id) {
		
		return null;
	}

	public Produto buscarPorExemplo(Produto p) {
		
		return null;
	}

	public List<Produto> listar() {
		Connection con = ConexaoDB.getInstance().getConnection();
		
		List<Produto> lista = new ArrayList<Produto>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM PRODUTO");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Produto p = new Produto();
				
				p.setId(rs.getLong(1));
				p.setDescricao(rs.getString(2));
				p.setValorDolar(rs.getBigDecimal(3));
				
				lista.add(p);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
}
