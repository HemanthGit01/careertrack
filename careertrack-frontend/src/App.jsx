import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import { useContext } from "react";
import { AuthContext } from "./auth/AuthContext";
import { AuthProvider } from "./auth/AuthProvider";

import Login from "./pages/Login";
import Register from "./pages/Register";
import Dashboard from "./pages/Dashboard";
import ProtectedRoute from "./routes/ProtectedRoute";

const AppRoutes = () => {
  const { token } = useContext(AuthContext);

  return (
    <Routes>
      {/* Public routes */}
      <Route path="/login" element={token ? <Navigate to="/" /> : <Login />} />

      <Route
        path="/register"
        element={token ? <Navigate to="/" /> : <Register />}
      />

      {/* Protected route */}
      <Route
        path="/"
        element={
          <ProtectedRoute token={token}>
            <Dashboard />
          </ProtectedRoute>
        }
      />
    </Routes>
  );
};

const App = () => {
  return (
    <AuthProvider>
      <BrowserRouter>
        <AppRoutes />
      </BrowserRouter>
    </AuthProvider>
  );
};

export default App;
