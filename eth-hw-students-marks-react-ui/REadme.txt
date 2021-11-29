node
let Web3 = require("web3");
web3
let web3 = new Web3();
let web3 = new Web3(new Web3.providers.HttpProvider("http://localhost:7545"));
web3.eth.getBalance("0x36737E8fCFaa63040E9a1116eB309F5eC5d08044").then(a=>console.log(a));
or
web3.eth.getBalance("0x36737E8fCFaa63040E9a1116eB309F5eC5d08044").then(console.log);
web3.eth.getBalance("0x36737E8fCFaa63040E9a1116eB309F5eC5d08044").then(a=>console.log(web3.utils.fromWei(a,"ether")));
web3.eth.sendTransaction({from:"0x36737E8fCFaa63040E9a1116eB309F5eC5d08044",to:"0x4093037Bbe6ddBaed13BcC509969C9579b2fB0FD",value:web3.utils.toWei("1","ether")});

HWContract.sol
==============
account, contact address, function address(input) :-
web3.eth.call({from:"0x3EE395b7F0D0d8d48B69003d15ADC1484F0D97ef",to:"0xB742452B6a2471d1E7D61D008d143966cDF2ACb2",data:"0x6a345bb4"}).then(console.log);
web3.eth.call({from:"0x3EE395b7F0D0d8d48B69003d15ADC1484F0D97ef",to:"0xB742452B6a2471d1E7D61D008d143966cDF2ACb2",data:web3.utils.sha3("myUnit()").substr(0,10)}).then(console.log);



let contract = new web3.eth.Contract(ABI,ADDR);
contract.methods.myUnit().call().then(console.log);
contract.methods.setUint(56).send({from:"0x3EE395b7F0D0d8d48B69003d15ADC1484F0D97ef"}).then(console.log);

contract.methods.createItem("mobEx",100).send({from:"0x866Ce66CD52a44fF29589b3372a9F1b42E12F872"}).then(console.log)

dadfadda        fff
web3.eth.getAccounts().then(console.log);   


Genesis File
============================

{
 "config": {
    "chainId": 15,
    "homesteadBlock": 0,
    "eip150Block": 0,
    "eip155Block": 0,
    "eip158Block": 0,
    "byzantiumBlock": 0,
    "constantinopleBlock": 0,
    "petersburgBlock": 0,
    "ethash": {}
 },
 "difficulty": "0x20000",
 "gasLimit": "0x8000000",
 "alloc": {}
}

geth init ./genesis.json --datadir mychaindata

geth --datadir ./mychaindata --nodiscover