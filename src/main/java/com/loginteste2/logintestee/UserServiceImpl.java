package com.loginteste2.logintestee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private List<user> usuarios = new ArrayList<>();

    @Override
    public void adicionarUsuario(user usuario) {
        usuarios.add(usuario);
    }

    @Override
    public user findUserByUsername(String username) {
        return usuarios.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}
