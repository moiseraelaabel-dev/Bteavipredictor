import React, { useState } from 'react';

const Camera = () => {
    const [lastCrashDistance, setLastCrashDistance] = useState(0);
    const [image, setImage] = useState(null);

    const handleDistanceChange = (event) => {
        setLastCrashDistance(event.target.value);
    };

    const handleImageChange = (event) => {
        if (event.target.files.length > 0) {
            const file = event.target.files[0];
            const reader = new FileReader();
            reader.onloadend = () => {
                setImage(reader.result);
            };
            reader.readAsDataURL(file);
        }
    };

    const handlePredict = () => {
        // Logic for predicting the next signal crash based on input
        console.log('Last Crash Distance:', lastCrashDistance);
        console.log('Image for prediction:', image);
    };

    return (
        <div>
            <h1>Analytics Camera</h1>
            <div>
                <label>Last Crash Distance:</label>
                <input
                    type="number"
                    value={lastCrashDistance}
                    onChange={handleDistanceChange}
                />
            </div>
            <div>
                <label>Scan Photos/Screenshots:</label>
                <input
                    type="file"
                    accept="image/*"
                    onChange={handleImageChange}
                />
            </div>
            {image && <img src={image} alt="Preview" style={{width: '100px', height: '100px'}} />}  
            <button onClick={handlePredict}>Predict</button>
        </div>
    );
};

export default Camera;