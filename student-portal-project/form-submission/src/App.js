import React from "react";
import Header from "./components/Header";
import StudentForm from "./components/StudentForm";
import Footer from "./components/Footer";
import EmailVerification from "./components/EmailVerification";
import { Routes, Route } from "react-router-dom";

function App() {
  return (
    <div>
      <Header />
       
      <Routes>
        <Route path="/" element={<StudentForm />} />
        <Route path="/verify-email" element={<EmailVerification />} />
      </Routes>
      
       
      <Footer />
    </div>
  );
}

export default App;
