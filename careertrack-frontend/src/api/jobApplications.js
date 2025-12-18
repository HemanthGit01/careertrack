import api from "./axios";

export const fetchJobApplications = async () => {
  const res = await api.get("/job-applications");
  return res.data;
};
