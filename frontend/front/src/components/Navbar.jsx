import { Link, useNavigate } from "react-router-dom";

function Navbar() {
    const navigate = useNavigate();

    function logout() {
        localStorage.removeItem("token");
        localStorage.removeItem("role");

        navigate("/login");
    }

    const token = localStorage.getItem("token");

    return (
        <div style={{ display: "flex", gap: "20px" }}>

            {token && (
                <>
                    <Link to="/home">Home</Link>
                    <Link to="/carrinho">Carrinho</Link>
                    <Link to="/pedidos">Pedidos</Link>
                    <Link to="/admin">Admin</Link>
                    <Link to="/usuarios">Usuários</Link>

                    <button onClick={logout}>Logout</button>
                </>
            )}

            {!token && <Link to="/login">Login</Link>}

        </div>
    );
}

export default Navbar;