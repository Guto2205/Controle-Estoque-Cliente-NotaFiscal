package com.produtos.acoes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.ClientesDAO;
import com.entities.Clientes;
import com.telas.edicao.InserirCliente;

public class InserindoC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painelFundo;
	private JPanel painelBotoes;
	private JTable tabela;
	private JScrollPane barraRolagem;
	private JButton btInserir;
	private DefaultTableModel modelo = new DefaultTableModel();

	public InserindoC() {
		super("cliente");
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Augus\\OneDrive\\Documentos\\Projetos-Eclipse\\ProjetoGeovane\\imagens\\render caixa de ferramentas.png"));
		setTitle("Cadastrar");
		criaJTable();
		criaJanela();
	}

	public void criaJanela() {
		btInserir = new JButton("Inserir");
		painelBotoes = new JPanel();
		painelBotoes.setBackground(new Color(0, 0, 0));
		barraRolagem = new JScrollPane(tabela);
		painelFundo = new JPanel();
		painelFundo.setLayout(new BorderLayout());
		painelFundo.add(BorderLayout.CENTER, barraRolagem);
		painelBotoes.add(btInserir);
		painelFundo.add(BorderLayout.SOUTH, painelBotoes);

		getContentPane().add(painelFundo);
		this.dispose();
		setSize(740, 478);
		setVisible(true);
		btInserir.addActionListener(new BtInserirListener());
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
					c.getTelefone(), c.getRua(),  c.getNumero(), c.getBairro(), c.getComplemento() });
		}
	}

	private class BtInserirListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			InserirCliente ic = new InserirCliente(modelo);
			ic.setVisible(true);
		}
		
		
	}

}
