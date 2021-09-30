// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract ExceptionExample {
    
    mapping(address => uint64) public balanceReceived;
    
    function receiveMoney() payable public {
        assert(balanceReceived[msg.sender] + uint64(msg.value) >= balanceReceived[msg.sender]);
        balanceReceived[msg.sender] += uint64(msg.value);
    }
    
    
    function withDrawMoney(address payable _to, uint64 _amount) public {
        require(_amount <= balanceReceived[msg.sender],"Dubuu Illai mamu...");
        assert(balanceReceived[msg.sender] >= balanceReceived[msg.sender] - _amount);
        balanceReceived[msg.sender] -= _amount;
        _to.transfer(_amount);
    }
    
}