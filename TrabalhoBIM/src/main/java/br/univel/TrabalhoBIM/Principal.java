package br.univel.TrabalhoBIM;

import java.util.List;

public class Principal {
	public static void main(String[] args) {
		ProdutoDAO pd=new ProdutoDAO();
		URLReader url=new URLReader();
		List<Produto> list;
		try {
			list = url.lerProdutos();
			for (Produto produto : list) {
				pd.inserir(produto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
