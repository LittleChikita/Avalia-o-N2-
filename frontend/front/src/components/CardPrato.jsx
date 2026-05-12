function CardPrato(props) {

    return (

        <div>

            <img
                src={props.foto}
                alt={props.nome}
                width="200"
                />

            <h2>{props.nome}</h2>

            <p>{props.descricao}</p>

            <p>{props.preco}</p>

            <button>
                Adicionar
            </button>

        </div>
    );

}

export default CardPrato;