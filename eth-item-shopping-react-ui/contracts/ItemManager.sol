// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

import "./Ownable.sol";
import "./Item.sol";

contract ItemManager is Ownable {
  
    enum SupplyChainState {
        Created,
        Paid,  
        Delivered
    }

    struct S_Item {
        Item _item;   
        string _identifier;
        uint _itemPrice;
        ItemManager.SupplyChainState _state;
    }

    mapping(uint => S_Item) public items;
   
    uint itemIndex;

    event SupplyChainStep(uint _itemIndex,uint _step, address _itemAddress,string srcdest);
    
    function createItem(string memory _identifier, uint _itemPrice) public onlyOwner {
        Item item = new Item(this,_itemPrice,itemIndex);
        items[itemIndex]._item= item;
        items[itemIndex]._identifier = _identifier;
        items[itemIndex]._itemPrice = _itemPrice;
        items[itemIndex]._state = SupplyChainState.Created;
        emit  SupplyChainStep(itemIndex,uint(items[itemIndex]._state),address(item),"createitem");
        itemIndex++;
    }

    function triggerPayment(uint _itemIndex) payable public {
        require(items[_itemIndex]._state == SupplyChainState.Created,"Item is already Paid");
        require(items[_itemIndex]._itemPrice == msg.value,"Only Full Payment is accpeted");
        
        items[_itemIndex]._state = SupplyChainState.Paid;
        emit  SupplyChainStep(_itemIndex,uint(items[_itemIndex]._state),address(items[_itemIndex]._item),"triggerpayment");
    }

    function triggerDelivery(uint _itemIndex) public onlyOwner {
        require(items[_itemIndex]._state == SupplyChainState.Paid,"Item is already Delivered");
        items[itemIndex]._state = SupplyChainState.Delivered;
        emit  SupplyChainStep(_itemIndex,uint(items[_itemIndex]._state),address(items[_itemIndex]._item),"triggerdelviery");
    }
}