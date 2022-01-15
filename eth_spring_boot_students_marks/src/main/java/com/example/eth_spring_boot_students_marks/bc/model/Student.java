package com.example.eth_spring_boot_students_marks.bc.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.8.9.
 */
@SuppressWarnings("rawtypes")
public class Student extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060405161045a38038061045a83398101604081905261002f916101bf565b60008390558151610047906001906020850190610064565b50805161005b906002906020840190610064565b50505050610267565b8280546100709061022c565b90600052602060002090601f01602090048101928261009257600085556100d8565b82601f106100ab57805160ff19168380011785556100d8565b828001600101855582156100d8579182015b828111156100d85782518255916020019190600101906100bd565b506100e49291506100e8565b5090565b5b808211156100e457600081556001016100e9565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261012457600080fd5b81516001600160401b038082111561013e5761013e6100fd565b604051601f8301601f19908116603f01168101908282118183101715610166576101666100fd565b8160405283815260209250868385880101111561018257600080fd5b600091505b838210156101a45785820183015181830184015290820190610187565b838211156101b55760008385830101525b9695505050505050565b6000806000606084860312156101d457600080fd5b835160208501519093506001600160401b03808211156101f357600080fd5b6101ff87838801610113565b9350604086015191508082111561021557600080fd5b5061022286828701610113565b9150509250925092565b600181811c9082168061024057607f821691505b6020821081141561026157634e487b7160e01b600052602260045260246000fd5b50919050565b6101e4806102766000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806306fdde0314610046578063820e93f514610064578063af640d0f1461006c575b600080fd5b61004e610083565b60405161005b919061011e565b60405180910390f35b61004e610111565b61007560005481565b60405190815260200161005b565b6001805461009090610173565b80601f01602080910402602001604051908101604052809291908181526020018280546100bc90610173565b80156101095780601f106100de57610100808354040283529160200191610109565b820191906000526020600020905b8154815290600101906020018083116100ec57829003601f168201915b505050505081565b6002805461009090610173565b600060208083528351808285015260005b8181101561014b5785810183015185820160400152820161012f565b8181111561015d576000604083870101525b50601f01601f1916929092016040019392505050565b600181811c9082168061018757607f821691505b602082108114156101a857634e487b7160e01b600052602260045260246000fd5b5091905056fea264697066735822122076e674d73fbd588dc0e23020862cbe8f4b5dda3e11f553a1a20862f31dbe490364736f6c63430008090033";

    public static final String FUNC_EMAIL = "email";

    public static final String FUNC_ID = "id";

    public static final String FUNC_NAME = "name";

    public static final Event EDEBUG_EVENT = new Event("eDebug", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Student(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Student(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Student(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Student(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<EDebugEventResponse> getEDebugEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EDEBUG_EVENT, transactionReceipt);
        ArrayList<EDebugEventResponse> responses = new ArrayList<EDebugEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EDebugEventResponse typedResponse = new EDebugEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EDebugEventResponse> eDebugEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, EDebugEventResponse>() {
            @Override
            public EDebugEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EDEBUG_EVENT, log);
                EDebugEventResponse typedResponse = new EDebugEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.value = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<EDebugEventResponse> eDebugEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EDEBUG_EVENT));
        return eDebugEventFlowable(filter);
    }

    public RemoteFunctionCall<String> email() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_EMAIL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> id() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> name() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_NAME, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Student load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Student(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Student load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Student(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Student load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Student(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Student load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Student(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Student> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, BigInteger _id, String _name, String _email) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_email)));
        return deployRemoteCall(Student.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Student> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, BigInteger _id, String _name, String _email) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_email)));
        return deployRemoteCall(Student.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Student> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _id, String _name, String _email) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_email)));
        return deployRemoteCall(Student.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Student> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _id, String _name, String _email) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_id), 
                new org.web3j.abi.datatypes.Utf8String(_name), 
                new org.web3j.abi.datatypes.Utf8String(_email)));
        return deployRemoteCall(Student.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class EDebugEventResponse extends BaseEventResponse {
        public String _from;

        public BigInteger value;
    }
}
