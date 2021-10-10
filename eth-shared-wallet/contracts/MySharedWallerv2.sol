// SPDX-License-Identifier: MIT

pragma solidity ^0.8.6;


import "https://github.com/OpenZeppelin/openzeppelin-contracts/contracts/access/Ownable.sol";
//import "./BaseUtil.sol";

contract MySharedWallet is Ownable {
    
    //uint public initialBalance = 50 ether;
    
    function isOwner() internal view returns(bool) {
        return owner() == msg.sender;
    }
    
    mapping(address => uint) public allowance;
    
    event logger(string _str);   
    event logger(bool _bol);   
    event logger(uint _uint);
    event logger(address _addr);
    
    function addAllowance(address _who,uint _amount) public onlyOwner {
        emit logger("==================add-allowance");
        emit logger(_who);
        emit logger(_amount);
        allowance[_who] = _amount;
    }
    
    modifier ownerOrAllowed(uint _amount) {
        emit logger("==================");
        emit logger(isOwner());
        //emit logger(uintToString(allowance[msg.sender]));
        //emit logger(uintToString(_amount));
        emit logger(_amount);
        
        require(isOwner() || allowance[msg.sender] >= _amount, "You are not allowed!");
        _;
    }
    
    function reduceAllowance(address _who, uint _amount) internal ownerOrAllowed(_amount) {
        allowance[_who] -= _amount;
    }
    
    function withDrawMoney(address payable _to,uint _amount) public ownerOrAllowed(_amount) {
        require(_amount <= address(this).balance, "Contract doesn't own enough money");
        if(!isOwner()) {
            reduceAllowance(msg.sender, _amount);
        }
        _to.transfer(_amount);
    }
    
    receive() external payable {
       emit logger("Money In......");
       emit logger(msg.value);
    }
    
    
}