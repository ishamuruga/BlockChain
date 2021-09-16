// SPDX-License-Identifier: MIT
//086
pragma solidity ^0.8.6;

contract Variables {
    uint256 public myUint;

    bool public flag;

    uint8 public mysmallnumber;

    address public myaddress;

    string public name = "Aditya Arunachalam";

    function setName(string memory _name) public {
        name = _name;
    }

    function setMyUint(uint256 _data) public {
        myUint = _data;
    }

    function setMyStatus(bool _data) public {
        flag = _data;
    }

    function addSmallNumber() public {
        mysmallnumber++;
    }

    function reduceSmallNumber() public {
        mysmallnumber--;
    }

    function setMyAddress(address _data) public {
        myaddress = _data;
    }

    function getBalanceOfAddress() public view returns (uint256) {
        return myaddress.balance;
    }
}
