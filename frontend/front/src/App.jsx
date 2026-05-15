import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Admin from "./pages/Admin";
import Navbar from "./components/Navbar.jsx";
import Carrinho from "./pages/Carrinho.jsx";
import Pedidos from "./pages/Pedidos.jsx";
import CadastroUsuario from "./pages/CadastroUsuario.jsx";
import EditarUsuario from "./pages/EditarUsuario.jsx";
import Usuarios from "./pages/Usuarios.jsx";
import { ToastContainer } from "react-toastify";

import ProtectedRoute from "./routes/ProtectedRoute";

function App() {

    const token = localStorage.getItem("token");

    return (
        <BrowserRouter>

            <Navbar />
            <ToastContainer />

            <Routes>

                <Route
                    path="/"
                    element={
                        token
                            ? <Navigate to="/home" replace />
                            : <Navigate to="/login" replace />
                    }
                />

                <Route path="/login" element={<Login />} />

                <Route path="/home" element={
                    <ProtectedRoute>
                        <Home />
                    </ProtectedRoute>
                } />

                <Route path="/carrinho" element={
                    <ProtectedRoute>
                        <Carrinho />
                    </ProtectedRoute>
                } />

                <Route path="/pedidos" element={
                    <ProtectedRoute>
                        <Pedidos />
                    </ProtectedRoute>
                } />

                <Route path="/admin" element={
                    <ProtectedRoute>
                        <Admin />
                    </ProtectedRoute>
                } />

                <Route path="/usuarios" element={
                    <ProtectedRoute>
                        <Usuarios />
                    </ProtectedRoute>
                } />

                <Route path="/usuarios/cadastro" element={
                    <ProtectedRoute>
                        <CadastroUsuario />
                    </ProtectedRoute>
                } />

                <Route path="/usuarios/editar/:id" element={
                    <ProtectedRoute>
                        <EditarUsuario />
                    </ProtectedRoute>
                } />

            </Routes>

        </BrowserRouter>
    );
}

export default App;