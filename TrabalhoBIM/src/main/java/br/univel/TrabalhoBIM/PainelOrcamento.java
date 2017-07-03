package br.univel.TrabalhoBIM;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class PainelOrcamento extends JPanel {
	private JTable table;
	private JTable table_orcamento;
	private List<Produto> prod;
	private List<Produto> prodOrcamento = new ArrayList<Produto>();
	private Produto selecionado;
	private JLabel lblValorTotal;
	private BigDecimal total = new BigDecimal(0);
	public PainelOrcamento() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				selecionado = prod.get(table.getSelectedRow());
				
				prodOrcamento.add(selecionado);
				ProdutoTableModel ptm2 = new ProdutoTableModel(prodOrcamento);
				table_orcamento.setModel(ptm2);
				BigDecimal valorProd = selecionado.getValorDolar();
				total = total.add(valorProd).setScale(2, RoundingMode.DOWN);
				lblValorTotal.setText("Valor Total: "+ total); 
			}
		});
		GridBagConstraints gbc_btnAdicionar = new GridBagConstraints();
		gbc_btnAdicionar.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdicionar.gridx = 1;
		gbc_btnAdicionar.gridy = 0;
		panel.add(btnAdicionar, gbc_btnAdicionar);
		
		JButton btnExportarPdf = new JButton("Exportar PDF");
		btnExportarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatorio r = new Relatorio();
				r.exportar(prodOrcamento);
			}
		});
		GridBagConstraints gbc_btnExportarPdf = new GridBagConstraints();
		gbc_btnExportarPdf.insets = new Insets(0, 0, 5, 0);
		gbc_btnExportarPdf.gridx = 1;
		gbc_btnExportarPdf.gridy = 1;
		panel.add(btnExportarPdf, gbc_btnExportarPdf);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		table_orcamento = new JTable();
		scrollPane_1.setViewportView(table_orcamento);
		ProdutoDAO dao = new ProdutoDAO();
		prod = dao.listar();
		ProdutoTableModel ptm = new ProdutoTableModel(prod);
		table.setModel(ptm);
		
		lblValorTotal = new JLabel("Valor Total:");
		GridBagConstraints gbc_lblValorTotal = new GridBagConstraints();
		gbc_lblValorTotal.gridx = 1;
		gbc_lblValorTotal.gridy = 2;
		panel.add(lblValorTotal, gbc_lblValorTotal);
		
	}

}
