package br.univel.TrabalhoBIM;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnReceberLista = new JButton("Receber Lista");
		btnReceberLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				URLReader ur = new URLReader();
				try {
					List<Produto> lista = ur.lerProdutos();
					
					ProdutoTableModel ptm = new ProdutoTableModel(lista);
					
					table.setModel(ptm);
					
					ProdutoDAO dao = new ProdutoDAO();
					for (Produto produto : lista) {
						dao.inserir(produto);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		GridBagConstraints gbc_btnReceberLista = new GridBagConstraints();
		gbc_btnReceberLista.anchor = GridBagConstraints.WEST;
		gbc_btnReceberLista.insets = new Insets(0, 0, 0, 5);
		gbc_btnReceberLista.gridx = 0;
		gbc_btnReceberLista.gridy = 0;
		panel.add(btnReceberLista, gbc_btnReceberLista);
		
		JButton btnCadastarCliente = new JButton("Cadastar Cliente");
		btnCadastarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelCliente pc = new PainelCliente();
				setGlassPane(pc);
				getGlassPane().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnCadastarCliente = new GridBagConstraints();
		gbc_btnCadastarCliente.insets = new Insets(0, 0, 0, 5);
		gbc_btnCadastarCliente.gridx = 1;
		gbc_btnCadastarCliente.gridy = 0;
		panel.add(btnCadastarCliente, gbc_btnCadastarCliente);
		
		JButton btnFazerOramento = new JButton("Fazer Orçamento");
		btnFazerOramento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PainelOrcamento po = new PainelOrcamento();
				setGlassPane(po);
				getGlassPane().setVisible(true);
			}
		});
		GridBagConstraints gbc_btnFazerOramento = new GridBagConstraints();
		gbc_btnFazerOramento.gridx = 2;
		gbc_btnFazerOramento.gridy = 0;
		panel.add(btnFazerOramento, gbc_btnFazerOramento);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
