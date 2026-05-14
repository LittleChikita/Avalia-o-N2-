import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import api from "../services/api";

function Usuarios() {

    const [usuarios, setUsuarios] = useState([]);

    useEffect(() => {

        async function carregarUsuarios() {

            try {

                const response = await api.get("/usuarios");

                setUsuarios(response.data);

            } catch (error) {

                console.log(error);
            }
        }

        carregarUsuarios();

    }, []);

    return (

        <div>

            <h1>Usuários</h1>

            <Link to="/usuarios/cadastro">
                Novo Usuário
            </Link>

            <br />
            <br />

            {usuarios.map((usuario) => (

                <div
                    key={usuario.id}
                    style={{
                        border: "1px solid gray",
                        padding: "10px",
                        marginBottom: "10px"
                    }}
                >

                    <p>
                        <strong>Nome:</strong> {usuario.nome}
                    </p>

                    <p>
                        <strong>Email:</strong> {usuario.email}
                    </p>

                    <p>
                        <strong>Cargo:</strong> {usuario.cargo}
                    </p>

                    <Link to={`/usuarios/editar/${usuario.id}`}>
                        Editar
                    </Link>

                </div>

            ))}

        </div>
    );
}

export default Usuarios;