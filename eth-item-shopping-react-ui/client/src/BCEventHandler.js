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


      console.log("8.#=>");
      console.log(event);

    });


    //let res = this.state.items.map((x) => {
    //  if (x.addr == iAddr) {
    //    x.state = "paid";
    //  }

    //  return x;
    //});

    //console.log("10.#=>" + this.state);

  };

  export default listenToPaymentEvent;