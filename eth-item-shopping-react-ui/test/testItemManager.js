//import { assert } from "console";

import { assert } from "console";

const ItemManager = artifacts.require("./ItemManager.sol");

contract("ItemManager", accounts => {

    it("Task 1...",async ()=>{
        const itemManagerInstance = await ItemManager.deployed();
        const itemName = "test1";
        const itemPrice = 500;

        const result = await itemManagerInstance.createItem(itemName,itemPrice,{from:accounts[0]});

        console.log(result);

        assert.equal(result.logs[0].args._itemIndex,0,"its not the first item");

        let index = result.logs[0].args._itemIndex;

        const item = itemManagerInstance.items(index);

        console.log(item);

        assert.equal(item._identifier,itemName," The value is not the same");
    });

});