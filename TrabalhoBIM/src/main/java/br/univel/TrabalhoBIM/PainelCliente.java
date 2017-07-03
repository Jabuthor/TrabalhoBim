package br.univel.TrabalhoBIM;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PainelCliente extends JPanel {
	private JTextField textFieldId;
	private JTextField textFieldNome;
	private JTable table;
	private List<Cliente> clienteLista = new ArrayList<Cliente>();

	public PainelCliente() {
		setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblId = new JLabel("ID");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		panel.add(lblId, gbc_lblId);
		
		textFieldId = new JTextField();
		GridBagConstraints gbc_textFieldId = new GridBagConstraints();
		gbc_textFieldId.anchor = GridBagConstraints.WEST;
		gbc_textFieldId.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldId.gridx = 1;
		gbc_textFieldId.gridy = 0;
		panel.add(textFieldId, gbc_textFieldId);
		textFieldId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		GridBagConstraints gbc_lblNome = new GridBagConstraints();
		gbc_lblNome.anchor = GridBagConstraints.EAST;
		gbc_lblNome.insets = new Insets(0, 0, 0, 5);
		gbc_lblNome.gridx = 0;
		gbc_lblNome.gridy = 1;
		panel.add(lblNome, gbc_lblNome);
		
		textFieldNome = new JTextField();
		GridBagConstraints gbc_textFieldNome = new GridBagConstraints();
		gbc_textFieldNome.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldNome.gridx = 1;
		gbc_textFieldNome.gridy = 1;
		panel.add(textFieldNome, gbc_textFieldNome);
		textFieldNome.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				
				c.setId(new Integer(textFieldId.getText()));
				c.setNome(textFieldNome.getText());
				
				ClienteDAO dao = new ClienteDAO();
				dao.inserir(c);
				clienteLista = dao.buscartodos();
				
				ClienteTableModel ctm = new ClienteTableModel(clienteLista);
				table.setModel(ctm);
				
			}
		});
		GridBagConstraints gbc_btnSalvar = new GridBagConstraints();
		gbc_btnSalvar.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalvar.anchor = GridBagConstraints.EAST;
		gbc_btnSalvar.gridx = 0;
		gbc_btnSalvar.gridy = 0;
		panel_1.add(btnSalvar, gbc_btnSalvar);
		
		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		GridBagConstraints gbc_btnFechar = new GridBagConstraints();
		gbc_btnFechar.gridx = 1;
		gbc_btnFechar.gridy = 0;
		panel_1.add(btnFechar, gbc_btnFechar);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		ClienteDAO dao = new ClienteDAO();
		clienteLista = dao.buscartodos();
		
		ClienteTableModel ctm = new ClienteTableModel(clienteLista);
		table.setModel(ctm);
		
		

	}

}
