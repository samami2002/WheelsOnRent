import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Button } from 'react-bootstrap';
import CarForm from './CarForm';
import './CarManagement.css';
import 'bootstrap/dist/css/bootstrap.min.css';

function CarManagement() {
    const [cars, setCars] = useState([]);
    const [showForm, setShowForm] = useState(false);

    useEffect(() => {
        fetchCars();
    }, []);

    const fetchCars = () => {
        axios.get('http://localhost:8091/cars')
            .then(response => {
                setCars(response.data);
            })
            .catch(error => {
                console.error('Error fetching cars:', error);
            });
    };

    const handleAddCar = (newCar) => {
        axios.post('http://localhost:8091/cars', newCar)
            .then(response => {
                console.log(response.data);
                fetchCars();
            })
            .catch(error => {
                console.error('Error adding car:', error);
            });
    };

    const handleRemoveCar = (carId) => {
        axios.delete(`http://localhost:8091/cars/${carId}`)
            .then(response => {
                console.log(response.data);
                fetchCars();
            })
            .catch(error => {
                console.error('Error removing car:', error);
            });
    };

    const handleShowForm = () => setShowForm(true);
    const handleCloseForm = () => setShowForm(false);

    return (
        <div className="cm-container">
            <h2>Car Management</h2>
            <ul>
                {cars.map(car => (
                    <li key={car.id}>
                        {car.brand} {car.model}
                        <button onClick={() => handleRemoveCar(car.id)}>Remove</button>
                    </li>
                ))}
            </ul>

            <Button variant="primary" onClick={handleShowForm}>
                Add Car
            </Button>

            <CarForm
                show={showForm}
                handleClose={handleCloseForm}
                handleAddCar={handleAddCar}
            />
        </div>
    );
}

export default CarManagement;
