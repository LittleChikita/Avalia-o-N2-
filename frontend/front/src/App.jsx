
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Admin from "./pages/Admin";
import Navbar from "./components/Navbar.jsx";
import Carrinho from "./pages/Carrinho.jsx";
import Pedidos from "./pages/Pedidos.jsx";
import CadastroUsuario from "./pages/CadastroUsuario.jsx";
import {ToastContainer} from "react-toastify";

function App() {

    return (

        <BrowserRouter>

            <Navbar />

            <ToastContainer />


            <Routes>

                <Route
                    path="/"
                    element={<Home />}
                />

                <Route
                    path="/login"
                    element={<Login />}
                />

                <Route
                    path="/admin"
                    element={<Admin />}
                />

                <Route
                    path="/carrinho"
                    element={<Carrinho />}
                />

                <Route
                    path="/pedidos"
                    element={<Pedidos />}
                />

                <Route
                    path="/usuarios"
                    element={<CadastroUsuario />} />

            </Routes>

        </BrowserRouter>

  );
}


export default App
