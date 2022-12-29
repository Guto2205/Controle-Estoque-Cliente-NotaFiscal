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
import com.dao.ProdutoDAO;
import com.entities.Clientes;

public class ExcluirC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton btExcluir;
	private DefaultTableModel modelo = new DefaultTableModel();

	public ExcluirC() {
		super("clientes");
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Augus\\OneDrive\\Documentos\\Projetos-Eclipse\\ProjetoGeovane\\imagens\\render caixa de ferramentas.png"));
		setTitle("Excluir");
		criaJTable();
		criaJanela();
	}

	public void criaJanela() {
		btExcluir = new JButton("Excluir");
		painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(0, 0, 0));
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(btExcluir);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);

		getContentPane().add(painelFundo);
		this.dispose();
		setSize(740, 478);
		setVisible(true);
		btExcluir.addActionListener(new BtExcluirListener());
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
			modelo.addRow(new Object[]{c.getId(), c.getNome(),
			c.getTelefone(), c.getRua(), c.getNumero(), c.getBairro(), c.getComplemento()});
		}
	}

	private class BtExcluirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int idCliente = (int)
				tabela.getValueAt(linhaSelecionada, 0);
				ClientesDAO dao = new ClientesDAO();
				dao.remover(idCliente);
				modelo.removeRow(linhaSelecionada);
			} else {
				JOptionPane.showMessageDialog(null,"É necesário selecionar uma linha.");
			}
		}
	}

}
