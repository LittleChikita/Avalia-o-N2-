import { Link, useNavigate } from "react-router-dom";

function Navbar() {
    const navigate = useNavigate();

    function logout() {
        localStorage.removeItem("token");
        localStorage.removeItem("role");

        navigate("/login");
    }

    const token = localStorage.getItem("token");
    const role = localStorage.getItem("role");

    return (
        <div style={{ display: "flex", gap: "20px", marginBottom: "20px" }}>

            <Link to="/">Home</Link>

            {!token && <Link to="/login">Login</Link>}

            {token && (
                <>
                    <Link to="/carrinho">Carrinho</Link>
                    <Link to="/pedidos">Pedidos</Link>
                </>
            )}

            {role === "ADMINISTRADOR" && (
                <>
                    <Link to="/admin">Admin</Link>
                    <Link to="/usuarios">Usuários</Link>
                </>
            )}

            {token && (
                <button onClick={logout}>
                    Logout
                </button>
            )}

        </div>
    );
}

export default Navbar;