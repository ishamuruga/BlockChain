import React, { useState } from 'react';

import ItemManagerContract from "./contracts/ItemManager.json";
import ItemContract from "./contracts/Item.json";
import ItemList from "./components/ItemList";

import getWeb3 from "./getWeb3";

//import listenToPaymentEvent from "./BCEventHandler";

import "./App.css";
import ItemEvent from './components/ItemEvent';

export default function App() {

  //let web3;
  //let accounts = null;
  //let networkId = "";
  //let itemManager;
  //let item;
  //let name = "rajkumar";

  const [web3, setWeb3] = React.useState({});
  const [accounts, setAccounts] = React.useState();
  const [networkId, setNetworkId] = React.useState();
  const [itemManager, setItemManager] = React.useState();
  const [item, setItem] = React.useState();
  const [name, setName] = React.useState("rajkumar");

  const [ft,setFt] = React.useState(true);
  const [evtn,setEvtn] = React.useState({
    payloads:[]
  });

  const [myItem, setMyItem] = React.useState({
    loaded: false,
    cst: 10,
    itemName: "example-1",
    items: []
  });

  React.useEffect(() => {

    //window.addEventListener('load', listenToPaymentEvent);

    setName("superstar");
    console.log("1............." + name);

    getWeb3().then(w3 => {
      console.log("1A.............");
      console.log(w3);
      setWeb3(w3);

    });

    console.log("2.............end");

  }, []);

  React.useEffect(() => {
    console.log("3....................");
    console.log("4...................." + name);

    if (web3) {
      if (web3.eth) {




        web3.eth.getAccounts().then(acts => {
          console.log("5....................");
          console.log(acts)
          setAccounts(acts);
        });

        web3.eth.net.getId().then(nid => {
          console.log("6....................");
          console.log(nid);
          setNetworkId(nid);
        });

        console.log("7....................");
        console.log(networkId);

        setItemManager(new web3.eth.Contract(
          ItemManagerContract.abi,
          ItemManagerContract.networks[networkId] && ItemManagerContract.networks[networkId].address
        ));

        setItem(new web3.eth.Contract(
          ItemContract.abi,
          ItemContract.networks[networkId] && ItemContract.networks[networkId].address,
        ));


        setMyItem(prev => {
          return {
            ...prev,
            loaded: true
          }
        });
      }
    }

  }, [web3]);

  React.useEffect(() => {

    if (web3) {
      if (web3.eth) {
        setItemManager(new web3.eth.Contract(
          ItemManagerContract.abi,
          ItemManagerContract.networks[networkId] && ItemManagerContract.networks[networkId].address
        ));

        setItem(new web3.eth.Contract(
          ItemContract.abi,
          ItemContract.networks[networkId] && ItemContract.networks[networkId].address,
        ));



        setMyItem(prev => {
          return {
            ...prev,
            loaded: true
          }
        });

        //listenToPaymentEvent();
      }
    }

  }, [networkId]);

  // React.useEffect(() => {

  //   if (itemManager) {
  //     console.log("*");
  //     listenToPaymentEvent();
  //   } else {
  //     console.log("**");
  //   }

  // }, [itemManager, item]);

  const handleInputChange = (event) => {
    const target = event.target;
    const value = target.type === "checkbox" ? target.checked : target.value;
    const name = target.name;
    setMyItem(prev => {
      return {
        ...prev,
        [name]: value
      }

    })
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    console.log(name);

    let itemName = myItem.itemName;
    let cst = myItem.cst;

    console.log(cst);
    console.log(itemName);
    console.log(accounts[0]);

    if (ft){
      listenToPaymentEvent();
      setFt(false);
    }

    let result = await itemManager.methods.createItem(itemName, cst).send({ from: accounts[0] })

    console.log("1HS");
    //console.log(result);

    //let result = await itemManager.methods.createItem(itemName, cst).send({ from: accounts[0] });
    let itmAddress = result.events.SupplyChainStep.returnValues._itemAddress ? result.events.SupplyChainStep.returnValues._itemAddress : "none";

    let tItems = myItem.items;
    tItems.push({
      "identifier": itemName,
      "cost": parseInt(cst),
      "addr": itmAddress,
      "state": "purchased"
    });

    setMyItem((prev) => {
      return {
        ...prev,
        items: tItems
      }
    });


  }

  const handlePayment = async (idx, addr) => {
    console.log("Handle Payment/../");
    //console.log(e);

    let itms = myItem.items;
    console.log(itms);




    let tempItem = myItem.items[idx];
    let cost = tempItem.cost;

    console.log("Send Money to Item..." + idx + "," + addr + "," + cost);

    let itemPaymentResult = await web3.eth.sendTransaction({ to: addr, value: cost, from: accounts[0] });
    console.log(itemPaymentResult);

    if (itemPaymentResult) {
      let result = itms.map(item => {
        if (item.addr == addr) {
          item.state = "paid"
        }
        return item
      });

      setMyItem(prev => {
        return {
          ...prev,
          //items: itms
          items: result
        }
      });
    }

    //web3.eth.sendTransaction({to:"0xdCB7b5E4Db2dC46082336e92282c2818c4385075",value:101,from:accounts[0]})


    console.log(myItem);
    console.log("================");
  }


  const listenToPaymentEvent = (event) => {
    let self = this;
    console.log("0.#Event=====");



    itemManager.events.SupplyChainStep().on("data", async function (evt) {

      console.log("1.#Event=====")
      console.log(evt);
      let itemObj = await itemManager.methods.items(evt.returnValues._itemIndex).call();

      console.log("2.#Itemm=====")
      console.log(itemObj);
      console.log("3.#Sweet MEssage=====")
      //console.log("4.#item.." + itemObj._identifier + "was paid and ready to be delivered");
      console.log("4.#=>" + itemObj._identifier);
      console.log("5.#=>" + itemObj._item);
      console.log("6.#=>" + itemObj._itemPrice);
      console.log("7.#=>" + itemObj._state);
      console.log("77.#=>" + itemObj.src);


      console.log("8.#=>");


      //myItem
      
      let ploads = evtn.payloads;
      
      ploads.push({
        identifier:itemObj._identifier,
        item:itemObj._item,
        itemPrice:itemObj._itemPrice,
        state:itemObj._state,
        srcdest:evt.returnValues.srcdest
      });

      setEvtn({
        payloads:  ploads
      });


      // const [evt,setEvt] = React.useState({
      //   identifier:"",
      //   item:"",
      //   itemPrice:0,
      //   state:""
      // });

      

    });


    //let res = this.state.items.map((x) => {
    //  if (x.addr == iAddr) {
    //    x.state = "paid";
    //  }

    //  return x;
    //});

    //console.log("10.#=>" + this.state);

  };

  return (
    <div>
      <div className="App">
        <form>
          <h1>Event Trigger / Supply Chain Example</h1>
          <h2>Items</h2>
          <h3>Add Items</h3>
          Cost in Wei : <input type="text" name="cst" value={myItem.cst} onChange={handleInputChange} />
          Item Identifier : <input type="text" name="itemName" value={myItem.itemName} onChange={handleInputChange} />
          <button type="submit" onClick={handleSubmit}>Create New Item</button>

          <ItemList items={myItem.items} onClickPayment={handlePayment}></ItemList>
          <hr/>
          <h3>Event Dump</h3>
          <ItemEvent evtn={evtn.payloads}></ItemEvent>
        </form>
      </div>
    </div>
  );
}
