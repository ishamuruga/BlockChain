// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

import './BaseContract.sol';

contract SharedWallet is BaseContract {
    
    event MethodCalled(string _message,uint _value);   
    
    receive() external payable {
        emit MethodCalled("Money Received.." , msg.value );
    }
    
    function withDrawMoney(address payable _to,uint _amount) public onlyOwner {
        _to.transfer(_amount);
    }
}