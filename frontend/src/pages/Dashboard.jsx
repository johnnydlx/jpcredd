import Sidebar from '../components/Sidebar';

export default function Dashboard() {
  return (
    <div className="flex">
      <Sidebar />
      <div className="flex-1 p-8 bg-gray-100 min-h-screen">
        <h2 className="text-3xl font-bold mb-6">Bem-vindo ao Dashboard</h2>
        <div className="grid grid-cols-3 gap-6">
          <div className="bg-white p-6 rounded shadow">Total de Clientes</div>
          <div className="bg-white p-6 rounded shadow">Total de Empréstimos</div>
          <div className="bg-white p-6 rounded shadow">Pagamentos Pendentes</div>
        </div>
      </div>
    </div>
  );
}
