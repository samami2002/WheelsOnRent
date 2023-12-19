import React from 'react';
import { Link } from 'react-router-dom';

function Navigation() {
    return (
        <nav>
            <ul>
                <li><Link to="/">Home</Link></li>
                <li><Link to="/about">About</Link></li>
                <li><Link to="/booking">Booking</Link></li>
                <li><Link to="/car-management">Car Management</Link></li>
                <li><Link to="/rental">Rental</Link></li>
            </ul>
        </nav>
    );
}

export default Navigation;
