import { useEffect, useState } from "react";
import api from "../services/api.js";

function Carrinho() {

    const [itens, setItens] = useState([]);
    const [mesa, setMesa] = useState("");

    useEffect(() => {

        const carrinho =

            JSON.parse(
                localStorage.getItem("carrinho")
            ) || [];

        setItens(carrinho);

    }, []);

    async function finalizarPedido() {

        try {

            const pedido = {

                mesa: Number(mesa),

                statusPedido: "ABERTO",

                itens: itens.map((item) => ({

                    produtoId: item.id,

                    quantidade: 1

                }))
            };

            console.log(pedido);

            await api.post(
                "/pedidos",
                pedido
            );

            alert("Pedido realizado!");

            localStorage.removeItem("carrinho");

            setItens([]);

            setMesa("");

        } catch (error) {

            console.log(error);

            alert("Erro ao finalizar pedido");
        }
    }

    return (

        <div>

            <h1>Carrinho</h1>

            {
                itens.map((item, index) => (

                    <div key={index}>

                        <h3>{item.nome}</h3>

                        <p>
                            R$ {item.preco}
                        </p>

                        <hr />

                    </div>

                ))
            }

            {
                itens.length > 0 && (

                    <div>

                        <input
                            type="number"
                            placeholder="Número da mesa"
                            value={mesa}
                            onChange={(e) =>
                                setMesa(e.target.value)
                            }
                        />

                        <button
                            onClick={finalizarPedido}
                        >
                            Finalizar Pedido
                        </button>

                    </div>

                )
            }

        </div>
    );
}

export default Carrinho;