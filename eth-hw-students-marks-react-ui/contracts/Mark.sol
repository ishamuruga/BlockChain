// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;


contract Mark {


    string public subject;
    uint public marks;
    

    constructor(string memory _subject,uint _marks) {
        subject = _subject;
        marks = _marks;
    }

    function getCGPA() public returns(uint) {
        return marks/100;
    }    


}
