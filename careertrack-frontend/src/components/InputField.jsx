import "./InputField.css";

const InputField = ({ label, type = "text", value, onChange, placeholder }) => (
  <div className="input-container">
    <label className="input-label">{label}</label>
    <input 
      type={type}
      className="input-field"
      value={value}
      onChange={onChange}
      placeholder={placeholder}
    />
  </div>
);

export default InputField;
