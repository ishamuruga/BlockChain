package com.company.itemanager.ethitemmanagerrestapi;

import java.util.concurrent.ExecutionException;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.http.HttpService;

public class MyEthClient {
	public static void main(String[] args) {
		Web3j web3 = Web3j.build(new HttpService("http://127.0.0.1:7545")); 
        EthBlockNumber result = null;
		try {
			result = web3.ethBlockNumber().sendAsync().get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        System.out.println(" The Block Number is: " + result.getBlockNumber().toString());
        
        
        EthAccounts result1 = new EthAccounts();
        try {
			result1 = web3.ethAccounts()
			    .sendAsync() 
			    .get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(result1.getAccounts());
	}
}
