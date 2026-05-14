import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import api from "../services/api";
import { toast } from "react-toastify";

function EditarUsuario() {

    const { id } = useParams();
    const navigate = useNavigate();

    const [nome, setNome] = useState("");
    const [email, setEmail] = useState("");
    const [senha, setSenha] = useState("");
    const [cargo, setCargo] = useState("FUNCIONARIO");

    // Buscar usuário ao abrir a tela
    useEffect(() => {

        async function carregarUsuario() {

            try {

                const response = await api.get(`/usuarios/${id}`);

                setNome(response.data.nome);
                setEmail(response.data.email);
                setCargo(response.data.cargo);

            } catch (error) {

                toast.error("Erro ao carregar usuário");

            }
        }

        carregarUsuario();

    }, [id]);

    async function atualizar() {

        try {

            await api.put(`/usuarios/${id}`, {
                nome,
                email,
                senha,
                cargo
            });

            toast.success("Usuário atualizado!", {
                position: "top-right",
                autoClose: 3000,
            });

            navigate("/admin");

        } catch (error) {

            toast.error("Erro ao atualizar usuário", {
                position: "top-right",
                autoClose: 3000,
            });
        }
    }

    return (

        <div>

            <h1>Editar Usuário</h1>

            <input
                placeholder="Nome"
                value={nome}
                onChange={(e) => setNome(e.target.value)}
            />

            <input
                placeholder="Email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
            />

            <input
                type="password"
                placeholder="Nova senha"
                value={senha}
                onChange={(e) => setSenha(e.target.value)}
            />

            <select
                value={cargo}
                onChange={(e) => setCargo(e.target.value)}
            >
                <option value="FUNCIONARIO">
                    FUNCIONARIO
                </option>

                <option value="ADMINISTRADOR">
                    ADMIN
                </option>
            </select>

            <button onClick={atualizar}>
                Atualizar
            </button>

        </div>
    );
}

export default EditarUsuario;