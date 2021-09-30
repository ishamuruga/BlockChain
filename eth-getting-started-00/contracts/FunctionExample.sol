// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract FunctionExample {
    
    mapping(address => uint) public balanceReceived;
    
    address payable owner;
    
    constructor(){
        owner = payable(msg.sender);
    }
    
    function receiveMoney() payable public {
        assert(balanceReceived[msg.sender] + msg.value >= balanceReceived[msg.sender]);
        balanceReceived[msg.sender] += msg.value;
    }
    
    
    function withDrawMoney(address payable _to, uint _amount) public {
        require(_amount <= balanceReceived[msg.sender],"Dubuu Illai mamu...");
        assert(balanceReceived[msg.sender] >= balanceReceived[msg.sender] - _amount);
        balanceReceived[msg.sender] -= _amount;
        _to.transfer(_amount);
    }
    
    fallback () external payable {
        receiveMoney(); 
    }
    
    receive() external payable {
        // custom function code
    }
    
    function destroySmartContract() public {
        require(msg.sender==owner, "You are not the owner");
        selfdestruct(owner);
    }
    
    function getOwner() public view returns(address){
        //reading from state   
        return owner;
    }
    
    function convertWeiToEther(uint _amountInWei) public pure returns(uint) {
        // not access the storage or class level variabkles
        // 1 000000000000 18 zeros
        return _amountInWei / 1 ether;
    }
    
}