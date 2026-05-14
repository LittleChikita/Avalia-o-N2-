import {useEffect, useState} from "react";
import api from "../services/api.js";

function Admin() {

    const [nome, setNome] = useState("");
    const [descricao, setDescricao] = useState("");
    const [preco, setPreco] = useState("");
    const [foto, setFoto] = useState("");

    const [pratos, setPratos] = useState([]);

    async function buscarPratos() {

        try {

            const response =
                await api.get("/produtos");

            setPratos(response.data);

        } catch (error) {

            console.log(error);

        }
    }

    useEffect(() => {

        buscarPratos();

    }, []);

    async function cadastrar(e) {

        e.preventDefault();

        try {

            await api.post("/produtos", {

                nome,
                descricao,
                preco,
                foto

            });

            alert("Prato cadastrado!");

            setNome("");
            setDescricao("");
            setPreco("");
            setFoto("");

            buscarPratos();

        } catch (error) {

            console.log(error);

            alert("Erro ao cadastrar");

        }
    }

    async function deletar(id) {

        try {

            await api.delete(`/produtos/${id}`);

            buscarPratos();

        } catch (error) {

            console.log(error);

            alert("Erro ao deletar");

        }
    }

    return (

        <div>

            <h1>Admin</h1>

            <form onSubmit={cadastrar}>

                <input
                    type="text"
                    placeholder="Nome"
                    value={nome}
                    onChange={(e) =>
                        setNome(e.target.value)
                    }
                />

                <br /><br />

                <input
                    type="text"
                    placeholder="Descrição"
                    value={descricao}
                    onChange={(e) =>
                        setDescricao(e.target.value)
                    }
                />

                <br /><br />

                <input
                    type="number"
                    placeholder="Preço"
                    value={preco}
                    onChange={(e) =>
                        setPreco(e.target.value)
                    }
                />

                <br /><br />

                <input
                    type="text"
                    placeholder="URL da foto"
                    value={foto}
                    onChange={(e) =>
                        setFoto(e.target.value)
                    }
                />

                <br /><br />

                <button>
                    Cadastrar
                </button>

            </form>

            <hr />

            <h2>Pratos cadastrados</h2>

            {
                pratos.map((prato) => (

                    <div key={prato.id}>

                        <h3>{prato.nome}</h3>

                        <button
                            onClick={() =>
                                deletar(prato.id)
                            }
                        >
                            Deletar
                        </button>

                        <hr />

                    </div>

                ))
            }

        </div>
    );
}

export default Admin;