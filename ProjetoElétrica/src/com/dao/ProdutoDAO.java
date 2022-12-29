package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.conexao.ConexaoBanco;
import com.entities.Produtos;

public class ProdutoDAO {

	private final String INSERT = "insert into produtos (produto, quantidade, preco, preco_saida) values (?,?,?,?)";
	private final String UPDATE = "update produtos set produto=?, quantidade=?, preco=?, preco_saida=? where id=?";
	private final String DELETE = "delete from produtos where id =?";
	private final String LIST = "select * from produtos";
	private final String LISTBYID = "select * from produtos where id=?";
	private final String SUM = "select sum(preco) as total_estoque from produtos";

	public void inserir(Produtos produto) {
		if (produto != null) {
			Connection conn = null;

			try {
				conn = ConexaoBanco.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(INSERT);

				pstm.setString(1, produto.getProduto());
				pstm.setInt(2, produto.getQuantidade());
				pstm.setDouble(3, produto.getPreco());
				pstm.setDouble(4, produto.getPrecoSaida());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
				ConexaoBanco.fechaConexao(conn, pstm);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir produto no banco de" + "dados " + e.getMessage());
			}
		} else {
			System.out.println("O produto enviado por parâmetro está vazio");
		}
	}

	public void atualizar(Produtos produto) {
		if (produto != null) {
			Connection conn = null;
			try {
				conn = ConexaoBanco.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(UPDATE);

				pstm.setString(1, produto.getProduto());
				pstm.setInt(2, produto.getQuantidade());
				pstm.setDouble(3, produto.getPreco());
				pstm.setDouble(4, produto.getPrecoSaida());
				pstm.setInt(5, produto.getId());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Produto alterado com sucesso! ");
				ConexaoBanco.fechaConexao(conn);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar produto no banco de dados " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O produto enviado por parâmetro está vazio");
		}

	}

	public void remover(int id) {
		Connection conn = null;
		try {
			conn = ConexaoBanco.getConexao();
			PreparedStatement pstm;
			pstm = conn.prepareStatement(DELETE);

			pstm.setInt(1, id);

			pstm.execute();
			ConexaoBanco.fechaConexao(conn, pstm);

			JOptionPane.showMessageDialog(null, "Deletado com sucesso");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir Produto do banco de" + "dados " + e.getMessage());
		}
	}

	public List<Produtos> getProdutos() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		ArrayList<Produtos> produtos = new ArrayList<Produtos>();
		try {
			conn = ConexaoBanco.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Produtos produto = new Produtos();

				produto.setId(rs.getInt("id"));
				produto.setProduto(rs.getString("produto"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setPrecoSaida(rs.getDouble("preco_saida"));
				produto.setTotalSaida(rs.getDouble("total_saida"));
				produto.setTotalEntrada(rs.getDouble("total_entrada"));

				produtos.add(produto);
			}
			ConexaoBanco.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Produtos" + e.getMessage());
		}
		return produtos;
	}

	public Produtos getProdutoById(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Produtos produto = new Produtos();
		try {
			conn = ConexaoBanco.getConexao();
			pstm = conn.prepareStatement(LISTBYID);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				produto.setId(rs.getInt("id"));
				produto.setProduto(rs.getString("produto"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setPrecoSaida(rs.getDouble("preco_saida"));
				produto.setTotalSaida(rs.getDouble("total_saida"));
				produto.setTotalEntrada(rs.getDouble("total_entrada"));

			}
			ConexaoBanco.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar Produtos" + e.getMessage());
		}
		return produto;
	}

	/*
	 * public void relatorioasper(Produtos produto) { if (produto != null) {
	 * Connection conn = null; try { conn = ConexaoBanco.getConexao();
	 * PreparedStatement pstm; pstm = conn.prepareStatement(UPDATE);
	 * 
	 * pstm.setDouble(1, produto.getTotal_estoque()); pstm.setInt(2,
	 * produto.getId()); pstm.execute(); JOptionPane.showMessageDialog(null,
	 * "Produto alterado com sucesso! "); ConexaoBanco.fechaConexao(conn);
	 * 
	 * } catch (Exception e) { JOptionPane.showMessageDialog(null,
	 * "Erro ao atualizar produto no banco de dados " + e.getMessage()); } } else {
	 * JOptionPane.showMessageDialog(null,
	 * "O produto enviado por parâmetro está vazio"); }
	 * 
	 * }
	 */

}
