package br.univel.TrabalhoBIM;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

public class Relatorio {

	
	public void exportarOrcamento(List<Produto> lista) {
		String strFile = "C:\\Users\\Luiz\\JaspersoftWorkspace\\MyReports\\OrcamentoUnico.jasper";



			JRDataSource customDs = new RelatorioDataSource(lista);
			JasperPrint jp;

			try {

				jp = JasperFillManager.fillReport(strFile, null, customDs);
				
				SimpleDateFormat sdf = new SimpleDateFormat("(yyyy-MM-dd)_HH-mm-ss");
				String data = sdf.format(new Date());
				
				String nomePdf = "relatorio_orcamento_" + data + ".pdf";
				JasperExportManager.exportReportToPdfFile(jp, nomePdf);
				Desktop.getDesktop().open(new File(nomePdf));

			} catch (JRException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
