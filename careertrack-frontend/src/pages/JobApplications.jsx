import JobRow from "../components/JobRow";
import "./JobApplications.css";

const JobApplications = () => {
  const jobs = [
    {
      company: "Google",
      role: "Software Engineer",
      status: "Applied",
      date: "10 Jan 2025",
    },
    {
      company: "Amazon",
      role: "Java Backend Developer",
      status: "Interview",
      date: "15 Jan 2025",
    },
    {
      company: "Microsoft",
      role: "Full Stack Developer",
      status: "Rejected",
      date: "18 Jan 2025",
    },
  ];

  return (
    <div className="jobs-card">
      <div className="jobs-header">
        <h3>Job Applications</h3>
        <button className="add-btn">+ Add Job</button>
      </div>

      {jobs.map((job, index) => (
        <JobRow
          key={index}
          company={job.company}
          role={job.role}
          status={job.status}
          date={job.date}
        />
      ))}
    </div>
  );
};

export default JobApplications;
