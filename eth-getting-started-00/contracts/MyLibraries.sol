// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract MyLibraries {
    mapping(address => uint) public tokenBalance;
    
    event SendData(address _from,address _to, uint _val);
    
    
    constructor() public {
        tokenBalance[msg.sender] = 1000;
    }
    
    function sendToken(address _to, uint _amount) public returns(bool) {
        emit SendData(msg.sender,_to,_amount);
        tokenBalance[msg.sender]  -=  _amount;
        tokenBalance[_to] +=  _amount;
        
        return true;
    }
}