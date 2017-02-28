package org.paulojr.springmvc.daos;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.paulojr.springmvc.models.Produto;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(value=Sco)
public class ProdutoDAO {

	private Map<Integer, Produto> manager = new LinkedHashMap<Integer, Produto>();
	private int idCount = 1;
	
	public void salvar(Produto produto) {
		produto.setId(idCount);
		manager.put(idCount, produto);
		idCount++;
	}

	public Collection<Produto> listar() {
		return manager.values();
	}

	public Produto find(Long produtoId) {
		return manager.get(produtoId);
	}
	
}


