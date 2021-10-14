// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

import './Allowance007.sol';
import 'https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/access/Ownable.sol';

contract SimpleWaller007 is Allowance007 {
    
    //address public owner;
    
    // constructor() public {
    //     owner = msg.sender;
    // }  
    
    // modifier onlyOwner() {
    //     require(owner==msg.sender,"You are not the Owner!!!");
    //     _;
    // }
    
    event MoneySent(address indexed _bene,uint _amount);
    event MoneyReceived(address indexed _from,uint _amount);
    
    function withDrawMoney(address payable _to, uint _amount) public ownerOrAllowed(_amount) {
        require(_amount <= address(this).balance,"No Main Balance");
        if(!isOwner()){
            reduceAllowance(msg.sender,_amount);
        }
        
        emit MoneySent(_to,_amount);
        
        _to.transfer(_amount);
    }
    
    
    //8821
    fallback () external payable {
       emit MoneyReceived(msg.sender,msg.value); 
    }
    
    function  renounceOwnership() public override onlyOwner{
        revert("Cant revert ownership here");
    }
 
}