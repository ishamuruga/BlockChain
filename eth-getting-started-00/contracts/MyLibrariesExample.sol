// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

import "https://github.com/OpenZeppelin/openzeppelin-contracts/contracts/utils/math/SafeMath.sol";

contract MyLibrariesExample {
    
    using SafeMath for uint;
    
    mapping(address => uint) public tokenBalance;
    
    event SendData(address _from,address _to, uint _val);
    
    
    constructor() {
        tokenBalance[msg.sender] = 1;
    }
    
    function sendToken(address _to, uint _amount) public returns(bool) {
        emit SendData(msg.sender,_to,_amount);
        tokenBalance[msg.sender]  =  tokenBalance[msg.sender].sub(_amount);
        tokenBalance[_to] = tokenBalance[_to].add(_amount);
        
        return true;
    }
}