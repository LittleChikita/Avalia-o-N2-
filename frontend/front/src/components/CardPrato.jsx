function CardPrato(props) {

    return (

        <div
            style={{
                border: "1px solid gray",
                padding: "10px",
                width: "250px"
            }}
        >

            <img
                src={props.foto}
                alt={props.nome}
                width="200"
            />

            <h2>{props.nome}</h2>

            <p>{props.descricao}</p>

            <h3>
                R$ {props.preco}
            </h3>

            <button
                onClick={props.onAdicionar}
            >
                Adicionar
            </button>

        </div>
    );
}

export default CardPrato;