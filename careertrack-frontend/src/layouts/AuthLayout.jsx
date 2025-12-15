import "./AuthLayout.css";

const AuthLayout = ({ children }) => (
  <div className="auth-wrapper">
    <div className="auth-card">{children}</div>
  </div>
);

export default AuthLayout;
