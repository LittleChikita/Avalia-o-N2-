import { useState } from "react";
import api from "../services/api";
import { toast } from "react-toastify";

function CadastroUsuario() {

    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [cargo, setCargo] = useState("FUNCIONARIO");

    async function salvar() {
        try {
            await api.post("/usuarios", {
                nome,
                email,
                senha,
                cargo
            });

            toast.success("Usuário cadastrado!", {
                position: "top-right",
                autoClose: 3000,
            });

            setNome("");
            setEmail("");
            setSenha("");
            setCargo("FUNCIONARIO");

        } catch (error) {
            toast.error("Erro ao cadastrar usuário", {
                position: "top-right",
                autoClose: 3000,
            });
        }
    }

    return (
        <div>

            <h1>Cadastro de Usuário</h1>

            <input
                id="nome"
                placeholder="Nome"
                value={nome}
                onChange={(e) => setNome(e.target.value)}
            />

            <input
                id="email"
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />

            <input
                id="senha"
                type="password"
                placeholder="Senha"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}
            />

            <select
                id="cargo"
                value={cargo}
                onChange={(e) => setCargo(e.target.value)}
            >
                <option value="FUNCIONARIO">FUNCIONARIO</option>
                <option value="ADMINISTRADOR">ADMIN</option>
            </select>

            <button id="botaoSalvar" onClick={salvar}>
                Cadastrar
            </button>

        </div>
    );
}

export default CadastroUsuario;