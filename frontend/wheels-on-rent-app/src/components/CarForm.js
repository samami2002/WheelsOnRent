import React, { useState } from 'react';
import { Modal, Button, Form } from 'react-bootstrap';

function CarForm({ show, handleClose, handleAddCar }) {
    const [brand, setBrand] = useState('');
    const [model, setModel] = useState('');
    const [productionYear, setProductionYear] = useState('');

    const handleSubmit = () => {
        // Validate form fields
        if (!brand || !model || !productionYear || isNaN(parseInt(productionYear)) || parseInt(productionYear) < 0) {
            alert('Please enter a valid production year.');
            return;
        }

        // Call the handleAddCar function with the new car data
        handleAddCar({ brand, model, productionYear });

        // Clear form fields
        setBrand('');
        setModel('');
        setProductionYear('');

        // Close the modal
        handleClose();
    };

    return (
        <Modal show={show} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Add Car</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    <Form.Group controlId="formBrand">
                        <Form.Label>Brand</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter brand"
                            value={brand}
                            onChange={(e) => setBrand(e.target.value)}
                        />
                    </Form.Group>

                    <Form.Group controlId="formModel">
                        <Form.Label>Model</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter model"
                            value={model}
                            onChange={(e) => setModel(e.target.value)}
                        />
                    </Form.Group>

                    <Form.Group controlId="formProductionYear">
                        <Form.Label>Production Year</Form.Label>
                        <Form.Control
                            type="text"
                            placeholder="Enter production year"
                            value={productionYear}
                            onChange={(e) => setProductionYear(e.target.value)}
                        />
                    </Form.Group>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>
                    Close
                </Button>
                <Button variant="primary" onClick={handleSubmit}>
                    Add Car
                </Button>
            </Modal.Footer>
        </Modal>
    );
}

export default CarForm;
