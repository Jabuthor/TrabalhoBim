package br.univel.TrabalhoBIM;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel{
	
	List<Cliente> lista;

	public ClienteTableModel(List<Cliente> clienteLista) {
		lista = clienteLista;
	}

	public int getColumnCount() {
		return 2;
	}

	public int getRowCount() {
		return lista.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Cliente cliente = lista.get(rowIndex);
		
		switch (columnIndex) {
		case 0:
			return cliente.getId();
		case 1:
			return cliente.getNome();
		}
		return "deu ruim";
	}

}
