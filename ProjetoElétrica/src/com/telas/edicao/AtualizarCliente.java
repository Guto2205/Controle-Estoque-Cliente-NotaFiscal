package com.telas.edicao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.dao.ClientesDAO;
import com.entities.Clientes;

public class AtualizarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTableModel modelo = new DefaultTableModel();
	private JPanel painelFundo;
	private JButton btSalvar;
	private JButton btLimpar;
	private JLabel lbId;
	private JLabel lbNome;
	private JLabel lbTelefone;
	private JLabel lbRua;
	private JLabel lbNumero;
	private JLabel lbBairro;
	private JLabel lbComplemento;
	private JTextField txId;
	private JTextField txComplemento;
	private JTextField txNome;
	private JTextField txTelefone;
	private JTextField txRua;
	private JTextField txNumero;
	private JTextField txBairro;
	Clientes cliente;
	private int linhaSelecionada;

	public AtualizarCliente(DefaultTableModel md, int id, int linha) {
		super("Cliente");
		setTitle("Atualizar Cliente");
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Augus\\OneDrive\\Documentos\\Projetos-Eclipse\\ProjetoGeovane\\imagens\\render caixa de ferramentas.png"));
		criaJanela();
		modelo = md;
		ClientesDAO dao = new ClientesDAO();
		cliente = dao.getclientesById(id);
		txId.setText(Integer.toString(cliente.getId()));
		txNome.setText(cliente.getNome());
		txTelefone.setText(cliente.getTelefone());
		txRua.setText(cliente.getRua());
		txNumero.setText(cliente.getNumero());
		txBairro.setText(cliente.getBairro());
		txComplemento.setText(cliente.getComplemento());
		linhaSelecionada = linha;
	}

	public void criaJanela() {
		btSalvar = new JButton("Salvar");
		btSalvar.setBounds(268, 219, 267, 29);
		btLimpar = new JButton("Limpar");
		btLimpar.setBounds(0, 219, 267, 29);
		lbId = new JLabel("         Id.:");
		lbId.setBounds(0, 0, 267, 29);
		lbComplemento = new JLabel("         Nome.:");
		lbComplemento.setBounds(0, 30, 267, 29);
		lbNome = new JLabel("         Telefone.:");
		lbNome.setBounds(0, 60, 267, 29);
		lbTelefone = new JLabel("         Rua.:");
		lbTelefone.setBounds(0, 90, 267, 29);
		lbRua = new JLabel("         Numero.:");
		lbRua.setBounds(0, 120, 267, 29);
		lbNumero = new JLabel("         Bairro.:");
		lbNumero.setBounds(0, 150, 267, 29);
		lbBairro = new JLabel("         Complemento.:");
		lbBairro.setBounds(0, 180, 267, 29);
		txNome = new JTextField();
		txNome.setBounds(268, 30, 267, 29);
		txTelefone = new JTextField();
		txTelefone.setBounds(268, 60, 267, 29);
		txRua = new JTextField();
		txRua.setBounds(268, 90, 267, 29);
		txNumero = new JTextField();
		txNumero.setBounds(268, 120, 267, 29);
		txBairro = new JTextField();
		txBairro.setBounds(268, 150, 267, 29);
		txComplemento = new JTextField();
		txComplemento.setBounds(268, 180, 267, 29);
		
		txId = new JTextField();
		txId.setBounds(268, 2, 267, 30);
		txId.setEditable(false);


		painelFundo = new JPanel();
		painelFundo.setLayout(null);
		painelFundo.add(lbId);
		painelFundo.add(txId);
		painelFundo.add(lbNome);
		painelFundo.add(txNome);
		painelFundo.add(lbTelefone);
		painelFundo.add(txTelefone);
		painelFundo.add(lbRua);
		painelFundo.add(txRua);
		painelFundo.add(lbNumero);
		painelFundo.add(txNumero);
		painelFundo.add(lbBairro);
		painelFundo.add(txBairro);
		painelFundo.add(lbComplemento);
		painelFundo.add(txComplemento);
		painelFundo.add(btLimpar);
		painelFundo.add(btSalvar);

		getContentPane().add(painelFundo);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(550, 285);
		setVisible(true);

		btSalvar.addActionListener(new AtualizarCliente.BtSalvarListener());
		btLimpar.addActionListener(new AtualizarCliente.BtLimparListener());
	}

	private class BtSalvarListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			Clientes c = new Clientes();
			c.setId(Integer.parseInt(txId.getText()));
			c.setNome(txNome.getText());
			c.setTelefone(txTelefone.getText());
			c.setRua(txRua.getText());
			c.setBairro(txBairro.getText());
			c.setNumero(txNumero.getText());
			c.setComplemento(txComplemento.getText());

			ClientesDAO dao = new ClientesDAO();
			dao.atualizar(c);
			modelo.removeRow(linhaSelecionada);
			modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getTelefone(),
					c.getRua(), c.getBairro(), c.getNumero(), c.getComplemento()});
			setVisible(false);
		}
	}

	private class BtLimparListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			txNome.setText("");
			txTelefone.setText("");
			txRua.setText("");
			txNumero.setText("");
			txBairro.setText("");
			txComplemento.setText("");
		}
	}

}
