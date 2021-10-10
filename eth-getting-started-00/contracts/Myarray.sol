// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract MyArray {
    
    event log(uint[] _data);
    
    uint[] public ages  = [1,2,3,4,5];
    
    function addAges() public {
        ages.push(12);
        emit  log(ages) ;
    }
    
    function removeAges() public {
        ages.pop();
        emit  log(ages) ;
    }
    
}