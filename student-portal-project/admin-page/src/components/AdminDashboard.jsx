import React, { useEffect, useState } from 'react';
import axiosInstance from '../services/api';
import {
  FileSpreadsheet,
  FileText,
  Download,
  LogOut,
  GraduationCap,
} from 'lucide-react'; // 👈 icons
import './AdminDashboard.css';

export default function AdminDashboard({ onLogout }) {
  const [students, setStudents] = useState([]);
  const [adminName, setAdminName] = useState('');
  const [error, setError] = useState('');

  useEffect(() => {
    const fetchAdminInfo = async () => {
      try {
        const token = localStorage.getItem('token');
        const res = await axiosInstance.get('/admin/me', {
          headers: { Authorization: `Bearer ${token}` },
        });
        setAdminName(res.data.name);
      } catch (err) {
        console.error(err);
        setAdminName('Admin');
      }
    };

    const fetchStudents = async () => {
      try {
        const token = localStorage.getItem('token');
        const res = await axiosInstance.get('/admin/students', {
          headers: { Authorization: `Bearer ${token}` },
        });
        setStudents(res.data);
      } catch (err) {
        console.error(err);
        setError('Failed to fetch student data');
      }
    };

    fetchAdminInfo();
    fetchStudents();
  }, []);

  // Export single student
  const handleStudentExport = async (id, type) => {
    try {
      const token = localStorage.getItem('token');
      const res = await axiosInstance.get(`/admin/students/${id}/export/${type}`, {
        headers: { Authorization: `Bearer ${token}` },
        responseType: 'blob',
      });

      const blob = new Blob([res.data], {
        type:
          type === 'excel'
            ? 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
            : 'application/pdf',
      });

      const url = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = url;
      link.setAttribute(
        'download',
        `student_${id}.${type === 'excel' ? 'xlsx' : 'pdf'}`
      );
      document.body.appendChild(link);
      link.click();
      link.remove();
    } catch (err) {
      console.error(`Failed to export ${type} for student ${id}`, err);
      alert(`Failed to export ${type.toUpperCase()} for student ${id}`);
    }
  };

  // Export all students
  const handleAllExport = async (type) => {
    try {
      const token = localStorage.getItem('token');
      const res = await axiosInstance.get(`/admin/students/export/${type}`, {
        headers: { Authorization: `Bearer ${token}` },
        responseType: 'blob',
      });

      const blob = new Blob([res.data], {
        type:
          type === 'excel'
            ? 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
            : 'application/pdf',
      });

      const url = window.URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = url;
      link.setAttribute(
        'download',
        `students_all.${type === 'excel' ? 'xlsx' : 'pdf'}`
      );
      document.body.appendChild(link);
      link.click();
      link.remove();
    } catch (err) {
      console.error(`Failed to export all ${type}`, err);
      alert(`Failed to export all ${type.toUpperCase()}`);
    }
  };

  return (
    <div className="dashboard-container">
      {/* Header */}
      <div className="dashboard-header">
        <h2>
          <GraduationCap size={28} style={{ marginRight: '8px' }} />
          Welcome, {adminName}
        </h2>
        <button onClick={onLogout} className="logout-button">
          <LogOut size={18} style={{ marginRight: '5px' }} />
          Logout
        </button>
      </div>

      {/* Student Table */}
      <div>
        <table className="students-table">
          <thead>
            <tr>
              <th colSpan="7" className="form">
                Submitted Student Forms
              </th>
            </tr>
            {error && <p className="error-message">{error}</p>}
            <tr className="information">
              <th>ID</th>
              <th>StudentID</th>
              <th>Name</th>
              <th>Email</th>
              <th>Date & Time</th>
              <th>Phone No</th>
              <th>Remark</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {students.map((s, idx) => (
              <tr key={idx}>
                <td>{s.id}</td>
                <td>{s.studentsId}</td>
                <td>{s.name}</td>
                <td>{s.email}</td>
                <td>{s.updatedAt}</td>
                <td>{s.phone}</td>
                <td>{s.remark}</td>
                <td>
                  <button
                    onClick={() => handleStudentExport(s.id, 'excel')}
                    className="action-btn"
                  >
                    <FileSpreadsheet size={16} /> Excel
                  </button>
                  <button
                    onClick={() => handleStudentExport(s.id, 'pdf')}
                    className="action-btn"
                  >
                    <FileText size={16} /> PDF
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      {/* Export All */}
      <div className="all-btn">
        <h2 className="Export-dw">Export Download</h2>
        <button onClick={() => handleAllExport('excel')} className="button">
          <FileSpreadsheet size={18} /> Export All to Excel
        </button>
        <button onClick={() => handleAllExport('pdf')} className="button">
          <Download size={18} /> Export All to PDF
        </button>
      </div>
    </div>
  );
}
