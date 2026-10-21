package dao;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDAO {
    private final List<Usuario> usuarios = new ArrayList<>();

    public UsuarioDAO() {
        // Usuários pré-cadastrados (não há tela de cadastro de usuário)
        usuarios.add(new Usuario("admin", "123"));
        usuarios.add(new Usuario("maria", "abc"));
    }

    public Usuario buscarPorLoginESenha(String login, String senha) {
        for (Usuario u : usuarios) {
            if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                return u;
            }
        }
        return null;
    }
}
