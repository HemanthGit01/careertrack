import "./JobRow.css";

const JobRow = ({ company, role, status, date }) => {
  return (
    <div className="job-row">
      <div className="job-main">
        <h4 className="job-role">{role}</h4>
        <p className="job-company">{company}</p>
      </div>

      <div className="job-meta">
        <span className={`status-badge ${status.toLowerCase()}`}>{status}</span>
        <span className="job-date">{date}</span>
      </div>
    </div>
  );
};

export default JobRow;
