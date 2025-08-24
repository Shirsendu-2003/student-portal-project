import { useState, useEffect } from 'react';
import LandingPage from './components/LandingPage';
import AdminLogin from './components/AdminLogin';
import AdminRegister from './components/AdminRegister';
import AdminDashboard from './components/AdminDashboard';
import AdminCellLogin from './components/AdminCellLogin';
import AdminCellRegister from './components/AdminCellRegister';
import AdminCellDashboard from './components/AdminCellDashboard';
import Header from "./components/Header";
import Footer from "./components/Footer";

export default function App() {
  const [view, setView] = useState('landing');
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [role, setRole] = useState(null);

  useEffect(() => {
    const token = localStorage.getItem('token');
    const storedRole = localStorage.getItem('role');
    if (token && storedRole) {
      setIsLoggedIn(true);
      setRole(storedRole);
      setView(storedRole === 'admin' ? 'adminDashboard' : 'adminCellDashboard');
    }
  }, []);

  const handleLoginSuccess = (userRole) => {
    setIsLoggedIn(true);
    setRole(userRole);
    localStorage.setItem('role', userRole);
    setView(userRole === 'admin' ? 'adminDashboard' : 'adminCellDashboard');
  };

  const handleLogout = () => {
    localStorage.removeItem('token');
    localStorage.removeItem('role');
    setIsLoggedIn(false);
    setRole(null);
    setView('landing');
  };

  // 🔹 Choose main content based on view
  let content;
  if (isLoggedIn && view === 'adminDashboard') {
    content = <AdminDashboard role={role} onLogout={handleLogout} />;
  } else if (isLoggedIn && view === 'adminCellDashboard') {
    content = <AdminCellDashboard role={role} onLogout={handleLogout} />;
  } else if (view === 'adminLogin') {
    content = <AdminLogin onLoginSuccess={() => handleLoginSuccess('admin')} onBack={() => setView('landing')} />;
  } else if (view === 'adminRegister') {
    content = <AdminRegister onRegisterSuccess={() => setView('adminLogin')} onBack={() => setView('landing')} />;
  } else if (view === 'adminCellLogin') {
    content = <AdminCellLogin onLoginSuccess={() => handleLoginSuccess('admincell')} onBack={() => setView('landing')} />;
  } else if (view === 'adminCellRegister') {
    content = <AdminCellRegister onRegisterSuccess={() => setView('adminCellLogin')} onBack={() => setView('landing')} />;
  } else {
    content = (
      <LandingPage
        onAdminLogin={() => setView('adminLogin')}
        onAdminRegister={() => setView('adminRegister')}
        onAdminCellLogin={() => setView('adminCellLogin')}
        onAdminCellRegister={() => setView('adminCellRegister')}
      />
    );
  }

  return (
    <>
      <Header />
      {content}
      <Footer />
    </>
  );
}
