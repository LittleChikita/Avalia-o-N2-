import { useEffect, useState } from "react";
import api from "../services/api.js";

function Pedidos() {

    const [pedidos, setPedidos] = useState([]);
    const [editando, setEditando] = useState(null);

    const [mesa, setMesa] = useState("");
    const [status, setStatus] = useState("");

    useEffect(() => {
        carregarPedidos();
    }, []);

    async function carregarPedidos() {
        const res = await api.get("/pedidos");
        setPedidos(res.data);
    }

    async function abrirEdicao(pedido) {

        setEditando(pedido.id);
        setMesa(pedido.mesa);
        setStatus(pedido.statusPedido);
    }

    async function salvar() {

        await api.put(`/pedidos/${editando}`, {
            mesa: Number(mesa),
            statusPedido: status
        });

        setEditando(null);
        setMesa("");
        setStatus("");

        carregarPedidos();
    }

    // 🔥 NOVA FUNÇÃO: CANCELAR PEDIDO
    async function cancelarPedido(pedido) {

        await api.put(`/pedidos/${pedido.id}`, {
            mesa: pedido.mesa,
            statusPedido: "CANCELADO"
        });

        carregarPedidos();
    }

    return (

        <div>

            <h1>Pedidos</h1>

            {/* LISTA */}
            {pedidos.map(pedido => (

                <div key={pedido.id}>

                    <h3>Pedido #{pedido.id}</h3>
                    <p>Mesa: {pedido.mesa}</p>
                    <p>Status: {pedido.statusPedido}</p>

                    <>
                        <button onClick={() => abrirEdicao(pedido)}>
                            Editar
                        </button>

                        <button onClick={() => cancelarPedido(pedido)}>
                            Cancelar
                        </button>
                    </>

                    <hr />

                </div>

            ))}

            {editando && (

                <div>

                    <h2>Editando Pedido #{editando}</h2>

                    <input
                        value={mesa}
                        onChange={(e) => setMesa(e.target.value)}
                        placeholder="Mesa"
                    />

                    <select
                        value={status}
                        onChange={(e) => setStatus(e.target.value)}
                    >
                        <option value="ABERTO">ABERTO</option>
                        <option value="PENDENTE">PENDENTE</option>
                        <option value="CANCELADO">CANCELADO</option>
                        <option value="FECHADO">FECHADO</option>
                        <option value="PAGO">PAGO</option>
                    </select>

                    <br /><br />

                    <button onClick={salvar}>
                        Salvar
                    </button>

                    <button onClick={() => setEditando(null)}>
                        Cancelar
                    </button>

                </div>

            )}

        </div>
    );
}

export default Pedidos;