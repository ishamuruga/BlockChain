var StudentManager = artifacts.require("./StudentManager.sol");

module.exports = function(deployer) {
  deployer.deploy(StudentManager);
};
