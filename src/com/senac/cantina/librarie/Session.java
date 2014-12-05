package com.senac.cantina.librarie;

import com.senac.cantina.model.Cliente;
import com.senac.cantina.model.Usuario;

public class Session {
    public static Usuario USUARIO = null;

    public static boolean isCliente() {
        if (Session.USUARIO instanceof Cliente) {
            return true;
        }

        return false;
    }
}
