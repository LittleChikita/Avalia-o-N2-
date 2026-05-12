import { Link } from "react-router-dom";

function Navbar() {

    return (

        <nav>

            <Link to="/">Home</Link>

            <br />

            <Link to="/login">Login</Link>

            <br />

            <Link to="/admin">Admin</Link>

        </nav>
    );
}

export default Navbar;