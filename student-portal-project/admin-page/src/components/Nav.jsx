// Nav.jsx
export default function Nav({ onLogin, onRegister }) {
  return (
    <nav className="bg-gray-100 py-4 flex justify-center gap-4">
      <button
        className="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700"
        onClick={onLogin}
      >
        Login
      </button>
      <button
        className="bg-gray-600 text-white px-4 py-2 rounded hover:bg-gray-700"
        onClick={onRegister}
      >
        Register
      </button>
    </nav>
  );
}