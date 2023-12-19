import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Booking from './components/Booking';
import Navigation from './components/Navigation';
import CarManagement from './components/CarManagement';

function App() {
    return (
        <Router>
            <Navigation />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/booking" element={<Booking />} />
                <Route path="/car-management" element={<CarManagement />} />
            </Routes>
        </Router>
    );
}

export default App;
