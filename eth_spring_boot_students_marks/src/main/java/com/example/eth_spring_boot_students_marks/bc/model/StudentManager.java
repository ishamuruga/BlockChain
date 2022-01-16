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
import org.web3j.tuples.generated.Tuple4;
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
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b03191633179055611858806100326000396000f3fe60806040523480156200001157600080fd5b50600436106200009f5760003560e01c80638f32d59b116200006e5780638f32d59b1462000152578063b2bdfa7b1462000171578063bb9f4bd41462000185578063cb0c7c0c146200019e578063fa249f5014620001b557600080fd5b806306ead22e14620000a45780630e6573b614620000d65780632b03358314620000fc578063642f91631462000122575b600080fd5b620000bb620000b536600462000b00565b620001dc565b604051620000cd949392919062000b91565b60405180910390f35b620000ed620000e736600462000b00565b62000338565b604051620000cd919062000bfb565b620001136200010d36600462000b00565b62000542565b604051620000cd919062000c4a565b620001396200013336600462000b00565b620005e5565b6040516001600160a01b039091168152602001620000cd565b6000546001600160a01b031633146040519015158152602001620000cd565b60005462000139906001600160a01b031681565b6200019c6200019636600462000d37565b62000655565b005b6200019c620001af36600462000d8b565b62000840565b620001cc620001c636600462000e09565b62000904565b604051620000cd92919062000e2c565b600160205260009081526040902080546002820180546001600160a01b0390921692916200020a9062000e50565b80601f0160208091040260200160405190810160405280929190818152602001828054620002389062000e50565b8015620002895780601f106200025d5761010080835404028352916020019162000289565b820191906000526020600020905b8154815290600101906020018083116200026b57829003601f168201915b5050506003840154600485018054949560ff909216949193509150620002af9062000e50565b80601f0160208091040260200160405190810160405280929190818152602001828054620002dd9062000e50565b80156200032e5780601f1062000302576101008083540402835291602001916200032e565b820191906000526020600020905b8154815290600101906020018083116200031057829003601f168201915b5050505050905084565b60607ffbd815649c4d5f4a928ff248d912dbf50e6eb2c6f7da0888194b3aba7037765e60405162000381906020808252600490820152633d3d3d3160e01b604082015260600190565b60405180910390a17ffbd815649c4d5f4a928ff248d912dbf50e6eb2c6f7da0888194b3aba7037765e604051620003d0906020808252600490820152631e9e9e9960e11b604082015260600190565b60405180910390a160005b60008381526001602081905260409091200154811015620004d2577ffbd815649c4d5f4a928ff248d912dbf50e6eb2c6f7da0888194b3aba7037765e60405162000444906020808252600b908201526a3d3d3d3d3d3d3d3d3d3d3d60a81b604082015260600190565b60405180910390a17fa293338bcaa2c2acc2b769026308fca753ce9ad8a85155d41943809bd0f1da6060016000858152602001908152602001600020600101828154811062000497576200049762000e8d565b600091825260209182902001546040516001600160a01b0390911681520160405180910390a180620004c98162000ea3565b915050620003db565b50600082815260016020818152604092839020909101805483518184028101840190945280845290918301828280156200053657602002820191906000526020600020905b81546001600160a01b0316815260019091019060200180831162000517575b50505050509050919050565b6000818152600160205260409020600401805460609190620005649062000e50565b80601f0160208091040260200160405190810160405280929190818152602001828054620005929062000e50565b8015620005365780601f10620005b75761010080835404028352916020019162000536565b820191906000526020600020905b815481529060010190602001808311620005c55750939695505050505050565b60008181526001602090815260408083205481518581526001600160a01b03909116928101929092527f2bc98ce952b75e571693fc9f7f7a2c32eb76b8d3ca8da49a39ae9ddb9d2b4d13910160405180910390a1506000908152600160205260409020546001600160a01b031690565b60008282604051620006679062000a3e565b6200067492919062000e2c565b604051809103906000f08015801562000691573d6000803e3d6000fd5b506000858152600160208181526040808420808401805480860182559086528386200180546001600160a01b0319166001600160a01b0388161790558151808301909252600482526309a8a86960e31b828401908152948a9052929091525192935062000705926002909101919062000a4c565b506000816001600160a01b031663097ac5336040518163ffffffff1660e01b8152600401602060405180830381600087803b1580156200074457600080fd5b505af115801562000759573d6000803e3d6000fd5b505050506040513d601f19601f820116820180604052508101906200077f919062000ecd565b90506032811115620007aa576000858152600160205260409020600301805460ff19169055620007ca565b6000858152600160208190526040909120600301805460ff191690911790555b6000858152600160208190526040909120600301547fbe17da7e4e64be98177252e41c28bbca6920b218f5bd8d04c32de18f7af6509491879160ff169081111562000819576200081962000b7b565b60408051928352602083019190915233908201526060015b60405180910390a15050505050565b6000838383604051620008539062000adb565b620008619392919062000ee7565b604051809103906000f0801580156200087e573d6000803e3d6000fd5b50600086815260016020908152604090912080546001600160a01b0319166001600160a01b0384161781558551929350620008c29260049091019186019062000a4c565b50604080518681526000602082015233918101919091527fbe17da7e4e64be98177252e41c28bbca6920b218f5bd8d04c32de18f7af650949060600162000831565b606060008060016000868152602001908152602001600020600101848154811062000933576200093362000e8d565b6000918252602082200154604080516302966a6360e21b815290516001600160a01b0390921693508392630a59a98c92600480840193829003018186803b1580156200097e57600080fd5b505afa15801562000993573d6000803e3d6000fd5b505050506040513d6000823e601f3d908101601f19168201604052620009bd919081019062000f20565b816001600160a01b0316633c84c5a56040518163ffffffff1660e01b815260040160206040518083038186803b158015620009f757600080fd5b505afa15801562000a0c573d6000803e3d6000fd5b505050506040513d601f19601f8201168201806040525081019062000a32919062000ecd565b92509250509250929050565b6104288062000fa183390190565b82805462000a5a9062000e50565b90600052602060002090601f01602090048101928262000a7e576000855562000ac9565b82601f1062000a9957805160ff191683800117855562000ac9565b8280016001018555821562000ac9579182015b8281111562000ac957825182559160200191906001019062000aac565b5062000ad792915062000ae9565b5090565b61045a80620013c983390190565b5b8082111562000ad7576000815560010162000aea565b60006020828403121562000b1357600080fd5b5035919050565b60005b8381101562000b3757818101518382015260200162000b1d565b8381111562000b47576000848401525b50505050565b6000815180845262000b6781602086016020860162000b1a565b601f01601f19169290920160200192915050565b634e487b7160e01b600052602160045260246000fd5b6001600160a01b038516815260806020820181905260009062000bb79083018662000b4d565b6002851062000bd657634e487b7160e01b600052602160045260246000fd5b846040840152828103606084015262000bf0818562000b4d565b979650505050505050565b6020808252825182820181905260009190848201906040850190845b8181101562000c3e5783516001600160a01b03168352928401929184019160010162000c17565b50909695505050505050565b60208152600062000c5f602083018462000b4d565b9392505050565b634e487b7160e01b600052604160045260246000fd5b604051601f8201601f1916810167ffffffffffffffff8111828210171562000ca85762000ca862000c66565b604052919050565b600067ffffffffffffffff82111562000ccd5762000ccd62000c66565b50601f01601f191660200190565b600082601f83011262000ced57600080fd5b813562000d0462000cfe8262000cb0565b62000c7c565b81815284602083860101111562000d1a57600080fd5b816020850160208301376000918101602001919091529392505050565b60008060006060848603121562000d4d57600080fd5b83359250602084013567ffffffffffffffff81111562000d6c57600080fd5b62000d7a8682870162000cdb565b925050604084013590509250925092565b6000806000806080858703121562000da257600080fd5b8435935060208501359250604085013567ffffffffffffffff8082111562000dc957600080fd5b62000dd78883890162000cdb565b9350606087013591508082111562000dee57600080fd5b5062000dfd8782880162000cdb565b91505092959194509250565b6000806040838503121562000e1d57600080fd5b50508035926020909101359150565b60408152600062000e41604083018562000b4d565b90508260208301529392505050565b600181811c9082168062000e6557607f821691505b6020821081141562000e8757634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052603260045260246000fd5b600060001982141562000ec657634e487b7160e01b600052601160045260246000fd5b5060010190565b60006020828403121562000ee057600080fd5b5051919050565b83815260606020820152600062000f02606083018562000b4d565b828103604084015262000f16818562000b4d565b9695505050505050565b60006020828403121562000f3357600080fd5b815167ffffffffffffffff81111562000f4b57600080fd5b8201601f8101841362000f5d57600080fd5b805162000f6e62000cfe8262000cb0565b81815285602083850101111562000f8457600080fd5b62000f9782602083016020860162000b1a565b9594505050505056fe608060405234801561001057600080fd5b5060405161042838038061042883398101604081905261002f916100fb565b815161004290600090602085019061004c565b506001555061020e565b828054610058906101d3565b90600052602060002090601f01602090048101928261007a57600085556100c0565b82601f1061009357805160ff19168380011785556100c0565b828001600101855582156100c0579182015b828111156100c05782518255916020019190600101906100a5565b506100cc9291506100d0565b5090565b5b808211156100cc57600081556001016100d1565b634e487b7160e01b600052604160045260246000fd5b6000806040838503121561010e57600080fd5b82516001600160401b038082111561012557600080fd5b818501915085601f83011261013957600080fd5b81518181111561014b5761014b6100e5565b604051601f8201601f19908116603f01168101908382118183101715610173576101736100e5565b8160405282815260209350888484870101111561018f57600080fd5b600091505b828210156101b15784820184015181830185015290830190610194565b828211156101c25760008484830101525b969092015195979596505050505050565b600181811c908216806101e757607f821691505b6020821081141561020857634e487b7160e01b600052602260045260246000fd5b50919050565b61020b8061021d6000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c8063097ac533146100465780630a59a98c146100615780633c84c5a514610076575b600080fd5b61004e61007f565b6040519081526020015b60405180910390f35b610069610095565b6040516100589190610123565b61004e60015481565b600060646001546100909190610178565b905090565b600080546100a29061019a565b80601f01602080910402602001604051908101604052809291908181526020018280546100ce9061019a565b801561011b5780601f106100f05761010080835404028352916020019161011b565b820191906000526020600020905b8154815290600101906020018083116100fe57829003601f168201915b505050505081565b600060208083528351808285015260005b8181101561015057858101830151858201604001528201610134565b81811115610162576000604083870101525b50601f01601f1916929092016040019392505050565b60008261019557634e487b7160e01b600052601260045260246000fd5b500490565b600181811c908216806101ae57607f821691505b602082108114156101cf57634e487b7160e01b600052602260045260246000fd5b5091905056fea2646970667358221220e24503949cb3cba493080eb0c5b93b740bf1dc950a7ab9d4cd64298f6ffcafe564736f6c63430008090033608060405234801561001057600080fd5b5060405161045a38038061045a83398101604081905261002f916101bf565b60008390558151610047906001906020850190610064565b50805161005b906002906020840190610064565b50505050610267565b8280546100709061022c565b90600052602060002090601f01602090048101928261009257600085556100d8565b82601f106100ab57805160ff19168380011785556100d8565b828001600101855582156100d8579182015b828111156100d85782518255916020019190600101906100bd565b506100e49291506100e8565b5090565b5b808211156100e457600081556001016100e9565b634e487b7160e01b600052604160045260246000fd5b600082601f83011261012457600080fd5b81516001600160401b038082111561013e5761013e6100fd565b604051601f8301601f19908116603f01168101908282118183101715610166576101666100fd565b8160405283815260209250868385880101111561018257600080fd5b600091505b838210156101a45785820183015181830184015290820190610187565b838211156101b55760008385830101525b9695505050505050565b6000806000606084860312156101d457600080fd5b835160208501519093506001600160401b03808211156101f357600080fd5b6101ff87838801610113565b9350604086015191508082111561021557600080fd5b5061022286828701610113565b9150509250925092565b600181811c9082168061024057607f821691505b6020821081141561026157634e487b7160e01b600052602260045260246000fd5b50919050565b6101e4806102766000396000f3fe608060405234801561001057600080fd5b50600436106100415760003560e01c806306fdde0314610046578063820e93f514610064578063af640d0f1461006c575b600080fd5b61004e610083565b60405161005b919061011e565b60405180910390f35b61004e610111565b61007560005481565b60405190815260200161005b565b6001805461009090610173565b80601f01602080910402602001604051908101604052809291908181526020018280546100bc90610173565b80156101095780601f106100de57610100808354040283529160200191610109565b820191906000526020600020905b8154815290600101906020018083116100ec57829003601f168201915b505050505081565b6002805461009090610173565b600060208083528351808285015260005b8181101561014b5785810183015185820160400152820161012f565b8181111561015d576000604083870101525b50601f01601f1916929092016040019392505050565b600181811c9082168061018757607f821691505b602082108114156101a857634e487b7160e01b600052602260045260246000fd5b5091905056fea264697066735822122076e674d73fbd588dc0e23020862cbe8f4b5dda3e11f553a1a20862f31dbe490364736f6c63430008090033a2646970667358221220bace1d4bb935a7052dda521f11b393f30071d8d75d7851ab8fec8dd02ed89e6464736f6c63430008090033";

    public static final String FUNC__OWNER = "_owner";

    public static final String FUNC_ADDMARKS = "addMarks";

    public static final String FUNC_CREATESTUDENT = "createStudent";

    public static final String FUNC_GETMARK = "getMark";

    public static final String FUNC_GETMARKS = "getMarks";

    public static final String FUNC_GETSTUDENT = "getStudent";

    public static final String FUNC_GETSTUDENTTAG = "getStudentTag";

    public static final String FUNC_ISOWNER = "isOwner";

    public static final String FUNC_STUDENTS = "students";

    public static final Event MARKSEVENT_EVENT = new Event("MarksEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event STUDENTCHAINSTEP_EVENT = new Event("StudentChainStep", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event EVNTSTUDENT_EVENT = new Event("evntStudent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
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

    public List<EvntStudentEventResponse> getEvntStudentEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(EVNTSTUDENT_EVENT, transactionReceipt);
        ArrayList<EvntStudentEventResponse> responses = new ArrayList<EvntStudentEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            EvntStudentEventResponse typedResponse = new EvntStudentEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._idx = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.stu = (String) eventValues.getNonIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<EvntStudentEventResponse> evntStudentEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, EvntStudentEventResponse>() {
            @Override
            public EvntStudentEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(EVNTSTUDENT_EVENT, log);
                EvntStudentEventResponse typedResponse = new EvntStudentEventResponse();
                typedResponse.log = log;
                typedResponse._idx = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.stu = (String) eventValues.getNonIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<EvntStudentEventResponse> evntStudentEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(EVNTSTUDENT_EVENT));
        return evntStudentEventFlowable(filter);
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

    public RemoteFunctionCall<TransactionReceipt> getStudentTag(BigInteger idx) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETSTUDENTTAG, 
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

    public RemoteFunctionCall<Tuple4<String, String, BigInteger, String>> students(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_STUDENTS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint8>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple4<String, String, BigInteger, String>>(function,
                new Callable<Tuple4<String, String, BigInteger, String>>() {
                    @Override
                    public Tuple4<String, String, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, String, BigInteger, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
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

    public static class EvntStudentEventResponse extends BaseEventResponse {
        public BigInteger _idx;

        public String stu;
    }

    public static class LoggerEventResponse extends BaseEventResponse {
        public String data;
    }
}
