import {BrowserRouter, Routes, Route, Navigate} from "react-router-dom";
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
import AdminRoute from "./routes/AdminRoute";

function App() {

    return (
        <BrowserRouter>

            <Navbar />
            <ToastContainer />

            <Routes>

                <Route
                    path="/"
                    element={
                        localStorage.getItem("token")
                            ? <Navigate to="/home" replace />
                            : <Navigate to="/login" replace />
                    }
                />

                <Route path="/login" element={<Login />} />


                <Route path="/" element={
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
                    <AdminRoute>
                        <Admin />
                    </AdminRoute>
                } />

                <Route path="/usuarios" element={
                    <AdminRoute>
                        <Usuarios />
                    </AdminRoute>
                } />

                <Route path="/usuarios/cadastro" element={
                    <AdminRoute>
                        <CadastroUsuario />
                    </AdminRoute>
                } />

                <Route path="/usuarios/editar/:id" element={
                    <AdminRoute>
                        <EditarUsuario />
                    </AdminRoute>
                } />

            </Routes>

        </BrowserRouter>
    );
}

export default App;