// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract MappingStructExample {
    
    struct  Payment  {
        uint amount;
        uint timestamp;
    }
    
    struct Balance {
        uint totalBalance;
        uint numPayments;
        mapping(uint => Payment) payments;
    }
    
    
    mapping(address => Balance) public balanceReceived;
   
    function getBalance() public view returns(uint) {
        return address(this).balance;
    }
     
    function receiveMoney() public payable {
        
        balanceReceived[msg.sender].totalBalance += msg.value;
        
        Payment memory payment = Payment(msg.value,block.timestamp);
        
        
        balanceReceived[msg.sender].payments[balanceReceived[msg.sender].numPayments] = payment;
        balanceReceived[msg.sender].numPayments++;
        
        //balanceReceived[msg.sender] += msg.value;
    }
    
    function withDrawAllMoney(address payable _to) public {
        uint balanceToSend = balanceReceived[msg.sender].totalBalance;
        balanceReceived[msg.sender].totalBalance = 0;
        _to.transfer(balanceToSend);
    }
    
    function withDrawAmount(address payable _to, uint _amount) public {
        require(balanceReceived[msg.sender].totalBalance >= _amount,"Not enough Funds");
        balanceReceived[msg.sender].totalBalance = balanceReceived[msg.sender].totalBalance - _amount;
        _to.transfer(_amount);
    }
}