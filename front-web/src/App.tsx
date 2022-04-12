import './App.css';
import Footer from './Footer';
import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import Navbar from './Navbar';
import RoutesSite from './RouterPages';

function App() {
  return (
    <div className="App">
      <Navbar />
      <RoutesSite />
      <Footer />
      <ToastContainer />
    </div>
  );
}

export default App;
