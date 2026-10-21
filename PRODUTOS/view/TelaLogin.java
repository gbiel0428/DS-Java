package view;

import controller.LoginController;
import controller.ProdutoController;
import java.awt.*;
import javax.swing.*;

public class TelaLogin extends JFrame {
    private final JTextField txtUsuario = Estilo.campo(15);
    private final JPasswordField txtSenha = Estilo.senha(15);
    private final JLabel lblErro = new JLabel(" ");
    private final Estilo.Botao btnEntrar = new Estilo.Botao("Entrar", Estilo.AZUL);

    public TelaLogin(LoginController loginController, ProdutoController produtoController) {
        super("Login - Sistema de Produtos");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        add(criarPainelMarca());
        add(criarPainelFormulario());

        getRootPane().setDefaultButton(btnEntrar);
        btnEntrar.addActionListener(e -> entrar(loginController, produtoController));

        setSize(820, 500);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    private JPanel criarPainelMarca() {
        JPanel painel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setPaint(new GradientPaint(0, 0, Estilo.AZUL_ESCURO,
                        getWidth(), getHeight(), Estilo.AZUL_CLARO));
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        };

        JPanel texto = new JPanel();
        texto.setLayout(new BoxLayout(texto, BoxLayout.Y_AXIS));
        texto.setOpaque(false);

        JLabel titulo = new JLabel("Sistema de Produtos");
        titulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titulo.setForeground(Color.WHITE);

        JLabel descricao = new JLabel("<html><div style='width:260px'>Gerencie o cadastro e o estoque "
                + "da sua empresa de forma simples e organizada.</div></html>");
        descricao.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        descricao.setForeground(new Color(219, 234, 254));

        titulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        descricao.setAlignmentX(Component.LEFT_ALIGNMENT);
        texto.add(titulo);
        texto.add(Box.createVerticalStrut(12));
        texto.add(descricao);

        painel.add(texto);
        return painel;
    }

    private JPanel criarPainelFormulario() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBackground(Color.WHITE);
        painel.setBorder(BorderFactory.createEmptyBorder(60, 50, 40, 50));

        JLabel titulo = new JLabel("Bem-vindo");
        titulo.setFont(Estilo.TITULO);
        titulo.setForeground(Estilo.TEXTO);

        JLabel sub = new JLabel("Entre com suas credenciais para continuar");
        sub.setFont(Estilo.FONTE);
        sub.setForeground(Estilo.TEXTO_SUAVE);

        JLabel rotUsuario = Estilo.rotulo("USUÁRIO");
        JLabel rotSenha = Estilo.rotulo("SENHA");

        lblErro.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblErro.setForeground(Estilo.VERMELHO);

        txtUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtSenha.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnEntrar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 44));

        JComponent[] todos = {titulo, sub, rotUsuario, txtUsuario, rotSenha, txtSenha, lblErro, btnEntrar};
        for (JComponent c : todos) c.setAlignmentX(Component.LEFT_ALIGNMENT);

        painel.add(titulo);
        painel.add(Box.createVerticalStrut(4));
        painel.add(sub);
        painel.add(Box.createVerticalStrut(30));
        painel.add(rotUsuario);
        painel.add(Box.createVerticalStrut(6));
        painel.add(txtUsuario);
        painel.add(Box.createVerticalStrut(16));
        painel.add(rotSenha);
        painel.add(Box.createVerticalStrut(6));
        painel.add(txtSenha);
        painel.add(Box.createVerticalStrut(10));
        painel.add(lblErro);
        painel.add(Box.createVerticalStrut(10));
        painel.add(btnEntrar);
        return painel;
    }

    private void entrar(LoginController loginController, ProdutoController produtoController) {
        String usuario = txtUsuario.getText().trim();
        String senha = new String(txtSenha.getPassword());

        if (loginController.autenticar(usuario, senha)) {
            dispose();
            new TelaProduto(produtoController, usuario,
                    () -> new TelaLogin(loginController, produtoController).setVisible(true))
                    .setVisible(true);
        } else {
            lblErro.setText("Usuário ou senha incorretos.");
            txtSenha.setText("");
            txtSenha.requestFocusInWindow();
        }
    }
}
