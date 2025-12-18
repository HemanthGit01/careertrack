import { useEffect, useState } from "react";
import DashboardLayout from "../layouts/DashboardLayout";
import { fetchJobApplications } from "../api/jobApplications";
import StatusBadge from "../components/StatusBadge";
import "./Dashboard.css";

const Dashboard = () => {
  const [jobs, setJobs] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const loadJobs = async () => {
      try {
        const data = await fetchJobApplications();
        setJobs(data);
      } catch (err) {
        console.error("Failed to load jobs", err);
      } finally {
        setLoading(false);
      }
    };

    loadJobs();
  }, []);

  return (
    <DashboardLayout>
      {/* IMPORTANT CONTAINER */}
      <div className="dashboard-container">
        {/* Dashboard Intro */}
        <div className="dashboard-card">
          <h2>Dashboard</h2>
          <p>Welcome to CareerTrack</p>
        </div>

        {/* Job Applications */}
        <div className="dashboard-card">
          <div className="jobs-header">
            <h3>Job Applications</h3>
            <button className="add-btn">+ Add Job</button>
          </div>

          {loading && <p className="state-text">Loading jobs...</p>}

          {!loading && jobs.length === 0 && (
            <p className="state-text">No job applications yet.</p>
          )}

          {!loading &&
            jobs.map((job) => (
              <div className="job-row" key={job.id}>
                <div>
                  <h4 className="job-title">{job.jobTitle}</h4>
                  <p className="company">{job.companyName}</p>
                </div>

                <div className="job-meta">
                  <StatusBadge status={job.status} />
                  <span className="date">{job.appliedDate}</span>
                </div>
              </div>
            ))}
        </div>
      </div>
    </DashboardLayout>
  );
};

export default Dashboard;
