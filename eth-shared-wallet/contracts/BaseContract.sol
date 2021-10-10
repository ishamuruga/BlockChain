// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract BaseContract {
    address owner;
    
    event Logger(string _message);
    
    constructor() {
        emit Logger("Constrictor corrsed");
        owner = msg.sender;
    }
    
    modifier onlyOwner() {
        require(owner == msg.sender,"You are not the Mudhaalali");
        _;
    }
}