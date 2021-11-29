import React from 'react';

export default function MarksList(props) {

    let stus = props.data;

    console.log("########################################################");
    console.log(stus);

    return (
        <div>
            <table className="table table-striped table-dark">
                <thead><tr>
                    <th>ID</th>
                    <th>Subject</th>
                    <th>Marks</th>
                </tr></thead>
                <tbody>
                {
                    stus.map((x,idx) => {
                        return <tr key={idx}><td>{x.id}</td><td>{x.sub}</td><td>{x.mrk}</td></tr>;
                    })
                }
                </tbody>
            </table>

        </div>
    );
}
