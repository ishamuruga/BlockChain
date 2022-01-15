// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract Mark {
    string public subject;
    uint256 public marks;

    constructor(string memory _subject, uint256 _marks) {
        subject = _subject;
        marks = _marks;
    }

    function getCGPA() public returns (uint256) {
        return marks / 100;
    }

}
