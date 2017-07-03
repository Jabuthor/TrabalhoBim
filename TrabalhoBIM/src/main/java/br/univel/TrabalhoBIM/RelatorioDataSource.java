package br.univel.TrabalhoBIM;

import java.util.Iterator;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class RelatorioDataSource implements JRDataSource {
	
	private Iterator<Produto> it;
	private Produto selecionado;
	
	public RelatorioDataSource(List<Produto> lista) {
		this.it = lista.iterator();
	}

	public Object getFieldValue(JRField field) throws JRException {
		if("id_produto".equals(field.getName())){
			return String.valueOf(selecionado.getId());
		}
		if("descricao_produto".equals(field.getName())){
			return String.valueOf(selecionado.getDescricao());
		}
		if("valor".equals(field.getName())){
			return String.valueOf(selecionado.getValorDolar());
		}

		throw new RuntimeException("Deu ruim!");
	}

	public boolean next() throws JRException {
		if(this.it.hasNext()){
			this.selecionado = it.next();
			return true;
		}
		return false;
	}

}
