import { useContext } from "react";
import { AuthContext } from "../auth/AuthContext";
import "./DashboardLayout.css";

const DashboardLayout = ({ children }) => {
  const { logout } = useContext(AuthContext);

  return (
    <div className="dashboard-wrapper">
      {/* Header */}
      <header className="dashboard-header">
        <h1 className="app-title">CareerTrack</h1>
        <button className="logout-btn" onClick={logout}>
          Logout
        </button>
      </header>

      {/* Main */}
      <main className="dashboard-content">
        <div className="dashboard-inner">{children}</div>
      </main>
    </div>
  );
};

export default DashboardLayout;
