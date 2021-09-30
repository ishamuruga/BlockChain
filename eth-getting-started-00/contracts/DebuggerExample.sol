// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract DebuggerExample {
    uint public tokens =10;
    
    function setTokens(uint _val) public {
        tokens = _val;
    }
}