import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import Home from './components/Home';
import Booking from './components/Booking';
import Navigation from './components/Navigation';
import CarManagement from './components/CarManagement';
import BookingConfirmation from './components/BookingConfirmation';
import Rental from './components/Rental';
import About from './components/About';

function App() {
    return (
        <Router>
            <Navigation/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/booking" element={<Booking/>}/>
                <Route path="/booking-confirmation" element={<BookingConfirmation/>}/>
                <Route path="/car-management" element={<CarManagement/>}/>
                <Route path="/rental" element={<Rental />} />
                <Route path="/about" element={<About />} />
            </Routes>
        </Router>
    );
}

export default App;
