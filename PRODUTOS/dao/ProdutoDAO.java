package dao;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO {
    private final List<Produto> produtos = new ArrayList<>();
    private int proximoId = 1;

    public void inserir(Produto produto) {
        produto.setId(proximoId++);
        produtos.add(produto);
    }

    public List<Produto> listar() {
        return new ArrayList<>(produtos);
    }

    public Produto buscarPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public boolean atualizar(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()) {
                produtos.set(i, produto);
                return true;
            }
        }
        return false;
    }

    public boolean remover(int id) {
        return produtos.removeIf(p -> p.getId() == id);
    }

    public List<Produto> pesquisar(String termo) {
        List<Produto> resultado = new ArrayList<>();
        String t = termo.toLowerCase();
        for (Produto p : produtos) {
            if (p.getNome().toLowerCase().contains(t)
                    || p.getCategoria().toLowerCase().contains(t)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
