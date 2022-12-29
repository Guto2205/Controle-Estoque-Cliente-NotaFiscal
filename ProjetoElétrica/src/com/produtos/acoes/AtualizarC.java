package com.produtos.acoes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.ClientesDAO;
import com.entities.Clientes;
import com.telas.edicao.AtualizarCliente;

public class AtualizarC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton btEditar;
	private DefaultTableModel modelo = new DefaultTableModel();

	public AtualizarC() {
		super("clientes");
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Augus\\OneDrive\\Documentos\\Projetos-Eclipse\\ProjetoGeovane\\imagens\\render caixa de ferramentas.png"));
		setTitle("Atualizar");
		criaJTable();
		criaJanela();
	}

	public void criaJanela() {
		btEditar = new JButton("Editar");
		painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(0, 0, 0));
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(btEditar);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);

		getContentPane().add(painelFundo);
		this.dispose();
		setSize(740, 478);
		setVisible(true);
		btEditar.addActionListener(new BtEditarListener());
	}

	private void criaJTable() {
		tabela = new JTable(modelo);
		modelo.addColumn("Id");
		modelo.addColumn("Nome");
		modelo.addColumn("Telefone");
		modelo.addColumn("Rua");
		modelo.addColumn("Numero");
		modelo.addColumn("Bairro");
		modelo.addColumn("Complemento");
		tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
		tabela.getColumnModel().getColumn(1).setPreferredWidth(80);

		pesquisar(modelo);
	}

	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		ClientesDAO dao = new ClientesDAO();

		for (Clientes c : dao.getClientes()) {
			modelo.addRow(new Object[] { c.getId(), c.getNome(), c.getTelefone(), c.getRua(),
					c.getNumero(), c.getBairro(), c.getComplemento() });
		}
	}

	private class BtEditarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int idCliente = (int) tabela.getValueAt(linhaSelecionada, 0);
				AtualizarCliente ic = new AtualizarCliente(modelo, idCliente, linhaSelecionada);
				ic.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
			}
		}
	}

}
