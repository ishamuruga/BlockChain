import { builtinModules } from 'module';
import React, { useState } from 'react';

export default function Student(props) {

    const [stu, setStu] = React.useState({
        id: 10,
        name: "name",
        email: "noemail@reply.com"
    });



    const handleInputChange = (event) => {
        const target = event.target;
        const value = target.type === "checkbox" ? target.checked : target.value;
        const name = target.name;
        console.log(value);
        setStu(prev => {
            return {
                ...prev,
                [name]: value
            }
        })
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(stu);
        props.onAddStudent(stu);
    }

    return (
        <div>
            <h2>Student</h2>
            <form>
                <div className="form-group">
                    <label>Student Id</label>
                    <input type="text" className="form-control" name="id" id="id" placeholder="id" value={stu.id} onChange={handleInputChange}/>
                </div>
                <div className="form-group">
                    <label>Student Name</label>
                    <input type="text" className="form-control" name="name" id="name" placeholder="name" value={stu.name} onChange={handleInputChange}/>
                </div>
                <div className="form-group">
                    <label>Email address</label>
                    <input type="email" className="form-control" name="email" id="email" aria-describedby="emailHelp" placeholder="Enter email" value={stu.email} onChange={handleInputChange}/>
                    <small id="emailHelp" className="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <button type="button" className="btn btn-primary" onClick={handleSubmit}>Submit</button>


            </form>

        </div>
    );
}
