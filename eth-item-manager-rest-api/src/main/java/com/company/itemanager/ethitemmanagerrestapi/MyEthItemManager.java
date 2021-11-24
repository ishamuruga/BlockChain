package com.company.itemanager.ethitemmanagerrestapi;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.gas.DefaultGasProvider;

import com.company.itemanager.ethitemmanagerrestapi.contracts.itemmanager.ItemManager;

public class MyEthItemManager {

	public static void main(String[] args) throws Exception {
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
			result1 = web3.ethAccounts().sendAsync().get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result1.getAccounts());

		String addr1 = result1.getAccounts().get(0);

		// ItemManager iContract = ItemManager.deploy(web3, null, Contract.GAS_LIMIT);
		

		String ADMIN_PRIVATE_KEY = "e2806bf6715c3d93667a2b75e4e3f785d398345e8ae94582110f7264e021f3e3";
		Credentials credentials = Credentials.create(ADMIN_PRIVATE_KEY);

		ItemManager iContract = ItemManager.load(addr1, web3, credentials, new DefaultGasProvider());
		
		//ItemManager iContract = ItemManager.deploy(web3, credentials,ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT).send();
		
		
		System.out.println("========================Addr");
		System.out.println(iContract.getContractAddress());
		System.out.println(iContract.getDeployedAddress("5777"));
		
		
		TransactionReceipt res =   iContract.createItem("Petta DVD", new BigInteger("24")).send();
		
//		iContract.createItem("Basha DVD", new BigInteger("124")).send();
//		iContract.createItem("Padaipayya DVD", new BigInteger("224")).send();
		
		System.out.println(res.getLogs());
		System.out.println(res.getLogsBloom());
		
		System.out.println(iContract.items(new BigInteger("0")).send().toString());
//		System.out.println(iContract.items(new BigInteger("1")).send().toString());
//		System.out.println(iContract.items(new BigInteger("2")).send().toString());
//		System.out.println(iContract.items(new BigInteger("3")).send().toString());

	}

}
