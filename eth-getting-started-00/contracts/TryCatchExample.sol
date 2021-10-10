// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;


contract ContractA  {
    function funARequireFailure() public pure {
        require(false,"This is an Error String");
    }
    
    function funBRevertFailure() public pure {
        revert("Error from Revert Function");
    }
    
    function funCAssertFailure() public pure {
        assert(false);
    }
}


contract ContractB {
    ContractA instA;
    
    event Error(string _reason);
    event LowLevelError(bytes _reason);
    
    constructor() public {
        instA = new ContractA();
    }
    
    
    function testRequireTryCatch() public returns(bool) {
        try instA.funARequireFailure() {
            return true;
        } catch Error(string memory reason) {
            emit Error(reason);
            return false;
        } catch (bytes memory lowLevelData) {
            emit LowLevelError(lowLevelData);
            return false;
        }
    }
}