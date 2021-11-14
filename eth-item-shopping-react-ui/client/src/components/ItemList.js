import React from 'react';
import "./ItemList.css";

export default function ItemList(props) {

  //identifier cost
  let items = props.items;


  const doHandlePayment = (val,addr) => {
    console.log(val);
    props.onClickPayment(val,addr);
  }




  return (
    <div> 
      <table className="table table-striped table-dark">
        <thead><tr>
          <th scope="col"> Item Name</th>
          <th scope="col">Item Cost</th>
          <th scope="col">Item Address</th>
          <th scope="col">Pay</th>
          <th scope="col">Shipment</th>
        </tr></thead>
        <tbody>
          {props.items.map((x,idx) => {
            let lbl="";
            let disabled = false;
            console.log(x.state);
            if (x.state=="purchased"){
              lbl = "btn btn-primary";
            } else if (x.state=="paid"){
              disabled = true;
              lbl = "btn btn-success";
            }

            return <tr key={idx}><td scope="row">{x.identifier}</td><td>{x.cost}</td><td>{x.addr}</td><td><button type="button" className={lbl}  disabled={disabled} onClick={()=> doHandlePayment(idx,x.addr)}>$</button></td><td>{x.state}</td></tr>;
          })} 
        </tbody>
      </table>

    </div>
  );
}
