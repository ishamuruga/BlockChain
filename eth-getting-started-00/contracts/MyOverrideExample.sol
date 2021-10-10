// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

contract A {
    event MyEvent(string _mystring);
    
    uint private a = 23;
    
    function funcA() public virtual {
        emit MyEvent("from A");
    }
}

contract B {

    function funcA() public virtual {
        
    }
}

contract C is B,A {
    
    uint a = 23;
    
    function funcA() public override(A,B) {
        emit MyEvent("from C");
        super.funcA();
    }
}