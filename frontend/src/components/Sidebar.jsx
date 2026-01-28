import { Link } from 'react-router-dom';

export default function Sidebar() {
  return (
    <div className="w-64 bg-gray-800 text-white min-h-screen p-5">
      <h1 className="text-xl font-bold mb-6">Dashboard</h1>
      <nav className="flex flex-col gap-4">
        <Link to="/dashboard" className="hover:bg-gray-700 p-2 rounded">Início</Link>
        <Link to="/clientes" className="hover:bg-gray-700 p-2 rounded">Clientes</Link>
        <Link to="/emprestimos" className="hover:bg-gray-700 p-2 rounded">Empréstimos</Link>
        <Link to="/pagamentos" className="hover:bg-gray-700 p-2 rounded">Pagamentos</Link>
      </nav>
    </div>
  );
}
