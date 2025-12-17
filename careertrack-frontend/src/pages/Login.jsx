import { useState, useContext } from "react";
import { AuthContext } from "../auth/AuthContext";
import api from "../api/axios";
import AuthLayout from "../layouts/AuthLayout";
import InputField from "../components/InputField";
import PrimaryButton from "../components/PrimaryButton";
import { Link, useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();
  const { login } = useContext(AuthContext);

  const [form, setForm] = useState({ username: "", password: "" });
  const [error, setError] = useState("");

  const updateField = (field, value) => {
    setForm((prev) => ({ ...prev, [field]: value }));
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    setError("");

    if (!form.username || !form.password) {
      setError("Username and password are required");
      return;
    }

    try {
      const res = await api.post("/auth/login", form);
      login(res.data.token);
      navigate("/");
    } catch {
      setError("Invalid username or password");
    }
  };

  return (
    <AuthLayout>
      <h2 style={{ marginBottom: "12px" }}>Welcome Back 👋</h2>
      <p style={{ color: "var(--color-text-light)", marginBottom: "24px" }}>
        Login to your CareerTrack account
      </p>

      <form onSubmit={handleLogin}>
        <InputField
          label="Username"
          name="username"
          value={form.username}
          onChange={(e) => updateField("username", e.target.value)}
        />

        <InputField
          label="Password"
          name="password"
          type="password"
          value={form.password}
          onChange={(e) => updateField("password", e.target.value)}
        />

        {error && <p style={{ color: "red", marginBottom: "12px" }}>{error}</p>}

        <PrimaryButton type="submit">Login</PrimaryButton>
      </form>

      <p style={{ marginTop: "16px", fontSize: "14px" }}>
        New here? <Link to="/register">Create an account</Link>
      </p>
    </AuthLayout>
  );
};

export default Login;
