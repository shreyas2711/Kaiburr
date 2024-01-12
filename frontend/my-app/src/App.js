import logo from './logo.svg';
import './App.css';
import NavbarComp from './NavbarComp';
import 'bootstrap/dist/css/bootstrap.min.css';
import Home from './pages/Home';
import CreateTask from './pages/CreateTask';
import { BrowserRouter, Routes, Route } from 'react-router-dom';


function App() {
  return (
 
    <BrowserRouter>
     <NavbarComp/>
     <Routes>
     <Route path='/' element={<Home/>}/>
     <Route path='/createtask' element={ <CreateTask/>}/>
     </Routes>
</BrowserRouter>
  );
}

export default App;
