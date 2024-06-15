import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Auth from './components/auth/Auth'; 
import Error from './Error';
import Nav from './components/nav/Nav';

const App : React.FC = () => {
  return (
    <Router>
      <div>
        <Nav/>
      <Routes>
        <Route path="/" element={<div><h1>Home Page</h1></div>} />
        <Route path="/auth" element={<Auth />} />
        <Route path="*" element={<Error/>} />
      </Routes>
      </div>

    </Router>
  );
};

export default App;
