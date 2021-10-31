//SPDX-License-Identifier: MIT

pragma solidity ^0.8.6;

contract HWContract {
    uint public myUnit = 10;
    
    event doLogger(string val);
    
    function setUint(uint _val) public {
        emit doLogger("Test Data");
        myUnit = _val;
    }
}
   
//0x6a345bb4
//0xB742452B6a2471d1E7D61D008d143966cDF2ACb2  