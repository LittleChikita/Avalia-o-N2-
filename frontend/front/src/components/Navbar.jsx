import { Link } from "react-router-dom";

function Navbar() {

    return (

        <div
            style={{
                display: "flex",
                gap: "20px",
                marginBottom: "20px"
            }}
        >

            <Link to="/">
                Home
            </Link>

            <Link to="/login">
                Login
            </Link>

            <Link to="/admin">
                Admin
            </Link>

            <Link to="/carrinho">
                Carrinho
            </Link>

        </div>
    );
}

export default Navbar;