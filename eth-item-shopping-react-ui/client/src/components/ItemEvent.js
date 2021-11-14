import React from 'react';

export default function ItemEvent(props) {
  return (
    <div> 
    <table className="table table-striped">
      <thead><tr>
        <th scope="col"> Item Name</th>
        <th scope="col">Item Cost</th>
        <th scope="col">Item Address</th>
        <th scope="col">state</th>
        <th scope="col">message</th>
        
      </tr></thead>
      <tbody>
        {props.evtn.map((x,idx) => {
          let lbl="";
          let disabled = false;
          console.log(x.state);
          if (x.state=="purchased"){
            lbl = "btn btn-primary";
          } else if (x.state=="paid"){
            disabled = true;
            lbl = "btn btn-success";
          }

     // const [evt,setEvt] = React.useState({
      //   identifier:"",
      //   item:"",
      //   itemPrice:0,
      //   state:""
      // });

          return <tr key={idx}><td scope="row">{x.identifier}</td><td>{x.itemPrice}</td><td>{x.item}</td><td>{x.state}</td><td>{x.srcdest}</td></tr>;
        })} 
      </tbody>
    </table>

  </div>
  );
}
