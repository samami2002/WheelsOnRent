import React from 'react';
import {Link} from "react-router-dom";
import './Home.css';
import 'bootstrap/dist/css/bootstrap.min.css';

function Home() {
    return (
        <div className="home-container">
            <h2>Welcome to Wheels On Rent</h2>
            <Link to="/booking">Explore our cars and book your ride today!</Link>
        </div>
    );
}

export default Home;
