import {useEffect, useState} from "react";
import api from "../services/api.js";
import CardPrato from "../components/CardPrato.jsx";

function Home() {

    const [pratos, setPratos] = useState([]);

    useEffect(() => {

        buscarPratos();

    }, []);

    async function buscarPratos() {

        try {

            const response =
                await api.get("/produtos");

            setPratos(response.data);

        } catch (error) {

            console.log(error);

        }
    }

    function adicionarCarrinho(prato) {

        const carrinho =
            JSON.parse(
                localStorage.getItem("carrinho")
            ) || [];

        carrinho.push(prato);

        localStorage.setItem(
            "carrinho",
            JSON.stringify(carrinho)
        );

        alert("Adicionado ao carrinho!");

    }

    return (

        <div>

            <h1>Restaurante</h1>

            <div
                style={{
                    display: "flex",
                    gap: "20px",
                    flexWrap: "wrap"
                }}
            >

                {
                    pratos.map((prato) => (

                        <CardPrato
                            key={prato.id}
                            nome={prato.nome}
                            descricao={prato.descricao}
                            preco={prato.preco}
                            foto={prato.foto}
                            onAdicionar={() =>
                                adicionarCarrinho(prato)
                            }
                        />

                    ))
                }

            </div>

        </div>
    );
}

export default Home;