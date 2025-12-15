import { useState, useContext } from "react";
import { AuthContext } from "../auth/AuthContext";
import api from "../api/axios";
import AuthLayout from "../layouts/AuthLayout";
import InputField from "../components/InputField";
import PrimaryButton from "../components/PrimaryButton";
import { Link, useNavigate } from "react-router-dom";

const Register = () => {
  const navigate = useNavigate();
  const { login } = useContext(AuthContext);

  const [form, setForm] = useState({ username: "", password: "" });
  const [error, setError] = useState("");

  const updateField = (field, value) => {
    setForm((prev) => ({ ...prev, [field]: value }));
  };

  const handleRegister = async (e) => {
    e.preventDefault();
    setError("");

    try {
      const res = await api.post("/auth/register", form);
      login(res.data.token);
      navigate("/");
    } catch {
      setError("Username already exists");
    }
  };

  return (
    <AuthLayout>
      <h2 style={{ marginBottom: "12px" }}>Create Account ✨</h2>
      <p style={{ color: "var(--color-text-light)", marginBottom: "24px" }}>
        Register to start using CareerTrack
      </p>

      <form onSubmit={handleRegister}>
        <InputField
          label="Username"
          value={form.username}
          onChange={(e) => updateField("username", e.target.value)}
        />

        <InputField
          label="Password"
          type="password"
          value={form.password}
          onChange={(e) => updateField("password", e.target.value)}
        />

        {error && <p style={{ color: "red", marginBottom: "12px" }}>{error}</p>}

        <PrimaryButton type="submit">Create Account</PrimaryButton>
      </form>

      <p style={{ marginTop: "16px", fontSize: "14px" }}>
        Already have an account? <Link to="/login">Sign in</Link>
      </p>
    </AuthLayout>
  );
};

export default Register;
