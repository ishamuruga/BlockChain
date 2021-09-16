// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract SendMoneyExample {
    
    uint public balanceReceived;
    
    function receiveMoney() public payable {
        balanceReceived += msg.value;
    }

    function getBalance() public view returns(uint) {
        return address(this).balance;
    }
    
    function _msgSender() internal view virtual returns (address payable){
     return payable(msg.sender); 
    }
    
    function withdrawMoney() public {
        
        // address that call this function.
        //address payable to   = payable(msg.sender); 
        address payable to   = _msgSender();
        to.transfer(this.getBalance());
    }
    
    function withdrawMoneyTo(address payable _to) public {
        _to.transfer(this.getBalance());
    }

}