package controller;

import dao.UsuarioDAO;

public class LoginController {
    private final UsuarioDAO usuarioDAO;

    public LoginController(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public boolean autenticar(String login, String senha) {
        if (login == null || login.trim().isEmpty() || senha == null || senha.isEmpty()) {
            return false;
        }
        return usuarioDAO.buscarPorLoginESenha(login.trim(), senha) != null;
    }
}
