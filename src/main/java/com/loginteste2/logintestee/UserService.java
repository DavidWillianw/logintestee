package com.loginteste2.logintestee;

public interface UserService {
    void adicionarUsuario(user usuario);

    user findUserByUsername(String username);
}
