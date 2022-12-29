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

import com.dao.ProdutoDAO;
import com.entities.Produtos;

public class ExcluirP extends JFrame {

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

	public ExcluirP() {
		super("produtos");
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Augus\\OneDrive\\Documentos\\Projetos-Eclipse\\ProjetoGeovane\\imagens\\render caixa de ferramentas.png"));
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
		modelo.addColumn("Produto");
		modelo.addColumn("Quantidade");
		modelo.addColumn("Preço/Produto");
		modelo.addColumn("Preço/Venda");
		modelo.addColumn("Total/Venda");
		modelo.addColumn("Total/Produto");
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
		ProdutoDAO dao = new ProdutoDAO();

		for (Produtos c : dao.getProdutos()) {
			modelo.addRow(new Object[] { c.getId(), c.getProduto(), c.getQuantidade(), c.getPreco(), c.getPrecoSaida(),
					c.getTotalSaida(), c.getTotalEntrada() });
		}
	}

	private class BtExcluirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			if (linhaSelecionada >= 0) {
				int idProduto = (int) tabela.getValueAt(linhaSelecionada, 0);
				ProdutoDAO dao = new ProdutoDAO();
				dao.remover(idProduto);
				modelo.removeRow(linhaSelecionada);
			} else {
				JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
			}
		}
	}

}
