package com.company.itemanager.ethitemmanagerrestapi.contracts.itemmanager;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
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
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Item extends Contract {
    public static final String BINARY = "0x608060405234801561001057600080fd5b5060405161077438038061077483398181016040528101906100329190610134565b82600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508160008190555080600281905550505050610187565b600080fd5b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b60006100b98261008e565b9050919050565b60006100cb826100ae565b9050919050565b6100db816100c0565b81146100e657600080fd5b50565b6000815190506100f8816100d2565b92915050565b6000819050919050565b610111816100fe565b811461011c57600080fd5b50565b60008151905061012e81610108565b92915050565b60008060006060848603121561014d5761014c610089565b5b600061015b868287016100e9565b935050602061016c8682870161011f565b925050604061017d8682870161011f565b9150509250925092565b6105de806101966000396000f3fe6080604052600436106100385760003560e01c80632986c0e5146102505780633c8da5881461027b57806389794d00146102a657610241565b3661024157600060015414610082576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161007990610340565b60405180910390fd5b34600054146100c6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016100bd906103ac565b60405180910390fd5b34600160008282546100d89190610405565b925050819055506000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163460025460405160240161012e919061046a565b6040516020818303038152906040527f800fb83f000000000000000000000000000000000000000000000000000000007bffffffffffffffffffffffffffffffffffffffffffffffffffffffff19166020820180517bffffffffffffffffffffffffffffffffffffffffffffffffffffffff83818316178352505050506040516101b891906104ff565b60006040518083038185875af1925050503d80600081146101f5576040519150601f19603f3d011682016040523d82523d6000602084013e6101fa565b606091505b505090508061023e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161023590610588565b60405180910390fd5b50005b34801561024d57600080fd5b50005b34801561025c57600080fd5b506102656102d1565b604051610272919061046a565b60405180910390f35b34801561028757600080fd5b506102906102d7565b60405161029d919061046a565b60405180910390f35b3480156102b257600080fd5b506102bb6102dd565b6040516102c8919061046a565b60405180910390f35b60025481565b60005481565b60015481565b600082825260208201905092915050565b7f4974656d20697320616c72656164792070616964000000000000000000000000600082015250565b600061032a6014836102e3565b9150610335826102f4565b602082019050919050565b600060208201905081810360008301526103598161031d565b9050919050565b7f4f6e6c792046756c6c205061796d656e74732061726520616c6c6f7765640000600082015250565b6000610396601e836102e3565b91506103a182610360565b602082019050919050565b600060208201905081810360008301526103c581610389565b9050919050565b6000819050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b6000610410826103cc565b915061041b836103cc565b9250827fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff038211156104505761044f6103d6565b5b828201905092915050565b610464816103cc565b82525050565b600060208201905061047f600083018461045b565b92915050565b600081519050919050565b600081905092915050565b60005b838110156104b957808201518184015260208101905061049e565b838111156104c8576000848401525b50505050565b60006104d982610485565b6104e38185610490565b93506104f381856020860161049b565b80840191505092915050565b600061050b82846104ce565b915081905092915050565b7f546865205472616e73616374696f6e207761736e27742073756365737366756c60008201527f6c2c2068656e63652063616e63656c6c696e672e2e2e00000000000000000000602082015250565b60006105726036836102e3565b915061057d82610516565b604082019050919050565b600060208201905081810360008301526105a181610565565b905091905056fea26469706673582212205aab4175c80998cb483754fdf1c74ffc8b850ffc9e9154b52ae1b84f9100719164736f6c634300080a0033";

    public static final String FUNC_INDEX = "index";

    public static final String FUNC_PRICEINWEI = "priceInWei";

    public static final String FUNC_PRICEPAID = "pricePaid";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
    }

    @Deprecated
    protected Item(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Item(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Item(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Item(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<BigInteger> index() {
        final Function function = new Function(FUNC_INDEX, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> priceInWei() {
        final Function function = new Function(FUNC_PRICEINWEI, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> pricePaid() {
        final Function function = new Function(FUNC_PRICEPAID, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    @Deprecated
    public static Item load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Item(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Item load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Item(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Item load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Item(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Item load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Item(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Item> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _parentContract, BigInteger _priceInWei, BigInteger _index) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_parentContract), 
                new org.web3j.abi.datatypes.generated.Uint256(_priceInWei), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)));
        return deployRemoteCall(Item.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Item> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _parentContract, BigInteger _priceInWei, BigInteger _index) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_parentContract), 
                new org.web3j.abi.datatypes.generated.Uint256(_priceInWei), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)));
        return deployRemoteCall(Item.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Item> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _parentContract, BigInteger _priceInWei, BigInteger _index) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_parentContract), 
                new org.web3j.abi.datatypes.generated.Uint256(_priceInWei), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)));
        return deployRemoteCall(Item.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Item> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _parentContract, BigInteger _priceInWei, BigInteger _index) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_parentContract), 
                new org.web3j.abi.datatypes.generated.Uint256(_priceInWei), 
                new org.web3j.abi.datatypes.generated.Uint256(_index)));
        return deployRemoteCall(Item.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
