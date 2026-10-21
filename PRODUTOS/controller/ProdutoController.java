package controller;

import dao.ProdutoDAO;
import java.util.List;
import model.Produto;

public class ProdutoController {
    private final ProdutoDAO produtoDAO;

    public ProdutoController(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    public void cadastrar(String nome, String categoria, String preco, String quantidade) {
        produtoDAO.inserir(montar(nome, categoria, preco, quantidade));
    }

    public void alterar(int id, String nome, String categoria, String preco, String quantidade) {
        Produto p = montar(nome, categoria, preco, quantidade);
        p.setId(id);
        if (!produtoDAO.atualizar(p)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
    }

    public void remover(int id) {
        if (!produtoDAO.remover(id)) {
            throw new IllegalArgumentException("Produto não encontrado.");
        }
    }

    public List<Produto> listar() {
        return produtoDAO.listar();
    }

    public List<Produto> pesquisar(String termo) {
        if (termo == null || termo.trim().isEmpty()) {
            return produtoDAO.listar();
        }
        return produtoDAO.pesquisar(termo.trim());
    }

    public int totalProdutos() {
        return produtoDAO.listar().size();
    }

    public int totalItensEstoque() {
        int soma = 0;
        for (Produto p : produtoDAO.listar()) soma += p.getQuantidade();
        return soma;
    }

    public double valorTotalEstoque() {
        double soma = 0;
        for (Produto p : produtoDAO.listar()) soma += p.getPreco() * p.getQuantidade();
        return soma;
    }

    // Valida os dados vindos da View e cria o objeto Produto
    private Produto montar(String nome, String categoria, String preco, String quantidade) {
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("Informe o nome do produto.");
        if (categoria == null || categoria.trim().isEmpty())
            throw new IllegalArgumentException("Informe a categoria.");

        double valor;
        try {
            valor = Double.parseDouble(preco.trim().replace(",", "."));
        } catch (Exception e) {
            throw new IllegalArgumentException("Preço inválido.");
        }
        if (valor < 0) throw new IllegalArgumentException("O preço não pode ser negativo.");

        int qtd;
        try {
            qtd = Integer.parseInt(quantidade.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("Quantidade inválida.");
        }
        if (qtd < 0) throw new IllegalArgumentException("A quantidade não pode ser negativa.");

        return new Produto(nome.trim(), categoria.trim(), valor, qtd);
    }
}
