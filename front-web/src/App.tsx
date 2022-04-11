import './App.css';
import Footer from './Footer';

import Navbar from './Navbar';
import RoutesSite from './RouterPages';

function App() {
  return (
    <div className="App">
      
        <Navbar/>
        <RoutesSite/>
        <Footer />
    </div>
  );
}

export default App;
