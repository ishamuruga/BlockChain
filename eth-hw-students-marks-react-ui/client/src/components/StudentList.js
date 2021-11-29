import React from 'react';

export default function StudentList(props) {

    let stus = props.data;

    console.log("########################################################");
    console.log(stus);

    return (
        <div>
            <table className="table table-striped table-dark">
                <thead><tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                </tr></thead>
                <tbody>
                {
                    stus.map((x,idx) => {
                        return <tr key={idx}><td>{x.id}</td><td>{x.name}</td><td>{x.email}</td></tr>;
                    })
                }
                </tbody>
            </table>

        </div>
    );
}
