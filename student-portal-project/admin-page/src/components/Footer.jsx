// Footer.jsx
import { useEffect, useState } from "react";
import axios from "axios";
import { 
  FaFacebook, 
  FaInstagram, 
  FaTwitter, 
  FaYoutube, 
  FaLink, 
  FaWhatsapp, 
  FaLinkedin 
} from "react-icons/fa";
import "./Footer.css";

export default function Footer() {
  const [views, setViews] = useState([]);
  const [totalViews, setTotalViews] = useState(0);

  useEffect(() => {
    const fetchViews = async () => {
      try {
        const res = await axios.get("http://localhost:8081/api/admin/students/views");
        setViews(res.data);

        const total = res.data.reduce((sum, v) => sum + (v.count || 0), 0);
        setTotalViews(total);
      } catch (err) {
        console.error("❌ Error fetching views:", err);
      }
    };
    fetchViews();
  }, []);

  const getCount = (source) => views.find((v) => v.source === source)?.count || 0;

  return (
    <footer className="footer-contener">
      {/* ✅ View Stats */}
      <div className="footer-views">
        <h3>📊 Visitor Statistics</h3>
        <p>👀 Total Views: {totalViews}</p>
        <ul>
          <li className="facebook"><FaFacebook color="#1877F2" /> Facebook: {getCount("facebook")}</li>
          <li className="instagram"><FaInstagram color="#E1306C" /> Instagram: {getCount("instagram")}</li>
          <li className="twitter"><FaTwitter color="#1DA1F2" /> Twitter: {getCount("twitter")}</li>
          <li className="youtube"><FaYoutube color="#FF0000" /> YouTube: {getCount("youtube")}</li>
          <li className="whatsapp"><FaWhatsapp color="#25D366" /> WhatsApp: {getCount("whatsapp")}</li>
          <li className="linkedin"><FaLinkedin color="#0077B5" /> LinkedIn: {getCount("linkedin")}</li>
          <li className="direct"><FaLink color="#00A300" /> Direct: {getCount("direct")}</li>
        </ul>
      </div>

      {/* ✅ Bottom copyright */}
      <div className="footer-bottom">
        <p>&copy; 2025 MCET. All rights reserved.</p>
      </div>
    </footer>
  );
}
