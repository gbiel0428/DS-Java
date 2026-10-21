import controller.LoginController;
import controller.ProdutoController;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import javax.swing.SwingUtilities;
import view.Estilo;
import view.TelaLogin;

public class Main {
    public static void main(String[] args) {
        // Suaviza as fontes na tela
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        Estilo.aplicarTema();

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        LoginController loginController = new LoginController(usuarioDAO);
        ProdutoController produtoController = new ProdutoController(produtoDAO);

        SwingUtilities.invokeLater(() ->
                new TelaLogin(loginController, produtoController).setVisible(true));
    }
}
