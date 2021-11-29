import React, { useState } from 'react';

export default function Marks(props) {

    const [mrks, setMrks] = React.useState({
        id: 0,
        sub: "",
        mrk: 0
    })

    const handleInputChange = (event) => {
        const target = event.target;
        const value = target.type === "checkbox" ? target.checked : target.value;
        const name = target.name;
        console.log(value);
        setMrks(prev => {
            return {
                ...prev,
                [name]: value
            }
        })
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(mrks);
        props.onAddMarks(mrks);
    }

    return (
        <div>
            <h2>Marks</h2>
            <form>
                <div className="form-group">
                    <label>Index</label>
                    <input type="text" className="form-control" name="id" id="id" placeholder="id" value={mrks.id} onChange={handleInputChange} />
                </div>
                <div className="form-group">
                    <label>Subject</label>
                    <input type="text" className="form-control" name="sub" id="sub" placeholder="sub" value={mrks.sub} onChange={handleInputChange} />
                </div>
                <div className="form-group">
                    <label>Marks</label>
                    <input type="text" className="form-control" name="mrk" id="mrk" placeholder="name" value={mrks.mrk} onChange={handleInputChange} />
                </div>
                <button type="button" className="btn btn-primary" onClick={handleSubmit}>Add Marks</button>

            </form>
        </div>
    );
}
