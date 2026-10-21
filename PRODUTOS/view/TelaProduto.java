package view;

import controller.ProdutoController;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Produto;

public class TelaProduto extends JFrame {
    private final ProdutoController controller;
    private final Runnable aoSair;

    private final JTextField txtId = Estilo.campo(4);
    private final JTextField txtNome = Estilo.campo(20);
    private final JTextField txtCategoria = Estilo.campo(12);
    private final JTextField txtPreco = Estilo.campo(8);
    private final JTextField txtQuantidade = Estilo.campo(6);
    private final JTextField txtPesquisa = Estilo.campo(18);

    private final JLabel lblTotal = new JLabel("0");
    private final JLabel lblEstoque = new JLabel("0");
    private final JLabel lblValor = new JLabel("R$ 0,00");

    private final DefaultTableModel modelo = new DefaultTableModel(
            new Object[]{"ID", "Nome", "Categoria", "Preço (R$)", "Estoque"}, 0) {
        @Override public boolean isCellEditable(int r, int c) { return false; }
    };
    private final JTable tabela = new JTable(modelo);
    private final List<Estilo.ItemMenu> itensMenu = new ArrayList<>();

    public TelaProduto(ProdutoController controller, String usuario, Runnable aoSair) {
        super("Sistema de Produtos");
        this.controller = controller;
        this.aoSair = aoSair;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Estilo.estilizarTabela(tabela);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) carregarLinhaSelecionada();
        });

        add(criarMenu(usuario), BorderLayout.WEST);
        add(criarConteudo(), BorderLayout.CENTER);

        atualizarTabela(controller.listar());
        setSize(1100, 720);
        setMinimumSize(new Dimension(950, 620));
        setLocationRelativeTo(null);
    }

    // ================= MENU LATERAL =================

    private JPanel criarMenu(String usuario) {
        JPanel menu = new JPanel(new BorderLayout());
        menu.setBackground(Estilo.MENU);
        menu.setPreferredSize(new Dimension(230, 0));

        JLabel logo = new JLabel("Sistema de Produtos");
        logo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        logo.setForeground(Color.WHITE);
        logo.setBorder(BorderFactory.createEmptyBorder(28, 24, 28, 24));
        menu.add(logo, BorderLayout.NORTH);

        JPanel itens = new JPanel();
        itens.setLayout(new BoxLayout(itens, BoxLayout.Y_AXIS));
        itens.setOpaque(false);

        JLabel secao = new JLabel("MENU");
        secao.setFont(new Font("Segoe UI", Font.BOLD, 11));
        secao.setForeground(new Color(100, 116, 139));
        secao.setBorder(BorderFactory.createEmptyBorder(0, 24, 8, 24));
        secao.setAlignmentX(Component.LEFT_ALIGNMENT);
        itens.add(secao);

        Estilo.ItemMenu novo = adicionarItem(itens, "Novo produto", () -> {
            limparCampos();
            txtNome.requestFocusInWindow();
        });
        adicionarItem(itens, "Listagem", () -> {
            txtPesquisa.setText("");
            atualizarTabela(controller.listar());
        });
        adicionarItem(itens, "Pesquisar", () -> txtPesquisa.requestFocusInWindow());
        novo.setAtivo(true);
        menu.add(itens, BorderLayout.CENTER);

        JPanel rodape = new JPanel();
        rodape.setLayout(new BoxLayout(rodape, BoxLayout.Y_AXIS));
        rodape.setOpaque(false);
        rodape.setBorder(BorderFactory.createEmptyBorder(0, 0, 16, 0));

        JLabel user = new JLabel("Conectado como " + usuario);
        user.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        user.setForeground(new Color(148, 163, 184));
        user.setBorder(BorderFactory.createEmptyBorder(0, 24, 8, 24));
        user.setAlignmentX(Component.LEFT_ALIGNMENT);

        Estilo.ItemMenu sair = new Estilo.ItemMenu("Sair");
        sair.addActionListener(e -> fazerLogout());

        rodape.add(user);
        rodape.add(sair);
        menu.add(rodape, BorderLayout.SOUTH);
        return menu;
    }

    private Estilo.ItemMenu adicionarItem(JPanel destino, String texto, Runnable acao) {
        Estilo.ItemMenu item = new Estilo.ItemMenu(texto);
        item.addActionListener(e -> {
            for (Estilo.ItemMenu i : itensMenu) i.setAtivo(i == item);
            acao.run();
        });
        itensMenu.add(item);
        destino.add(item);
        return item;
    }

    private void fazerLogout() {
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja sair do sistema?",
                "Sair", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            dispose();
            aoSair.run();
        }
    }

    // ================= CONTEÚDO =================

    private JPanel criarConteudo() {
        JPanel conteudo = new JPanel(new BorderLayout(0, 16));
        conteudo.setBackground(Estilo.FUNDO);
        conteudo.setBorder(BorderFactory.createEmptyBorder(24, 28, 24, 28));

        JPanel topo = new JPanel();
        topo.setLayout(new BoxLayout(topo, BoxLayout.Y_AXIS));
        topo.setOpaque(false);

        JLabel titulo = new JLabel("Gerenciamento de Produtos");
        titulo.setFont(Estilo.TITULO);
        titulo.setForeground(Estilo.TEXTO);
        JLabel sub = new JLabel("Cadastre, altere e acompanhe o estoque da empresa.");
        sub.setFont(Estilo.FONTE);
        sub.setForeground(Estilo.TEXTO_SUAVE);

        JPanel resumo = criarResumo();
        JPanel formulario = criarFormulario();

        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        sub.setAlignmentX(Component.LEFT_ALIGNMENT);
        resumo.setAlignmentX(Component.LEFT_ALIGNMENT);
        formulario.setAlignmentX(Component.LEFT_ALIGNMENT);

        topo.add(titulo);
        topo.add(Box.createVerticalStrut(2));
        topo.add(sub);
        topo.add(Box.createVerticalStrut(18));
        topo.add(resumo);
        topo.add(Box.createVerticalStrut(16));
        topo.add(formulario);

        conteudo.add(topo, BorderLayout.NORTH);
        conteudo.add(criarCardTabela(), BorderLayout.CENTER);
        return conteudo;
    }

    private JPanel criarResumo() {
        JPanel p = new JPanel(new GridLayout(1, 3, 16, 0));
        p.setOpaque(false);
        p.add(cartaoResumo("Produtos cadastrados", lblTotal, Estilo.AZUL));
        p.add(cartaoResumo("Itens em estoque", lblEstoque, Estilo.VERDE));
        p.add(cartaoResumo("Valor total em estoque", lblValor, Estilo.LARANJA));
        return p;
    }

    private JPanel cartaoResumo(String titulo, JLabel valor, Color acento) {
        JPanel c = new JPanel(new BorderLayout(0, 4));
        c.setBackground(Color.WHITE);
        c.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Estilo.BORDA),
                        BorderFactory.createMatteBorder(0, 4, 0, 0, acento)),
                BorderFactory.createEmptyBorder(14, 16, 14, 16)));

        JLabel t = new JLabel(titulo);
        t.setFont(Estilo.FONTE);
        t.setForeground(Estilo.TEXTO_SUAVE);
        valor.setFont(new Font("Segoe UI", Font.BOLD, 24));
        valor.setForeground(Estilo.TEXTO);

        c.add(t, BorderLayout.NORTH);
        c.add(valor, BorderLayout.CENTER);
        return c;
    }

    private JPanel criarFormulario() {
        JPanel card = Estilo.card(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.insets = new Insets(4, 6, 4, 6);
        g.fill = GridBagConstraints.HORIZONTAL;
        g.anchor = GridBagConstraints.WEST;

        txtId.setEditable(false);
        txtId.setBackground(Estilo.FUNDO);

        String[] rotulos = {"ID", "NOME", "CATEGORIA", "PREÇO (R$)", "QUANTIDADE"};
        JTextField[] campos = {txtId, txtNome, txtCategoria, txtPreco, txtQuantidade};
        double[] pesos = {0.3, 2.0, 1.2, 0.8, 0.8};

        for (int i = 0; i < rotulos.length; i++) {
            g.gridx = i;
            g.weightx = pesos[i];
            g.gridy = 0;
            card.add(Estilo.rotulo(rotulos[i]), g);
            g.gridy = 1;
            card.add(campos[i], g);
        }

        Estilo.Botao btnCadastrar = new Estilo.Botao("Cadastrar", Estilo.AZUL);
        Estilo.Botao btnAlterar = new Estilo.Botao("Alterar", Estilo.LARANJA);
        Estilo.Botao btnRemover = new Estilo.Botao("Remover", Estilo.VERMELHO);
        Estilo.Botao btnLimpar = new Estilo.Botao("Limpar", Estilo.CINZA);

        JPanel botoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        botoes.setOpaque(false);
        botoes.add(btnLimpar);
        botoes.add(btnRemover);
        botoes.add(btnAlterar);
        botoes.add(btnCadastrar);

        g.gridx = 0;
        g.gridy = 2;
        g.gridwidth = rotulos.length;
        g.weightx = 1;
        g.insets = new Insets(14, 6, 0, 6);
        card.add(botoes, g);

        btnCadastrar.addActionListener(e -> cadastrar());
        btnAlterar.addActionListener(e -> alterar());
        btnRemover.addActionListener(e -> remover());
        btnLimpar.addActionListener(e -> limparCampos());
        return card;
    }

    private JPanel criarCardTabela() {
        JPanel card = Estilo.card(new BorderLayout(0, 12));

        JLabel titulo = new JLabel("Produtos cadastrados");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titulo.setForeground(Estilo.TEXTO);

        Estilo.Botao btnPesquisar = new Estilo.Botao("Pesquisar", Estilo.AZUL);
        Estilo.Botao btnTodos = new Estilo.Botao("Ver todos", Estilo.CINZA);

        JPanel busca = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 0));
        busca.setOpaque(false);
        busca.add(txtPesquisa);
        busca.add(btnPesquisar);
        busca.add(btnTodos);

        JPanel barra = new JPanel(new BorderLayout());
        barra.setOpaque(false);
        barra.add(titulo, BorderLayout.WEST);
        barra.add(busca, BorderLayout.EAST);

        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBorder(BorderFactory.createLineBorder(Estilo.BORDA));
        scroll.getViewport().setBackground(Color.WHITE);

        card.add(barra, BorderLayout.NORTH);
        card.add(scroll, BorderLayout.CENTER);

        txtPesquisa.addActionListener(e -> atualizarTabela(controller.pesquisar(txtPesquisa.getText())));
        btnPesquisar.addActionListener(e -> atualizarTabela(controller.pesquisar(txtPesquisa.getText())));
        btnTodos.addActionListener(e -> {
            txtPesquisa.setText("");
            atualizarTabela(controller.listar());
        });
        return card;
    }

    // ================= AÇÕES =================

    private void cadastrar() {
        try {
            controller.cadastrar(txtNome.getText(), txtCategoria.getText(),
                    txtPreco.getText(), txtQuantidade.getText());
            mensagem("Produto cadastrado com sucesso!");
            limparCampos();
            atualizarTabela(controller.listar());
        } catch (IllegalArgumentException ex) {
            erro(ex.getMessage());
        }
    }

    private void alterar() {
        if (txtId.getText().isEmpty()) {
            erro("Selecione um produto na tabela para alterar.");
            return;
        }
        try {
            controller.alterar(Integer.parseInt(txtId.getText()), txtNome.getText(),
                    txtCategoria.getText(), txtPreco.getText(), txtQuantidade.getText());
            mensagem("Produto alterado com sucesso!");
            limparCampos();
            atualizarTabela(controller.listar());
        } catch (IllegalArgumentException ex) {
            erro(ex.getMessage());
        }
    }

    private void remover() {
        if (txtId.getText().isEmpty()) {
            erro("Selecione um produto na tabela para remover.");
            return;
        }
        int opcao = JOptionPane.showConfirmDialog(this, "Deseja realmente remover este produto?",
                "Confirmação", JOptionPane.YES_NO_OPTION);
        if (opcao != JOptionPane.YES_OPTION) return;
        try {
            controller.remover(Integer.parseInt(txtId.getText()));
            mensagem("Produto removido com sucesso!");
            limparCampos();
            atualizarTabela(controller.listar());
        } catch (IllegalArgumentException ex) {
            erro(ex.getMessage());
        }
    }

    private void atualizarTabela(List<Produto> lista) {
        modelo.setRowCount(0);
        for (Produto p : lista) {
            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getCategoria(),
                    String.format("%.2f", p.getPreco()), p.getQuantidade()});
        }
        atualizarResumo();
    }

    private void atualizarResumo() {
        lblTotal.setText(String.valueOf(controller.totalProdutos()));
        lblEstoque.setText(String.valueOf(controller.totalItensEstoque()));
        lblValor.setText(NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pt-BR"))
                .format(controller.valorTotalEstoque()));
    }

    private void carregarLinhaSelecionada() {
        int linha = tabela.getSelectedRow();
        if (linha < 0) return;
        txtId.setText(modelo.getValueAt(linha, 0).toString());
        txtNome.setText(modelo.getValueAt(linha, 1).toString());
        txtCategoria.setText(modelo.getValueAt(linha, 2).toString());
        txtPreco.setText(modelo.getValueAt(linha, 3).toString());
        txtQuantidade.setText(modelo.getValueAt(linha, 4).toString());
    }

    private void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtCategoria.setText("");
        txtPreco.setText("");
        txtQuantidade.setText("");
        tabela.clearSelection();
    }

    private void mensagem(String m) { JOptionPane.showMessageDialog(this, m); }
    private void erro(String m) { JOptionPane.showMessageDialog(this, m, "Erro", JOptionPane.ERROR_MESSAGE); }
}
