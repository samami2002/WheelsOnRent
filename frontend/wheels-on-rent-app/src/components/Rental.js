import React, { useState, useEffect } from 'react';
import { Link } from "react-router-dom";
import axios from 'axios';
import './Rental.css';
import 'bootstrap/dist/css/bootstrap.min.css';

function Rental() {

    const [rentals, setRentals] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8092/rentals')
            .then(response => {
                setRentals(response.data);
            })
            .catch(error => {
                console.error('Error fetching Rentals:', error);
            });
    }, []);



    return (
        <div className="rental_container">
            <div>
                <h2>Hyror</h2>
                <ul>
                    {rentals.map((rental) => (
                        <li key={rental.id}>
                            {rental.customerId} - {rental.carId} - {rental.rentalDateTime} - {rental.returnDateTime}
                        </li>
                    ))}
                </ul>
            </div>
        </div>
    );
}

export default Rental;