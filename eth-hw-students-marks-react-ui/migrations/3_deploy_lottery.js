var LotterySol = artifacts.require("./Lottery.sol");
const Web3 = require('web3');

const TruffleConfig = require('truffle');

module.exports = function(deployer) {
    deployer.deploy(LotterySol);
};