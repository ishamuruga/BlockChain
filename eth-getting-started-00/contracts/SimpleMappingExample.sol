// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract SimpleMappingExample {
    //all value will be set to false initially
    mapping(uint => bool) public myMapping;
    
    mapping(address => bool) public myAddressMapping;
    
    function setMapping(uint _index) public {
        myMapping[_index] = true;
    }
    
    function setMyAddressToTrue() public {
        myAddressMapping[msg.sender] = true;
    }
    
}