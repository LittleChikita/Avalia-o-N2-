import { useState } from "react";
import api from "../services/api.js";
import { toast } from "react-toastify";
import { useNavigate } from "react-router-dom";

function Login() {

    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");

    const navigate = useNavigate();

    async function logar(e) {
        e.preventDefault();

        try {
            const response = await api.post("/auth/login", {
                email,
                senha
            });

            const data = response.data;

            localStorage.setItem("token", data.token);
            localStorage.setItem("role", data.role);

            toast.success("Login realizado!", {
                position: "top-right",
                autoClose: 2000
            });

            // 🔥 REDIRECIONAMENTO POR PERFIL
            setTimeout(() => {
                if (data.role === "ADMINISTRADOR") {
                    navigate("/admin");
                } else {
                    navigate("/home");
                }
            }, 800);

        } catch (error) {
            toast.error("Erro no login");
        }
    }

    return (
        <form onSubmit={logar}>

            <h1>Login</h1>

            <input
                id="email"
                type="text"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />

            <br /><br />

            <input
                id="senha"
                type="password"
                placeholder="Senha"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}
            />

            <br /><br />

            <button id="botaoLogin" type="submit">
                Login
            </button>

        </form>
    );
}

export default Login;