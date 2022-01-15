package com.example.eth_spring_boot_students_marks.bc.model;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
public class Mark extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b5060405161042838038061042883398101604081905261002f916100fb565b815161004290600090602085019061004c565b506001555061020e565b828054610058906101d3565b90600052602060002090601f01602090048101928261007a57600085556100c0565b82601f1061009357805160ff19168380011785556100c0565b828001600101855582156100c0579182015b828111156100c05782518255916020019190600101906100a5565b506100cc9291506100d0565b5090565b5b808211156100cc57600081556001016100d1565b634e487b7160e01b600052604160045260246000fd5b6000806040838503121561010e57600080fd5b82516001600160401b038082111561012557600080fd5b818501915085601f83011261013957600080fd5b81518181111561014b5761014b6100e5565b604051601f8201601f19908116603f01168101908382118183101715610173576101736100e5565b8160405282815260209350888484870101111561018f57600080fd5b600091505b828210156101b15784820184015181830185015290830190610194565b828211156101c25760008484830101525b969092015195979596505050505050565b600181811c908216806101e757607f821691505b6020821081141561020857634e487b7160e01b600052602260045260246000fd5b50919050565b61020b8061021d6000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063097ac533146100465780630a59a98c146100615780633c84c5a514610076575b600080fd5b61004e61007f565b6040519081526020015b60405180910390f35b610069610095565b6040516100589190610123565b61004e60015481565b600060646001546100909190610178565b905090565b600080546100a29061019a565b80601f01602080910402602001604051908101604052809291908181526020018280546100ce9061019a565b801561011b5780601f106100f05761010080835404028352916020019161011b565b820191906000526020600020905b8154815290600101906020018083116100fe57829003601f168201915b505050505081565b600060208083528351808285015260005b8181101561015057858101830151858201604001528201610134565b81811115610162576000604083870101525b50601f01601f1916929092016040019392505050565b60008261019557634e487b7160e01b600052601260045260246000fd5b500490565b600181811c908216806101ae57607f821691505b602082108114156101cf57634e487b7160e01b600052602260045260246000fd5b5091905056fea2646970667358221220e24503949cb3cba493080eb0c5b93b740bf1dc950a7ab9d4cd64298f6ffcafe564736f6c63430008090033";

    public static final String FUNC_GETCGPA = "getCGPA";

    public static final String FUNC_MARKS = "marks";

    public static final String FUNC_SUBJECT = "subject";

    @Deprecated
    protected Mark(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Mark(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Mark(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Mark(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> getCGPA() {
        final Function function = new Function(
                FUNC_GETCGPA, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> marks() {
        final Function function = new Function(FUNC_MARKS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> subject() {
        final Function function = new Function(FUNC_SUBJECT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Mark load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Mark(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Mark load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Mark(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Mark load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Mark(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Mark load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Mark(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Mark> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _subject, BigInteger _marks) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_subject), 
                new org.web3j.abi.datatypes.generated.Uint256(_marks)));
        return deployRemoteCall(Mark.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Mark> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _subject, BigInteger _marks) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_subject), 
                new org.web3j.abi.datatypes.generated.Uint256(_marks)));
        return deployRemoteCall(Mark.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Mark> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _subject, BigInteger _marks) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_subject), 
                new org.web3j.abi.datatypes.generated.Uint256(_marks)));
        return deployRemoteCall(Mark.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Mark> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _subject, BigInteger _marks) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_subject), 
                new org.web3j.abi.datatypes.generated.Uint256(_marks)));
        return deployRemoteCall(Mark.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
