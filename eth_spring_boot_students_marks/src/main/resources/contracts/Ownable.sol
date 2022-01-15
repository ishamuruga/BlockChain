// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract Ownable {
    address public _owner;
    
    constructor() public {
        _owner = msg.sender;
    }
    
    modifier onlyOwner() {
        require(isOwner(),"You are not the Owner!!");
        _;
    }
    
    function isOwner() public view returns(bool) {
        return (msg.sender == _owner);
    }
}
