package com.example.eth_spring_boot_students_marks.bc.model;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
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
public class StudentManager extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b03191633179055611641806100326000396000f3fe60806040523480156200001157600080fd5b5060043610620000935760003560e01c8063b2bdfa7b1162000062578063b2bdfa7b1462000153578063bb9f4bd41462000167578063cb0c7c0c1462000180578063fa249f50146200019757600080fd5b806306ead22e14620000985780630e6573b614620000c9578063642f916314620000ef5780638f32d59b1462000134575b600080fd5b620000af620000a93660046200091a565b620001be565b604051620000c093929190620009ab565b60405180910390f35b620000e0620000da3660046200091a565b6200027e565b604051620000c0919062000a00565b6200011b620001003660046200091a565b6000908152600160205260409020546001600160a01b031690565b6040516001600160a01b039091168152602001620000c0565b6000546001600160a01b031633146040519015158152602001620000c0565b6000546200011b906001600160a01b031681565b6200017e6200017836600462000b20565b62000488565b005b6200017e6200019136600462000b74565b62000673565b620001ae620001a836600462000bf2565b6200071e565b604051620000c092919062000c15565b600160205260009081526040902080546002820180546001600160a01b039092169291620001ec9062000c39565b80601f01602080910402602001604051908101604052809291908181526020018280546200021a9062000c39565b80156200026b5780601f106200023f576101008083540402835291602001916200026b565b820191906000526020600020905b8154815290600101906020018083116200024d57829003601f168201915b5050506003909301549192505060ff1683565b60607ffbd815649c4d5f4a928ff248d912dbf50e6eb2c6f7da0888194b3aba7037765e604051620002c7906020808252600490820152633d3d3d3160e01b604082015260600190565b60405180910390a17ffbd815649c4d5f4a928ff248d912dbf50e6eb2c6f7da0888194b3aba7037765e60405162000316906020808252600490820152631e9e9e9960e11b604082015260600190565b60405180910390a160005b6000838152600160208190526040909120015481101562000418577ffbd815649c4d5f4a928ff248d912dbf50e6eb2c6f7da0888194b3aba7037765e6040516200038a906020808252600b908201526a3d3d3d3d3d3d3d3d3d3d3d60a81b604082015260600190565b60405180910390a17fa293338bcaa2c2acc2b769026308fca753ce9ad8a85155d41943809bd0f1da60600160008581526020019081526020016000206001018281548110620003dd57620003dd62000c76565b600091825260209182902001546040516001600160a01b0390911681520160405180910390a1806200040f8162000c8c565b91505062000321565b50600082815260016020818152604092839020909101805483518184028101840190945280845290918301828280156200047c57602002820191906000526020600020905b81546001600160a01b031681526001909101906020018083116200045d575b50505050509050919050565b600082826040516200049a9062000858565b620004a792919062000c15565b604051809103906000f080158015620004c4573d6000803e3d6000fd5b506000858152600160208181526040808420808401805480860182559086528386200180546001600160a01b0319166001600160a01b0388161790558151808301909252600482526309a8a86960e31b828401908152948a9052929091525192935062000538926002909101919062000866565b506000816001600160a01b031663097ac5336040518163ffffffff1660e01b8152600401602060405180830381600087803b1580156200057757600080fd5b505af11580156200058c573d6000803e3d6000fd5b505050506040513d601f19601f82011682018060405250810190620005b2919062000cb6565b90506032811115620005dd576000858152600160205260409020600301805460ff19169055620005fd565b6000858152600160208190526040909120600301805460ff191690911790555b6000858152600160208190526040909120600301547fbe17da7e4e64be98177252e41c28bbca6920b218f5bd8d04c32de18f7af6509491879160ff16908111156200064c576200064c62000995565b60408051928352602083019190915233908201526060015b60405180910390a15050505050565b60008383836040516200068690620008f5565b620006949392919062000cd0565b604051809103906000f080158015620006b1573d6000803e3d6000fd5b50600086815260016020908152604080832080546001600160a01b0319166001600160a01b03861617905580518981529182019290925233918101919091529091507fbe17da7e4e64be98177252e41c28bbca6920b218f5bd8d04c32de18f7af650949060600162000664565b60606000806001600086815260200190815260200160002060010184815481106200074d576200074d62000c76565b6000918252602082200154604080516302966a6360e21b815290516001600160a01b0390921693508392630a59a98c92600480840193829003018186803b1580156200079857600080fd5b505afa158015620007ad573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f19168201604052620007d7919081019062000d09565b816001600160a01b0316633c84c5a56040518163ffffffff1660e01b815260040160206040518083038186803b1580156200081157600080fd5b505afa15801562000826573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906200084c919062000cb6565b92509250509250929050565b6104288062000d8a83390190565b828054620008749062000c39565b90600052602060002090601f016020900481019282620008985760008555620008e3565b82601f10620008b357805160ff1916838001178555620008e3565b82800160010185558215620008e3579182015b82811115620008e3578251825591602001919060010190620008c6565b50620008f192915062000903565b5090565b61045a80620011b283390190565b5b80821115620008f1576000815560010162000904565b6000602082840312156200092d57600080fd5b5035919050565b60005b838110156200095157818101518382015260200162000937565b8381111562000961576000848401525b50505050565b600081518084526200098181602086016020860162000934565b601f01601f19169290920160200192915050565b634e487b7160e01b600052602160045260246000fd5b6001600160a01b0384168152606060208201819052600090620009d19083018562000967565b905060028310620009f257634e487b7160e01b600052602160045260246000fd5b826040830152949350505050565b6020808252825182820181905260009190848201906040850190845b8181101562000a435783516001600160a01b03168352928401929184019160010162000a1c565b50909695505050505050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff8111828210171562000a915762000a9162000a4f565b604052919050565b600067ffffffffffffffff82111562000ab65762000ab662000a4f565b50601f01601f191660200190565b600082601f83011262000ad657600080fd5b813562000aed62000ae78262000a99565b62000a65565b81815284602083860101111562000b0357600080fd5b816020850160208301376000918101602001919091529392505050565b60008060006060848603121562000b3657600080fd5b83359250602084013567ffffffffffffffff81111562000b5557600080fd5b62000b638682870162000ac4565b925050604084013590509250925092565b6000806000806080858703121562000b8b57600080fd5b8435935060208501359250604085013567ffffffffffffffff8082111562000bb257600080fd5b62000bc08883890162000ac4565b9350606087013591508082111562000bd757600080fd5b5062000be68782880162000ac4565b91505092959194509250565b6000806040838503121562000c0657600080fd5b50508035926020909101359150565b60408152600062000c2a604083018562000967565b90508260208301529392505050565b600181811c9082168062000c4e57607f821691505b6020821081141562000c7057634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052603260045260246000fd5b600060001982141562000caf57634e487b7160e01b600052601160045260246000fd5b5060010190565b60006020828403121562000cc957600080fd5b5051919050565b83815260606020820152600062000ceb606083018562000967565b828103604084015262000cff818562000967565b9695505050505050565b60006020828403121562000d1c57600080fd5b815167ffffffffffffffff81111562000d3457600080fd5b8201601f8101841362000d4657600080fd5b805162000d5762000ae78262000a99565b81815285602083850101111562000d6d57600080fd5b62000d8082602083016020860162000934565b9594505050505056fe608060405234801561001057600080fd5b5060405161042838038061042883398101604081905261002f916100fb565b815161004290600090602085019061004c565b506001555061020e565b828054610058906101d3565b90600052602060002090601f01602090048101928261007a57600085556100c0565b82601f1061009357805160ff19168380011785556100c0565b828001600101855582156100c0579182015b828111156100c05782518255916020019190600101906100a5565b506100cc9291506100d0565b5090565b5b808211156100cc57600081556001016100d1565b634e487b7160e01b600052604160045260246000fd5b6000806040838503121561010e57600080fd5b82516001600160401b038082111561012557600080fd5b818501915085601f83011261013957600080fd5b81518181111561014b5761014b6100e5565b604051601f8201601f19908116603f01168101908382118183101715610173576101736100e5565b8160405282815260209350888484870101111561018f57600080fd5b600091505b828210156101b15784820184015181830185015290830190610194565b828211156101c25760008484830101525b969092015195979596505050505050565b600181811c908216806101e757607f821691505b6020821081141561020857634e487b7160e01b600052602260045260246000fd5b50919050565b61020b8061021d6000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063097ac533146100465780630a59a98c146100615780633c84c5a514610076575b600080fd5b61004e61007f565b6040519081526020015b60405180910390f35b610069610095565b6040516100589190610123565b61004e60015481565b600060646001546100909190610178565b905090565b600080546100a29061019a565b80601f01602080910402602001604051908101604052809291908181526020018280546100ce9061019a565b801561011b5780601f106100f05761010080835404028352916020019161011b565b820191906000526020600020905b8154815290600101906020018083116100fe57829003601f168201915b505050505081565b600060208083528351808285015260005b8181101561015057858101830151858201604001528201610134565b81811115610162576000604083870101525b50601f01601f1916929092016040019392505050565b60008261019557634e487b7160e01b600052601260045260246000fd5b500490565b600181811c908216806101ae57607f821691505b602082108114156101cf57634e487b7160e01b600052602260045260246000fd5b5091905056fea2646970667358221220e24503949cb3cba493080eb0c5b93b740bf1dc950a7ab9d4cd64298f6ffcafe564736f6c63430008090033608060405234801561001057600080fd5b5060405161045a38038061045a83398101604081905261002f916101bf565b60008390558151610047906001906020850190610064565b50805161005b906002906020840190610064565b50505050610267565b8280546100709061022c565b90600052602060002090601f01602090048101928261009257600085556100d8565b82601f106100ab57805160ff19168380011785556100d8565b828001600101855582156100d8579182015b828111156100d85782518255916020019190600101906100bd565b506100e49291506100e8565b5090565b5b808211156100e457600081556001016100e9565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261012457600080fd5b81516001600160401b038082111561013e5761013e6100fd565b604051601f8301601f19908116603f01168101908282118183101715610166576101666100fd565b8160405283815260209250868385880101111561018257600080fd5b600091505b838210156101a45785820183015181830184015290820190610187565b838211156101b55760008385830101525b9695505050505050565b6000806000606084860312156101d457600080fd5b835160208501519093506001600160401b03808211156101f357600080fd5b6101ff87838801610113565b9350604086015191508082111561021557600080fd5b5061022286828701610113565b9150509250925092565b600181811c9082168061024057607f821691505b6020821081141561026157634e487b7160e01b600052602260045260246000fd5b50919050565b6101e4806102766000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806306fdde0314610046578063820e93f514610064578063af640d0f1461006c575b600080fd5b61004e610083565b60405161005b919061011e565b60405180910390f35b61004e610111565b61007560005481565b60405190815260200161005b565b6001805461009090610173565b80601f01602080910402602001604051908101604052809291908181526020018280546100bc90610173565b80156101095780601f106100de57610100808354040283529160200191610109565b820191906000526020600020905b8154815290600101906020018083116100ec57829003601f168201915b505050505081565b6002805461009090610173565b600060208083528351808285015260005b8181101561014b5785810183015185820160400152820161012f565b8181111561015d576000604083870101525b50601f01601f1916929092016040019392505050565b600181811c9082168061018757607f821691505b602082108114156101a857634e487b7160e01b600052602260045260246000fd5b5091905056fea264697066735822122076e674d73fbd588dc0e23020862cbe8f4b5dda3e11f553a1a20862f31dbe490364736f6c63430008090033a264697066735822122097e2745f6a67bbb14df09158884136f25a559c0c3d6f42c1385d7ac8bc11acdf64736f6c63430008090033";

    public static final String FUNC__OWNER = "_owner";

    public static final String FUNC_ADDMARKS = "addMarks";

    public static final String FUNC_CREATESTUDENT = "createStudent";

    public static final String FUNC_GETMARK = "getMark";

    public static final String FUNC_GETMARKS = "getMarks";

    public static final String FUNC_GETSTUDENT = "getStudent";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_STUDENTS = "students";

    public static final Event MARKSEVENT_EVENT = new Event("MarksEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event STUDENTCHAINSTEP_EVENT = new Event("StudentChainStep", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event LOGGER_EVENT = new Event("logger", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected StudentManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected StudentManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected StudentManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected StudentManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<MarksEventEventResponse> getMarksEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(MARKSEVENT_EVENT, transactionReceipt);
        ArrayList<MarksEventEventResponse> responses = new ArrayList<MarksEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            MarksEventEventResponse typedResponse = new MarksEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.mrk = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<MarksEventEventResponse> marksEventEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, MarksEventEventResponse>() {
            @Override
            public MarksEventEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(MARKSEVENT_EVENT, log);
                MarksEventEventResponse typedResponse = new MarksEventEventResponse();
                typedResponse.log = log;
                typedResponse.mrk = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<MarksEventEventResponse> marksEventEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(MARKSEVENT_EVENT));
        return marksEventEventFlowable(filter);
    }

    public List<StudentChainStepEventResponse> getStudentChainStepEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(STUDENTCHAINSTEP_EVENT, transactionReceipt);
        ArrayList<StudentChainStepEventResponse> responses = new ArrayList<StudentChainStepEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            StudentChainStepEventResponse typedResponse = new StudentChainStepEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._itemIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse._grade = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse._stuAddress = (String) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<StudentChainStepEventResponse> studentChainStepEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, StudentChainStepEventResponse>() {
            @Override
            public StudentChainStepEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(STUDENTCHAINSTEP_EVENT, log);
                StudentChainStepEventResponse typedResponse = new StudentChainStepEventResponse();
                typedResponse.log = log;
                typedResponse._itemIndex = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse._grade = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse._stuAddress = (String) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<StudentChainStepEventResponse> studentChainStepEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(STUDENTCHAINSTEP_EVENT));
        return studentChainStepEventFlowable(filter);
    }

    public List<LoggerEventResponse> getLoggerEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOGGER_EVENT, transactionReceipt);
        ArrayList<LoggerEventResponse> responses = new ArrayList<LoggerEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LoggerEventResponse typedResponse = new LoggerEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.data = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<LoggerEventResponse> loggerEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, LoggerEventResponse>() {
            @Override
            public LoggerEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOGGER_EVENT, log);
                LoggerEventResponse typedResponse = new LoggerEventResponse();
                typedResponse.log = log;
                typedResponse.data = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<LoggerEventResponse> loggerEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOGGER_EVENT));
        return loggerEventFlowable(filter);
    }

    public RemoteFunctionCall<String> _owner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC__OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> addMarks(BigInteger stuIndex, String subject, BigInteger score) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_ADDMARKS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(stuIndex), 
                new org.web3j.abi.datatypes.Utf8String(subject), 
                new org.web3j.abi.datatypes.generated.Uint256(score)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> createStudent(BigInteger stuIndex, BigInteger id, String name, String email) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CREATESTUDENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(stuIndex), 
                new org.web3j.abi.datatypes.generated.Uint256(id), 
                new org.web3j.abi.datatypes.Utf8String(name), 
                new org.web3j.abi.datatypes.Utf8String(email)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> getMark(BigInteger idx, BigInteger midx) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETMARK, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(idx), 
                new org.web3j.abi.datatypes.generated.Uint256(midx)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> getMarks(BigInteger idx) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETMARKS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(idx)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> getStudent(BigInteger idx) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETSTUDENT, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(idx)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Boolean> isOwner() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ISOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteFunctionCall<Tuple3<String, String, BigInteger>> students(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_STUDENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, BigInteger>>(function,
                new Callable<Tuple3<String, String, BigInteger>>() {
                    @Override
                    public Tuple3<String, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    @Deprecated
    public static StudentManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new StudentManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static StudentManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new StudentManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static StudentManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new StudentManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static StudentManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new StudentManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<StudentManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StudentManager.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StudentManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StudentManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<StudentManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(StudentManager.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<StudentManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(StudentManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class MarksEventEventResponse extends BaseEventResponse {
        public String mrk;
    }

    public static class StudentChainStepEventResponse extends BaseEventResponse {
        public BigInteger _itemIndex;

        public BigInteger _grade;

        public String _stuAddress;
    }

    public static class LoggerEventResponse extends BaseEventResponse {
        public String data;
    }
}
