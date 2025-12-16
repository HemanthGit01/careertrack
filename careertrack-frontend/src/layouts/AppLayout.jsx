import "./AppLayout.css";
import { useContext } from "react";
import { AuthContext } from "../auth/AuthContext";

const AppLayout = ({ children }) => {
  const { logout } = useContext(AuthContext);

  return (
    <div className="app-container">
      <header className="app-header">
        <h2>CareerTrack</h2>
        <button onClick={logout} className="logout-btn">
          Logout
        </button>
      </header>

      <main className="app-content">
        {children}
      </main>
    </div>
  );
};

export default AppLayout;
