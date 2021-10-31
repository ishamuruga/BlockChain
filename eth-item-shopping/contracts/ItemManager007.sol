// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract Ownable {
    address payable _owner;
    
    constructor() public {
        _owner = payable(msg.sender);
    }
    
    modifier onlyOwner() {
        require(isOwner(),"You are not the Owner!!");
        _;
    }
    
    function isOwner() public view returns(bool) {
        return (msg.sender == _owner);
    }
}

contract Item007 {
    uint public priceInWei;
    uint public pricePaid;
    uint public index;
    
    ItemManager007 parentContract;
    
    constructor (
        ItemManager007 _parentContract,
        uint  _priceInWei,
        uint  _index
    ) public {
        parentContract = _parentContract;
        priceInWei = _priceInWei;
        index = _index;
    }
    
    receive() external payable {
        require(pricePaid ==0,"Item is already paid");
        require(priceInWei == msg.value,"Only Full Payments are allowed");
        pricePaid += msg.value;
        (bool sucess, ) = address(parentContract).call{value:msg.value}(abi.encodeWithSignature("triggerPayment(uint256)",index));
        require(sucess,"The Transaction wasn't sucessfull, hence cancelling...");
    }
    
    fallback() external {
        
    }
    
}


contract ItemManager007 is Ownable {

    enum SupplyChainState {
        Created,
        Paid,
        Delivered
    }

    struct S_Item {
        Item007 _item;   
        string _identifier;
        uint _itemPrice;
        ItemManager007.SupplyChainState _state;
    }

    mapping(uint => S_Item) public items;
   
    uint itemIndex;

    event SupplyChainStep(uint _itemIndex,uint _step, address _itemAddress);
    
    function createItem(string memory _identifier, uint _itemPrice) public onlyOwner {
        Item007 item = new Item007(this,_itemPrice,itemIndex);
        items[itemIndex]._item= item;
        items[itemIndex]._identifier = _identifier;
        items[itemIndex]._itemPrice = _itemPrice;
        items[itemIndex]._state = SupplyChainState.Created;
        emit  SupplyChainStep(itemIndex,uint(items[itemIndex]._state),address(item));
        itemIndex++;
    }

    function triggerPayment(uint _itemIndex) payable public {
        require(items[_itemIndex]._state == SupplyChainState.Created,"Item is already Paid");
        require(items[_itemIndex]._itemPrice == msg.value,"Only Full Payment is accpeted");
        
        items[itemIndex]._state = SupplyChainState.Paid;
        emit  SupplyChainStep(_itemIndex,uint(items[_itemIndex]._state),address(items[_itemIndex]._item));
    }

    function triggerDelivery(uint _itemIndex) public onlyOwner {
        require(items[_itemIndex]._state == SupplyChainState.Paid,"Item is already Delivered");
        items[itemIndex]._state = SupplyChainState.Delivered;
        emit  SupplyChainStep(_itemIndex,uint(items[_itemIndex]._state),address(items[_itemIndex]._item));
    }
}