package br.univel.TrabalhoBIM;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ProdutoTableModel extends AbstractTableModel{
	
	private List<Produto> lista;
	
	public ProdutoTableModel(List<Produto> lista){
		this.lista = lista;
	}
	
	public int getColumnCount() {
		return 3;
	}

	public int getRowCount() {
		return this.lista.size();
	}

	public Object getValueAt(int arg0, int arg1) {
		Produto prod = lista.get(arg0);
		
		switch (arg1) {
		case 0:
			return prod.getId();
		case 1:
			return prod.getDescricao();
		case 2:
			return prod.getValorDolar();
		}
		return "deu ruim";
	}

}
