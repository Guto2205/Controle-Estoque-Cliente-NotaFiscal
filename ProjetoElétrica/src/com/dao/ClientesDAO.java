package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.conexao.ConexaoBanco;
import com.entities.Clientes;

public class ClientesDAO {
	
	private final String INSERT = "insert into clientes (nome, telefone, rua, numero, bairro, complemento) values (?,?,?,?,?,?)";
	private final String UPDATE = "update clientes set nome=?, telefone=?, rua=?, numero=?, bairro=?,complemento=? where id=?";
	private final String DELETE = "delete from clientes where id =?";
	private final String LIST = "select * from clientes";
	private final String LISTBYID = "select * from clientes where id=?";
	
	public void inserir(Clientes clientes) {
		if (clientes != null) {
			Connection conn = null;
			try {
				conn = ConexaoBanco.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(INSERT);
				
				pstm.setString(1, clientes.getNome());
				pstm.setString(2, clientes.getTelefone());
				pstm.setString(3, clientes.getRua());
				pstm.setString(4, clientes.getNumero());
				pstm.setString(5, clientes.getBairro());
				pstm.setString(6, clientes.getComplemento());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
				ConexaoBanco.fechaConexao(conn, pstm);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao inserir clientes no banco de" + "dados " + e.getMessage());
			}
		} else {
			System.out.println("O clientes enviado por parâmetro está vazio");
		}
	}

	public void atualizar(Clientes clientes) {
		if (clientes != null) {
			Connection conn = null;
			try {
				conn = ConexaoBanco.getConexao();
				PreparedStatement pstm;
				pstm = conn.prepareStatement(UPDATE);

				pstm.setString(1, clientes.getNome());
				pstm.setString(2, clientes.getTelefone());
				pstm.setString(3, clientes.getRua());
				pstm.setString(4, clientes.getNumero());
				pstm.setString(5, clientes.getBairro());
				pstm.setString(6, clientes.getComplemento());
				pstm.setInt(7, clientes.getId());
				pstm.execute();
				JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso! ");
				ConexaoBanco.fechaConexao(conn);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar clientes no banco de dados " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O clientes enviado por parâmetro está vazio");
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
			JOptionPane.showMessageDialog(null, "Erro ao excluir clientes do banco de" + "dados " + e.getMessage());
		}
	}

	public List<Clientes> getClientes() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ArrayList<Clientes> cliente = new ArrayList<Clientes>();
		try {
			conn = ConexaoBanco.getConexao();
			pstm = conn.prepareStatement(LIST);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Clientes clientes = new Clientes();

				clientes.setId(rs.getInt("id"));
				clientes.setNome(rs.getString("nome"));
				clientes.setTelefone(rs.getString("telefone"));
				clientes.setRua(rs.getString("rua"));
				clientes.setNumero(rs.getString("numero"));
				clientes.setBairro(rs.getString("bairro"));
				clientes.setComplemento(rs.getString("complemento"));

				cliente.add(clientes);
			}
			ConexaoBanco.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar clientes" + e.getMessage());
		}
		return cliente;
	}

	public Clientes getclientesById(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Clientes clientes = new Clientes();
		try {
			conn = ConexaoBanco.getConexao();
			pstm = conn.prepareStatement(LISTBYID);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				clientes.setId(rs.getInt("id"));
				clientes.setNome(rs.getString("nome"));
				clientes.setTelefone(rs.getString("telefone"));
				clientes.setRua(rs.getString("rua"));
				clientes.setNumero(rs.getString("numero"));
				clientes.setBairro(rs.getString("bairro"));
				clientes.setComplemento(rs.getString("complemento"));

			}
			ConexaoBanco.fechaConexao(conn, pstm, rs);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar clientes" + e.getMessage());
		}
		return clientes;
	}
}
