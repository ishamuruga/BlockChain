package com.example.eth_spring_boot_students_marks.config;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import okhttp3.OkHttpClient;

@Configuration
public class StudentConfig {
	
	@Value("${student.contract.gas-price}")
	private BigInteger gasPrice;
	
	@Value("${student.contract.gas-limit}")
    private BigInteger gasLimit;
	
	@Value("${student.contract.address}")
	private String contractAddress;
	
	@Value("${student.contract.owner-address}")
	private String ownerContractAddress;
	
	@Value("${web3j.client-address}")
	private String web3ClientAddress;
	
	@Bean
	public Web3j web3j() {
		System.out.println("WEB3J====" + web3ClientAddress);
		return Web3j.build(new HttpService(web3ClientAddress, new OkHttpClient.Builder().build()));
	}
	
	
	public String getOwnerContractAddress() {
		return ownerContractAddress;
	}

	public void setOwnerContractAddress(String ownerContractAddress) {
		this.ownerContractAddress = ownerContractAddress;
	}

	public String getContractAddress() {
		return contractAddress;
	}

	public void setContractAddress(String contractAddress) {
		this.contractAddress = contractAddress;
	}

	public String getWeb3ClientAddress() {
		return web3ClientAddress;
	}

	public void setWeb3ClientAddress(String web3ClientAddress) {
		this.web3ClientAddress = web3ClientAddress;
	}

	public StaticGasProvider gas() {
        return new StaticGasProvider(gasPrice, gasLimit);
    }

	public BigInteger getGasPrice() {
		return gasPrice;
	}

	public void setGasPrice(BigInteger gasPrice) {
		this.gasPrice = gasPrice;
	}

	public BigInteger getGasLimit() {
		return gasLimit;
	}

	public void setGasLimit(BigInteger gasLimit) {
		this.gasLimit = gasLimit;
	}
    
    
}
