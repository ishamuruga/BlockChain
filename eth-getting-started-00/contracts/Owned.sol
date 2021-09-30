pragma solidity ^0.8.6;

contract Owned {
    address owner;
    
    constructor() public {
        owner = msg.sender;
    }
    
    modifier onlyOwner() {
        require(owner == msg.sender,"You are not the Mudhaalali");
        _;
    }
}
