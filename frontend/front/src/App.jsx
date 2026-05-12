
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { useState } from "react";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Admin from "./pages/Admin";
import Navbar from "./components/Navbar.jsx";

function App() {

    const [contador, setContador] = useState(0);

    function aumentar() {

        setContador(contador + 1);

    }

    function diminuir() {

        setContador(contador - 1);

    }


    return (
        <div>
            <div>

                <h1>{contador}</h1>

                <button onClick={aumentar}>
                    +
                </button>
                <button onClick={diminuir}>
                    -
                </button>
            </div>

        </div>

  );
}


//<BrowserRouter>
//
//           <div>
//           <Navbar />
//           </div>
//
//         <Routes>
//
//           <Route path="/" element={<Home />} />
//
//           <Route path="/login" element={<Login />} />
//
//           <Route path="/admin" element={<Admin />} />
//
//         </Routes>
//
//
//       </BrowserRouter>
export default App
