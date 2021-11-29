// SPDX-License-Identifier: MIT
pragma solidity ^0.8.6;

import "./Student.sol";
import "./Mark.sol";
import "./Ownable.sol";
  
contract StudentManager is Ownable {

    enum GradeState {   
        A,
        B
    }

     struct stu_marks {
        Student _student;   
        Mark[] _marks;
        string  _dept;
        GradeState _gState;
    }

    event StudentChainStep(uint _itemIndex,uint _grade, address _stuAddress);

    mapping(uint => stu_marks) public students;

    function createStudent(uint stuIndex,uint id,string memory name,string memory email) public {
        Student stu = new Student(id,name,email);
        students[stuIndex]._student = stu;
        emit StudentChainStep(stuIndex,0, msg.sender);
    }

    function addMarks(uint stuIndex,string memory subject,uint score) public  {
        Mark mark = new Mark(subject,score);
        students[stuIndex]._marks.push(mark);
        students[stuIndex]._dept = "MECH";
        uint cgpa = mark.getCGPA();
        if (cgpa > 50){ 
            students[stuIndex]._gState =GradeState.A;
        } else {
            students[stuIndex]._gState =GradeState.B;
        }
        emit StudentChainStep(stuIndex,uint(students[stuIndex]._gState), msg.sender);
    }

    function getStudent(uint idx) public returns(Student){
        return students[idx]._student;
    }

    function getMarks(uint idx) public returns(Mark[] memory){
        return students[idx]._marks;
    }


}