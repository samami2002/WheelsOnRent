import React, {useState, useEffect} from 'react';
import {useNavigate} from 'react-router-dom';
import axios from 'axios';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import moment from 'moment-timezone';
import './Booking.css';
import 'bootstrap/dist/css/bootstrap.min.css';


function Booking() {
    const navigate = useNavigate();
    const [cars, setCars] = useState([]);
    const [selectedCar, setSelectedCar] = useState('');
    const [name, setName] = useState('');
    const [nationalIdentificationNumber, setNationalIdentificationNumber] = useState('');
    const [drivingLicenseNumber, setDrivingLicenseNumber] = useState('');
    const [email, setEmail] = useState('');
    const [addressStreet, setAddressStreet] = useState('');
    const [addressCity, setAddressCity] = useState('');
    const [addressPostalCode, setAddressPostalCode] = useState('');
    const [addressCountry, setAddressCountry] = useState('');
    const [phoneNumber, setPhoneNumber] = useState('');
    const [rentalDateTime, setRentalDateTime] = useState('');
    const [returnDateTime, setReturnDateTime] = useState('');

    useEffect(() => {
        axios.get('http://localhost:8091/cars/Available-cars')
            .then(response => {
                setCars(response.data);
            })
            .catch(error => {
                console.error('Error fetching cars:', error);
            });
    }, []);

    const handleBooking = async () => {
        let carResponse, customerResponse, rentalResponse;


        try {
            if (
                !selectedCar ||
                !name ||
                !nationalIdentificationNumber ||
                !drivingLicenseNumber ||
                !email ||
                !addressStreet ||
                !addressCity ||
                !addressCountry ||
                !addressPostalCode ||
                !phoneNumber ||
                !rentalDateTime ||
                !returnDateTime
            ) {
                alert('Please fill in all fields before booking.');
                return;
            } if (moment(returnDateTime).isBefore(rentalDateTime)) {
                alert('Return date and time cannot be before rental date and time.');
                return;
            }

            // Convert the timezone and use the correct format
            const formattedRentalDateTime = moment(rentalDateTime).tz('Europe/Stockholm').format('YYYY-MM-DDTHH:mm:ss');
            const formattedReturnDateTime = moment(returnDateTime).tz('Europe/Stockholm').format('YYYY-MM-DDTHH:mm:ss');
            console.log('Formatted Rental DateTime:', formattedRentalDateTime);
            console.log('Formatted Return DateTime:', formattedReturnDateTime);

            // Call Car microservice to change the car's availability
            carResponse = await axios.patch(`http://localhost:8091/cars/${selectedCar}/availability?available=false`);
            console.log('Car availability updated successfully:', carResponse.data);

            // Call Customer microservice to create a customer
            customerResponse = await axios.post('http://localhost:8093/customers', {
                name,
                nationalIdentificationNumber,
                drivingLicenseNumber,
                email,
                address: {
                    street: addressStreet,
                    city: addressCity,
                    postalCode: addressPostalCode,
                    country: addressCountry,
                },
                phoneNumber,
            });
            console.log('Customer created/updated successfully:', customerResponse.data);

            // Call Rental microservice to add a rental
            rentalResponse = await axios.post('http://localhost:8092/rentals', {
                customerId: customerResponse.data.id,
                carId: selectedCar,
                rentalDateTime: formattedRentalDateTime,
                returnDateTime: formattedReturnDateTime,
            });
            console.log('Rental created successfully:', rentalResponse.data);

            // Navigate to the confirmation page after a successful booking
            navigate('/booking-confirmation');

        } catch (error) {
            console.error('Error during booking:', error);

            // If an error occurs, attempt to rollback changes
            try {
                if (carResponse) {
                    // Rollback car availability change
                    await axios.patch(`http://localhost:8091/cars/${selectedCar}/availability?available=true`);
                    console.log('Rolled back car availability change');
                }

                if (customerResponse) {
                    // Rollback customer creation/update
                    await axios.delete(`http://localhost:8093/customers/${customerResponse.data.id}`);
                    console.log('Rolled back customer creation/update');
                }

                // Note: It may not be possible to rollback a rental creation

            } catch (rollbackError) {
                console.error('Error during rollback:', rollbackError);
            }
        }
    };


    return (
        <div className="booking-container">
            <h2>Booking Page</h2>
            <div>
                <label>
                    Choose a car:
                    <select value={selectedCar} onChange={(e) => setSelectedCar(e.target.value)}>
                        <option value="" disabled>Select a car</option>
                        {cars.map(car => (
                            <option key={car.id} value={car.id}>{car.brand} {car.model}</option>
                        ))}
                    </select>
                </label>
            </div>

            <div>
                <label>
                    Name:
                    <input type="text" value={name} onChange={(e) => setName(e.target.value)}/>
                </label>
            </div>

            <div>
                <label>
                    Personal Number:
                    <input type="text" value={nationalIdentificationNumber}
                           onChange={(e) => setNationalIdentificationNumber(e.target.value)}/>
                </label>
            </div>

            <div>
                <label>
                    License Number:
                    <input type="text" value={drivingLicenseNumber}
                           onChange={(e) => setDrivingLicenseNumber(e.target.value)}/>
                </label>
            </div>

            <div>
                <label>
                    Email:
                    <input type="text" value={email} onChange={(e) => setEmail(e.target.value)}/>
,                </label>
            </div>

            <div>
                <label>
                    Address Street:
                    <input type="text" value={addressStreet}
                           onChange={(e) => setAddressStreet(e.target.value)}/>
                </label>
            </div>

            <div>
                <label>
                    Address City:
                    <input type="text" value={addressCity}
                           onChange={(e) => setAddressCity(e.target.value)}/>
                </label>
            </div>

            <div>
                <label>
                    Address Postal Code:
                    <input type="text" value={addressPostalCode}
                           onChange={(e) => setAddressPostalCode(e.target.value)}/>
                </label>
            </div>

            <div>
                <label>
                    Address Country:
                    <input type="text" value={addressCountry}
                           onChange={(e) => setAddressCountry(e.target.value)}/>
                </label>
            </div>

            <div>
                <label>
                    Phone Number:
                    <input type="text" value={phoneNumber}
                           onChange={(e) => setPhoneNumber(e.target.value)}/>
                </label>
            </div>
            <div>
                <label>
                    Rental Date and Time:
                    <DatePicker
                        selected={rentalDateTime}
                        onChange={date => setRentalDateTime(date)}
                        showTimeSelect
                        timeFormat="HH:mm"
                        timeIntervals={15}
                        dateFormat="MMMM d, yyyy h:mm aa"
                        timeCaption="Time"
                    />
                </label>                                                                                                                                            
            </div>
            <div>
                <label>
                    Return Date and Time:
                    <DatePicker
                        selected={returnDateTime}
                        onChange={date => setReturnDateTime(date)}
                        showTimeSelect
                        timeFormat="HH:mm"
                        timeIntervals={15}
                        dateFormat="MMMM d, yyyy h:mm aa"
                        timeCaption="Time"
                    />
                </label>
            </div>
            <button onClick={handleBooking}>Book Now</button>
        </div>
    );
}

export default Booking;
