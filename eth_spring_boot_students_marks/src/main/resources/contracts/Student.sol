// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;


contract Student { 

    uint public id;   
    string public name;
    string public email;

    event eDebug(address _from, uint value);

    constructor(uint _id,string memory _name,string memory _email){
        id = _id;
        name = _name;
        email = _email;
    }

}
