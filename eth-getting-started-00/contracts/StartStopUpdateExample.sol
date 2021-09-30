// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract StartStopUpdateExample {

    address owner;
    
    bool public paused = false;

    constructor()  {
        owner = msg.sender;
    }
    
    function receiveMoney() public payable {

    }

    function setPaused(bool _paused) public {
        require(owner == msg.sender, "Fn-Paused,You are not the owner");
        paused = _paused;
    }

    function getBalance() public view returns(uint) {
        return address(this).balance;
    }
    

    function withdrawMoneyAllMoney(address payable _to) public {
        require(owner == msg.sender, "Fn-WithdrawMoneyAllMoney,You are not the owner");
        require(!paused,"Contract is paused");
        _to.transfer(this.getBalance());
    }
    
    function destroySmartContract(address payable _to) public {
        require(owner == msg.sender, "Fn-WithdrawMoneyAllMoney,You are not the owner");
        selfdestruct(_to);
    }

}