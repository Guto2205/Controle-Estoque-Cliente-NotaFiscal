package com.principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import com.produtos.acoes.AtualizarC;
import com.produtos.acoes.AtualizarP;
import com.produtos.acoes.ExcluirC;
import com.produtos.acoes.ExcluirP;
import com.produtos.acoes.InserindoC;
import com.produtos.acoes.InserindoP;
import com.produtos.acoes.ListarC;
import com.produtos.acoes.ListarP;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

	public TelaPrincipal() {
		super("");
		setBackground(new Color(255, 255, 255));
		setTitle("GR Eletricista");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Augus\\OneDrive\\Documentos\\Projetos-Eclipse\\ProjetoGeovane\\imagens\\render caixa de ferramentas.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 466);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));

		getContentPane().add(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 683, 31);
		contentPane.add(menuBar);

		JMenu mnNewMenu_3 = new JMenu("Estoque");
		mnNewMenu_3.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu_3);

		JMenu mnNewMenu_4 = new JMenu("Produto");
		mnNewMenu_3.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Adicionar");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserindoP inserirProduto = new InserindoP();
				inserirProduto.setVisible(true);
			}
		});
		mntmNewMenuItem_7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_4.add(mntmNewMenuItem_7);

		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Atualizar");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarP atualizarP = new AtualizarP();
				atualizarP.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_8);

		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Excluir");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirP excluir = new ExcluirP();
				excluir.setVisible(true);
			}
		});
		mnNewMenu_4.add(mntmNewMenuItem_9);

		JMenu mnNewMenu_1 = new JMenu("Atendimento");
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("Cliente");
		mnNewMenu_1.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem = new JMenuItem("Adicionar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InserindoC inserindoCliente = new InserindoC();
				inserindoCliente.setVisible(true);
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_2.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Atualizar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtualizarC atualizarCliente = new AtualizarC();
				atualizarCliente.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Excluir");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcluirC exluirCliente = new ExcluirC();
				exluirCliente.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_5 = new JMenu("Listar");
		mnNewMenu_5.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu_5);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Produtos");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarP listarProdutos = new ListarP();
				listarProdutos.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Clientes");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarC listarCliente = new ListarC();
				listarCliente.setVisible(true);
			}
		});
		mnNewMenu_5.add(mntmNewMenuItem_4);
				
				JMenu mnNewMenu_5_1 = new JMenu("Gerar Nota");
				mnNewMenu_5_1.setForeground(Color.BLACK);
				menuBar.add(mnNewMenu_5_1);
				
				JMenuItem mntmNewMenuItem_3_1 = new JMenuItem("Nota");
				mntmNewMenuItem_3_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				mnNewMenu_5_1.add(mntmNewMenuItem_3_1);
		
				JMenuItem mntmNewMenuItem_5 = new JMenuItem("");
				menuBar.add(mntmNewMenuItem_5);

		JMenu mnNewMenu = new JMenu("Ajuda");
		mnNewMenu.setMnemonic('a');
		mnNewMenu.setForeground(new Color(0, 0, 0));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Auxilio");
		mntmNewMenuItem_6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.SHIFT_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem_6);

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Augus\\OneDrive\\Documentos\\Projetos-Eclipse\\ProjetoGeovane\\imagens\\fundo-de-ferramentas-profissionais-do-eletricista-com-espaço-para-o-texto-112179909.jpg"));
		lblNewLabel.setBounds(-88, -122, 771, 576);
		contentPane.add(lblNewLabel);

	}
}
