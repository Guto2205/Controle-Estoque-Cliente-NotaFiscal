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

public class InserirProduto extends JFrame {

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
		private JLabel lbTotalSaida;
		private JLabel lbTotalEntrada;
		private JTextField txId;
		private JTextField txProduto;
		private JTextField txQuantidade;
		private JTextField txPreco;
		private JTextField txPrecoSaida;
		private JTextField txTotalSaida;
		private JTextField txTotalEntrada;
		Produtos produto;
		
		

		public InserirProduto(DefaultTableModel md) {
			super("produtos");
			setTitle("Cadastrar Produto");
			setBackground(new Color(0, 0, 0));
			setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Augus\\OneDrive\\Documentos\\Projetos-Eclipse\\ProjetoGeovane\\imagens\\render caixa de ferramentas.png"));
			criaJanela();
			modelo = md;
		}

		public void criaJanela() {
			btSalvar = new JButton("Salvar");
			btSalvar.setBounds(268, 219, 267, 30);
			btLimpar = new JButton("Limpar");
			btLimpar.setBounds(0, 219, 267, 30);
			lbId = new JLabel("         Id.:");
			lbId.setBounds(0, 2, 267, 30);
			lbProduto = new JLabel("         Produto.:");
			lbProduto.setBounds(0, 33, 267, 30);
			lbQuantidade = new JLabel("         Quantidade.:");
			lbQuantidade.setBounds(0, 64, 267, 30);
			lbPreco = new JLabel("         Preço.:");
			lbPreco.setBounds(0, 95, 267, 30);
			lbPrecoSaida = new JLabel("         Preço/Saída.:");
			lbPrecoSaida.setBounds(0, 126, 267, 30);
			lbTotalSaida = new JLabel("         Preço/Total.:");
			lbTotalSaida.setBounds(0, 157, 267, 30);
			lbTotalEntrada = new JLabel("         Total/Saida.:");
			lbTotalEntrada.setBounds(0, 188, 267, 30);
			txProduto = new JTextField();
			txProduto.setBounds(268, 33, 267, 30);
			txQuantidade = new JTextField();
			txQuantidade.setBounds(268, 64, 267, 30);
			txPreco = new JTextField();
			txPreco.setBounds(268, 95, 267, 30);
			txPrecoSaida = new JTextField();
			txPrecoSaida.setBounds(268, 126, 267, 30);
			txTotalSaida = new JTextField();
			txTotalSaida.setBounds(268, 157, 267, 30);
			txTotalSaida.setEditable(false);
			txTotalEntrada = new JTextField();
			txTotalEntrada.setBounds(268, 188, 267, 30);
			txTotalEntrada.setEditable(false);
			txId = new JTextField();
			txId.setBounds(268, 2, 267, 30);
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
			painelFundo.add(lbTotalSaida);
			painelFundo.add(txTotalSaida);
			painelFundo.add(lbTotalEntrada);
			painelFundo.add(txTotalEntrada);
			painelFundo.add(btLimpar);
			painelFundo.add(btSalvar);

			getContentPane().add(painelFundo);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setSize(550, 289);
			setVisible(true);

			btSalvar.addActionListener(new InserirProduto.BtSalvarListener());
			btLimpar.addActionListener(new InserirProduto.BtLimparListener());
		}

		private class BtSalvarListener implements ActionListener {

			public void actionPerformed(ActionEvent e) {
				Produtos c = new Produtos();
				c.setProduto(txProduto.getText());
				c.setQuantidade(Integer.parseInt(txQuantidade.getText()));
				c.setPreco(Double.parseDouble(txPreco.getText()));
				c.setPrecoSaida(Double.parseDouble(txPrecoSaida.getText()));

				ProdutoDAO dao = new ProdutoDAO();
				dao.inserir(c);
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
			}
		}

}
