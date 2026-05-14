import { Navigate } from "react-router-dom";

function RootRedirect() {
    const token = localStorage.getItem("token");

    return token
        ? <Navigate to="/home" replace />
        : <Navigate to="/login" replace />;
}

export default RootRedirect;