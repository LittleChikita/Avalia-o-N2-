import { useState } from "react";
import api from "../services/api.js";

function Login() {

    const [usuario, setUsuario] = useState("");
    const [senha, setSenha] = useState("");

    async function logar(e) {

        e.preventDefault();

        try {

            const response =
                await api.post("/auth/login", {

                    usuario,
                    senha

                });

            localStorage.setItem(
                "token",
                response.data
            );

            alert("Login realizado!");

        } catch (error) {

            alert("Erro no login");

        }
    }

    return (

        <form onSubmit={logar}>

            <h1>Login</h1>

            <input
                type="text"
                placeholder="Usuário"
                value={usuario}
                onChange={(e) =>
                    setUsuario(e.target.value)
                }
            />

            <br /><br />

            <input
                type="password"
                placeholder="Senha"
                value={senha}
                onChange={(e) =>
                    setSenha(e.target.value)
                }
            />

            <br /><br />

            <button>
                Entrar
            </button>

        </form>
    );
}

export default Login;