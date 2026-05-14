import { useEffect, useState } from "react";

function Carrinho() {

    const [itens, setItens] = useState([]);

    useEffect(() => {

        const carrinho =
            JSON.parse(
                localStorage.getItem("carrinho")
            ) || [];

        setItens(carrinho);

    }, []);

    function finalizarPedido() {

        alert("Pedido realizado!");

        localStorage.removeItem("carrinho");

        setItens([]);

    }

    return (

        <div>

            <h1>Carrinho</h1>

            {
                itens.map((item, index) => (

                    <div key={index}>

                        <h3>{item.nome}</h3>

                        <p>R$ {item.preco}</p>

                        <hr />

                    </div>

                ))
            }

            {
                itens.length > 0 && (

                    <button
                        onClick={finalizarPedido}
                    >
                        Finalizar Pedido
                    </button>

                )
            }

        </div>
    );
}

export default Carrinho;