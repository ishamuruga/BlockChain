import React, { useState } from 'react';

import MarkContract from "./contracts/Mark.json";
import StudentContract from "./contracts/Student.json";
import StudentManagerContract from "./contracts/StudentManager.json";

import getWeb3 from "./getWeb3";
import "./App.css";
import Student from './components/Student';
import StudentList from './components/StudentList';
import Marks from './components/Marks';
import MarksList from './components/MarksList';


export default function App() {

    const [web3, setWeb3] = React.useState({});
    const [accounts, setAccounts] = React.useState();
    const [networkId, setNetworkId] = React.useState();
    const [studentManager, setStudentManager] = React.useState();
    const [student, setStudent] = React.useState();
    const [mark, setMark] = React.useState();
    const [stus, setStus] = React.useState({
        s: []
    });
    const [mrks, setMrks] = React.useState({
        m: []
    });
    const [ft, setFt] = React.useState(true);


    const [myStuItem, setMyStuItem] = React.useState({
        loaded: false
    });

    React.useEffect(() => {
        getWeb3().then(w3 => {
            console.log("1A.............");
            console.log(w3);
            setWeb3(w3);
        });
    }, []);

    React.useEffect(() => {
        if (web3) {
            if (web3.eth) {
                web3.eth.getAccounts().then(acts => {
                    console.log("2A....................");
                    console.log(acts)
                    setAccounts(acts);
                });

                web3.eth.net.getId().then(nid => {
                    console.log("3A....................");
                    console.log(nid);
                    setNetworkId(nid);
                });
            }
        }
    }, [web3]);


    React.useEffect(() => {

        if (web3) {
            if (web3.eth) {
                setStudentManager(new web3.eth.Contract(
                    StudentManagerContract.abi,
                    StudentManagerContract.networks[networkId] && StudentManagerContract.networks[networkId].address
                ));

                setMark(new web3.eth.Contract(
                    MarkContract.abi,
                    MarkContract.networks[networkId] && MarkContract.networks[networkId].address
                ));

                setStudent(new web3.eth.Contract(
                    StudentContract.abi,
                    StudentContract.networks[networkId] && StudentContract.networks[networkId].address
                ));

                setMyStuItem(prev => {
                    return {
                        ...prev,
                        loaded: true
                    }
                });

                //listenToPaymentEvent();
            }
        }

    }, [networkId]);

    const handleAddStudent = async (val) => {

        console.log(val.id);
        console.log(val.name);
        console.log(val.email);

        let id = val.id;
        let name = val.name;
        let email = val.email;


        let result = await studentManager.methods.createStudent(id, id, name, email).send({ from: accounts[0] });

        console.log(result);

        let sts = stus.s;
        sts.push(val);

        setStus({
            s: sts
        });

        console.log("*********************************************");
        console.log(stus);

        //if (ft) {
        //    console.log("++++++++++++++++++++++++++++++++Event Started");
            listenToEvent();
        //    setFt(false);
        //}

    }

    const handleAddMarks = async (val) => {
        console.log(val);

        let id = val.id;
        let sub = val.sub;
        let mrk = val.mrk;

        let result = await studentManager.methods.addMarks(id, sub, mrk).send({ from: accounts[0] });

        console.log(result);
        let m1 = mrks.m;
        m1.push(val);

        setMrks({
            m: m1
        })
    }

    const handleGetMarks = async () => {
        console.log("===================================Get Marks")

        //let result = await studentManager.methods.getMarks(101).call();
        //let result = await studentManager.methods.getMarks(101).send({ from: accounts[0] });

        //function getMark(uint idx,uint midx) public returns (string memory,uint){

        let result = await studentManager.methods.getMark(101,0).call();

        console.log(JSON.stringify(result));

    }

    const listenToEvent = (event) => {
        console.log("0.#Event=====")
        studentManager.events.MarksEvent().on("data", async function (evt) {
            console.log("1.#Event=====")
            console.log(evt);


        });

        studentManager.events.logger().on("data", async function (evt) {
            console.log("2.#Event=====")
            console.log(evt);
        });
    }


    return (
        <div>
            <Student onAddStudent={handleAddStudent}></Student>
            <br />
            <StudentList data={stus.s}></StudentList>
            <br></br>
            <Marks onAddMarks={handleAddMarks}></Marks>
            <br></br>
            <MarksList data={mrks.m}></MarksList>

            <button onClick={handleGetMarks}>Get Marks</button>
        </div>
    );
}



