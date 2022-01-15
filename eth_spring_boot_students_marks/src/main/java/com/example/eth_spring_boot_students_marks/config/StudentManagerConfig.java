//package com.example.eth_spring_boot_students_marks.config;
//
//import org.springframework.beans.factory.annotation.Configurable;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.web3j.protocol.Web3j;
//import org.web3j.protocol.http.HttpService;
//
//import okhttp3.OkHttpClient;
//
//@Ci\
//public class StudentManagerConfig {
//
//	@Value("${student.contract.owner-address}")
//	private String ownerAddress;
//
//	@Value("${web3j.client-address}")
//	private String clientAddress;
//
//	@Bean
//	public Web3j web3j() {
//		return Web3j.build(new HttpService(clientAddress, new OkHttpClient.Builder().build()));
//	}
//}
