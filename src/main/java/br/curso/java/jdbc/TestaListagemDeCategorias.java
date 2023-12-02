package br.curso.java.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.curso.java.jdbc.dao.CategoriaDAO;
import br.curso.java.jdbc.dao.ProdutoDAO;
import br.curso.java.jdbc.modelo.Categoria;
import br.curso.java.jdbc.modelo.Produto;

public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		try(Connection connection = new ConnectionFactory().recuperarConexao()) {
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listar();
			
			
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				try {
					for (Produto produto: new ProdutoDAO(connection).buscar(ct)) {
						System.out.println(ct.getNome() + " - " + produto.getNome());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		}
		
	}

}