
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Admin from "./pages/Admin";
import Navbar from "./components/Navbar.jsx";
import Carrinho from "./pages/Carrinho.jsx";

function App() {

    return (

        <BrowserRouter>

            <Navbar />

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

            </Routes>

        </BrowserRouter>

  );
}


export default App
