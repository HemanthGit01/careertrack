import "./PrimaryButton.css";

const PrimaryButton = ({ children, onClick, type = "button" }) => (
  <button type={type} onClick={onClick} className="primary-btn">
    {children}
  </button>
);

export default PrimaryButton;
