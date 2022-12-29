package com.telas.edicao;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.dao.ProdutoDAO;
import com.entities.Produtos;
import com.produtos.acoes.ListarP;

public class AtualizarProduto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbId;
	private JLabel lbProduto;
	private JLabel lbQuantidade;
	private JLabel lbPreco;
	private JLabel lbPrecoSaida;
	private JLabel lbValorSaida;
	private JLabel lbTotalEntrada;
	private JTextField txId;
	private JTextField txProduto;
	private JTextField txQuantidade;
	private JTextField txPreco;
	private JTextField txPrecoSaida;
	private JTextField txTotalSaida;
	private JTextField txTotalEntrada;
	Produtos produto;
	private int linhaSelecionada;

	public AtualizarProduto(DefaultTableModel md, int id, int linha) {
		super("Produto");
		setTitle("Atualizar Produto");
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Augus\\OneDrive\\Documentos\\Projetos-Eclipse\\ProjetoGeovane\\imagens\\render caixa de ferramentas.png"));
		criaJanela();
		modelo = md;
		ProdutoDAO dao = new ProdutoDAO();
		produto = dao.getProdutoById(id);
		txId.setText(Integer.toString(produto.getId()));
		txProduto.setText(produto.getProduto());
		txQuantidade.setText(Integer.toString(produto.getQuantidade()));
		txPreco.setText(Double.toString(produto.getPreco()));
		txPrecoSaida.setText(Double.toString(produto.getPrecoSaida()));
		txTotalSaida.setText(Double.toString(produto.getTotalSaida()));
		txTotalEntrada.setText(Double.toString(produto.getTotalEntrada()));
		linhaSelecionada = linha;
	}

	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(268, 219, 267, 29);
		btLimpar = new JButton("Limpar");
		btLimpar.setBounds(0, 219, 267, 29);
		lbId = new JLabel("         Id.:");
		lbId.setBounds(0, 0, 267, 29);
		lbProduto = new JLabel("         Produto.:");
		lbProduto.setBounds(0, 30, 267, 29);
		lbQuantidade = new JLabel("         Quantidade.:");
		lbQuantidade.setBounds(0, 60, 267, 29);
		lbPreco = new JLabel("         Preço.:");
		lbPreco.setBounds(0, 90, 267, 29);
		lbPrecoSaida = new JLabel("         Preço/Saída.:");
		lbPrecoSaida.setBounds(0, 120, 267, 29);
		lbValorSaida = new JLabel("         Total/SaídaR$.:");
		lbValorSaida.setBounds(0, 150, 267, 29);
		lbTotalEntrada = new JLabel("         Valor/Estoque.:");
		lbTotalEntrada.setBounds(0, 180, 267, 29);
		txProduto = new JTextField();
		txProduto.setBounds(268, 30, 267, 29);
		txQuantidade = new JTextField();
		txQuantidade.setBounds(268, 60, 267, 29);
		txPreco = new JTextField();
		txPreco.setBounds(268, 90, 267, 29);
		txPrecoSaida = new JTextField();
		txPrecoSaida.setBounds(268, 120, 267, 29);
		txTotalSaida = new JTextField();
		txTotalSaida.setBounds(268, 150, 267, 29);
		txTotalSaida.setEditable(false);
		txTotalEntrada = new JTextField();
		txTotalEntrada.setBounds(268, 180, 267, 29);
		txTotalEntrada.setEditable(false);
		txId = new JTextField();
		txId.setBounds(268, 0, 267, 29);
		txId.setEditable(false);

		painelFundo = new JPanel();
		painelFundo.setLayout(null);
		painelFundo.add(lbId);
		painelFundo.add(txId);
		painelFundo.add(lbProduto);
		painelFundo.add(txProduto);
		painelFundo.add(lbQuantidade);
		painelFundo.add(txQuantidade);
		painelFundo.add(lbPreco);
		painelFundo.add(txPreco);
		painelFundo.add(lbPrecoSaida);
		painelFundo.add(txPrecoSaida);
		painelFundo.add(lbValorSaida);
		painelFundo.add(txTotalSaida);
		painelFundo.add(lbTotalEntrada);
		painelFundo.add(txTotalEntrada);
		painelFundo.add(btLimpar);
		painelFundo.add(btSalvar);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(550, 285);
		setVisible(true);

		btSalvar.addActionListener(new AtualizarProduto.BtSalvarListener());
		btLimpar.addActionListener(new AtualizarProduto.BtLimparListener());
	}

	private class BtSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Produtos c = new Produtos();
			c.setId(Integer.parseInt(txId.getText()));
			c.setProduto(txProduto.getText());
			c.setQuantidade(Integer.parseInt(txQuantidade.getText()));
			c.setPreco(Double.parseDouble(txPreco.getText()));
			c.setPrecoSaida(Double.parseDouble(txPrecoSaida.getText()));
			
			ProdutoDAO dao = new ProdutoDAO();
			dao.atualizar(c);
			ListarP.pesquisar(modelo);
			setVisible(false);
			
			
		}
	}

	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txProduto.setText("");
			txQuantidade.setText("");
			txPreco.setText("");
			txPrecoSaida.setText("");
			txTotalSaida.setText("");
			txTotalEntrada.setText("");
		}
	}

}
