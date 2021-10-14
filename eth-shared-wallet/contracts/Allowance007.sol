// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

//import './BaseContract.sol';
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/access/Ownable.sol";
import "https://github.com/OpenZeppelin/openzeppelin-contracts/blob/master/contracts/utils/math/SafeMath.sol";

contract Allowance007 is Ownable {
    
    event AllowanceChanged(address indexed _to,address indexed _from, uint _oldamount,uint _newamount);
    
    mapping(address => uint) public allowance;
    
    using SafeMath for uint;
    
    function isOwner() internal view returns(bool) {
        return (owner() == _msgSender());
    }
    
    function addAllowance(address _who,uint _amount) public onlyOwner {
        emit AllowanceChanged(_who,msg.sender, allowance[_who] ,_amount);
        allowance[_who] = _amount;
    }
    
    
    
    modifier ownerOrAllowed(uint _amount) {
        require(
                isOwner() || 
                allowance[msg.sender] >= _amount,
                "You are not an Owner either or having required allowance balance");
        _;
    }
    
    function reduceAllowance(address _who,uint _amount) internal {
        emit AllowanceChanged(_who,msg.sender, allowance[_who] ,allowance[_who].sub(_amount));
        allowance[_who] = allowance[_who].sub(_amount);
    }
}