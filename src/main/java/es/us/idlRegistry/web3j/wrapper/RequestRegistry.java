package es.us.idlRegistry.web3j.wrapper;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.*;
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
import org.web3j.tuples.generated.Tuple8;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.7.0.
 */
@SuppressWarnings("rawtypes")
public class RequestRegistry extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50600080546001600160a01b031916331780825560018290556040516001600160a01b039190911691907f342827c97908e5e2f71151c08502a66d44b6f758e3ac2f1de95f02eb95f0a735908290a3610e828061006e6000396000f3fe608060405234801561001057600080fd5b506004361061004c5760003560e01c80632cfc7ebf1461005157806381d12c58146100665780638ada066e14610096578063a6f9dae1146100ab575b600080fd5b61006461005f366004610a33565b6100be565b005b610079610074366004610b8e565b6102c5565b60405161008d989796959493929190610d87565b60405180910390f35b61009e6106cc565b60405161008d9190610cb1565b6100646100b9366004610a05565b6106d2565b6000546001600160a01b031633146100f15760405162461bcd60e51b81526004016100e890610c70565b60405180910390fd5b610102898989898989898989610757565b6040518061014001604052804281526020018a8152602001898152602001888152602001878152602001868152602001858152602001848152602001838152602001828152506002600060015481526020019081526020016000206000820151816000015560208201518160010190805190602001906101839291906107cb565b506040820151805161019f9160028401916020909101906107cb565b50606082015180516101bb9160038401916020909101906107cb565b50608082015180516101d79160048401916020909101906107cb565b5060a082015180516101f39160058401916020909101906107cb565b5060c0820151805161020f9160068401916020909101906107cb565b5060e0820151805161022b916007840191602090910190610857565b506101008201518051610248916008840191602090910190610857565b5061012082015180516102659160098401916020909101906107cb565b50506001805481019055506040517fc8941016af29a202dc80f48d41134fde0f7eb9a1142a21eb8f12269b9db88503906102b29042908c908c908c908c908c908c908c908c908c90610cba565b60405180910390a1505050505050505050565b60026020818152600092835260409283902080546001808301805487519281161561010002600019011695909504601f81018590048502820185019096528581529094919390929091908301828280156103605780601f1061033557610100808354040283529160200191610360565b820191906000526020600020905b81548152906001019060200180831161034357829003601f168201915b50505060028085018054604080516020601f60001961010060018716150201909416959095049283018590048502810185019091528181529596959450909250908301828280156103f25780601f106103c7576101008083540402835291602001916103f2565b820191906000526020600020905b8154815290600101906020018083116103d557829003601f168201915b5050505060038301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156104825780601f1061045757610100808354040283529160200191610482565b820191906000526020600020905b81548152906001019060200180831161046557829003601f168201915b5050505060048301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156105125780601f106104e757610100808354040283529160200191610512565b820191906000526020600020905b8154815290600101906020018083116104f557829003601f168201915b5050505060058301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156105a25780601f10610577576101008083540402835291602001916105a2565b820191906000526020600020905b81548152906001019060200180831161058557829003601f168201915b5050505060068301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156106325780601f1061060757610100808354040283529160200191610632565b820191906000526020600020905b81548152906001019060200180831161061557829003601f168201915b5050505060098301805460408051602060026001851615610100026000190190941693909304601f81018490048402820184019092528181529495949350908301828280156106c25780601f10610697576101008083540402835291602001916106c2565b820191906000526020600020905b8154815290600101906020018083116106a557829003601f168201915b5050505050905088565b60015490565b6000546001600160a01b031633146106fc5760405162461bcd60e51b81526004016100e890610c70565b600080546040516001600160a01b03808516939216917f342827c97908e5e2f71151c08502a66d44b6f758e3ac2f1de95f02eb95f0a73591a3600080546001600160a01b0319166001600160a01b0392909216919091179055565b8851158061076457508751155b8061076e57508651155b8061077857508551155b8061078257508451155b8061078c57508351155b8061079957508151835114155b806107a357508051155b156107c05760405162461bcd60e51b81526004016100e890610c47565b505050505050505050565b828054600181600116156101000203166002900490600052602060002090601f0160209004810192826108015760008555610847565b82601f1061081a57805160ff1916838001178555610847565b82800160010185558215610847579182015b8281111561084757825182559160200191906001019061082c565b506108539291506108b0565b5090565b8280548282559060005260206000209081019282156108a4579160200282015b828111156108a457825180516108949184916020909101906107cb565b5091602001919060010190610877565b506108539291506108c5565b5b8082111561085357600081556001016108b1565b808211156108535760006108d982826108e2565b506001016108c5565b50805460018160011615610100020316600290046000825580601f106109085750610926565b601f01602090049060005260206000209081019061092691906108b0565b50565b600082601f830112610939578081fd5b813567ffffffffffffffff81111561094d57fe5b602061095c8182840201610e28565b828152925080830184820160005b8481101561099357610981888584358a010161099e565b8352918301919083019060010161096a565b505050505092915050565b600082601f8301126109ae578081fd5b813567ffffffffffffffff8111156109c257fe5b6109d5601f8201601f1916602001610e28565b91508082528360208285010111156109ec57600080fd5b8060208401602084013760009082016020015292915050565b600060208284031215610a16578081fd5b81356001600160a01b0381168114610a2c578182fd5b9392505050565b60008060008060008060008060006101208a8c031215610a51578485fd5b893567ffffffffffffffff80821115610a68578687fd5b610a748d838e0161099e565b9a5060208c0135915080821115610a89578687fd5b610a958d838e0161099e565b995060408c0135915080821115610aaa578687fd5b610ab68d838e0161099e565b985060608c0135915080821115610acb578687fd5b610ad78d838e0161099e565b975060808c0135915080821115610aec578687fd5b610af88d838e0161099e565b965060a08c0135915080821115610b0d578586fd5b610b198d838e0161099e565b955060c08c0135915080821115610b2e578485fd5b610b3a8d838e01610929565b945060e08c0135915080821115610b4f578384fd5b610b5b8d838e01610929565b93506101008c0135915080821115610b71578283fd5b50610b7e8c828d0161099e565b9150509295985092959850929598565b600060208284031215610b9f578081fd5b5035919050565b60008282518085526020808601955080818302840101818601855b84811015610bef57601f19868403018952610bdd838351610bfc565b98840198925090830190600101610bc1565b5090979650505050505050565b60008151808452815b81811015610c2157602081850181015186830182015201610c05565b81811115610c325782602083870101525b50601f01601f19169290920160200192915050565b6020808252600f908201526e125b9d985b1a59081c995c5d595cdd608a1b604082015260600190565b60208082526021908201527f4f6e6c7920746865206f776e65722063616e20646f207468697320616374696f6040820152603760f91b606082015260800190565b90815260200190565b60006101408c8352806020840152610cd48184018d610bfc565b90508281036040840152610ce8818c610bfc565b90508281036060840152610cfc818b610bfc565b90508281036080840152610d10818a610bfc565b905082810360a0840152610d248189610bfc565b905082810360c0840152610d388188610bfc565b905082810360e0840152610d4c8187610ba6565b9050828103610100840152610d618186610ba6565b9050828103610120840152610d768185610bfc565b9d9c50505050505050505050505050565b60006101008a8352806020840152610da18184018b610bfc565b90508281036040840152610db5818a610bfc565b90508281036060840152610dc98189610bfc565b90508281036080840152610ddd8188610bfc565b905082810360a0840152610df18187610bfc565b905082810360c0840152610e058186610bfc565b905082810360e0840152610e198185610bfc565b9b9a5050505050505050505050565b60405181810167ffffffffffffffff81118282101715610e4457fe5b60405291905056fea26469706673582212208e56402a9256f5e7690983fc6b99baa2015a30b3daa2d98f530089269e31860e64736f6c63430007040033";

    public static final String FUNC_CHANGEOWNER = "changeOwner";

    public static final String FUNC_GETCOUNTER = "getCounter";

    public static final String FUNC_REGISTERREQUEST = "registerRequest";

    public static final String FUNC_REQUESTS = "requests";

    public static final Event OWNERSET_EVENT = new Event("OwnerSet", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    public static final Event REQUESTREGISTERED_EVENT = new Event("requestRegistered", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<DynamicArray<Utf8String>>() {}, new TypeReference<DynamicArray<Utf8String>>() {}, new TypeReference<Utf8String>() {}));
    ;

    @Deprecated
    protected RequestRegistry(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RequestRegistry(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RequestRegistry(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RequestRegistry(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<OwnerSetEventResponse> getOwnerSetEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(OWNERSET_EVENT, transactionReceipt);
        ArrayList<OwnerSetEventResponse> responses = new ArrayList<OwnerSetEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            OwnerSetEventResponse typedResponse = new OwnerSetEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.oldOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnerSetEventResponse> ownerSetEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnerSetEventResponse>() {
            @Override
            public OwnerSetEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(OWNERSET_EVENT, log);
                OwnerSetEventResponse typedResponse = new OwnerSetEventResponse();
                typedResponse.log = log;
                typedResponse.oldOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnerSetEventResponse> ownerSetEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSET_EVENT));
        return ownerSetEventFlowable(filter);
    }

    public List<RequestRegisteredEventResponse> getRequestRegisteredEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(REQUESTREGISTERED_EVENT, transactionReceipt);
        ArrayList<RequestRegisteredEventResponse> responses = new ArrayList<RequestRegisteredEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            RequestRegisteredEventResponse typedResponse = new RequestRegisteredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.idOperation = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.specificationType = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.idlPath = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.apiSpecificationPath = (String) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.operationPath = (String) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.operationType = (String) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.parameters = (List<String>) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.values = (List<String>) eventValues.getNonIndexedValues().get(8).getValue();
            typedResponse.result = (String) eventValues.getNonIndexedValues().get(9).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<RequestRegisteredEventResponse> requestRegisteredEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, RequestRegisteredEventResponse>() {
            @Override
            public RequestRegisteredEventResponse apply(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(REQUESTREGISTERED_EVENT, log);
                RequestRegisteredEventResponse typedResponse = new RequestRegisteredEventResponse();
                typedResponse.log = log;
                typedResponse.timestamp = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.idOperation = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.specificationType = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.idlPath = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.apiSpecificationPath = (String) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.operationPath = (String) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.operationType = (String) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.parameters = (List<String>) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.values = (List<String>) eventValues.getNonIndexedValues().get(8).getValue();
                typedResponse.result = (String) eventValues.getNonIndexedValues().get(9).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<RequestRegisteredEventResponse> requestRegisteredEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(REQUESTREGISTERED_EVENT));
        return requestRegisteredEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> changeOwner(String newOwner) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CHANGEOWNER, 
                Arrays.<Type>asList(new Address(160, newOwner)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getCounter() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETCOUNTER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> registerRequest(String idOperation, String specificationType, String idlPath, String apiSpecificationPath, String operationPath, String operationType, List<String> parameters, List<String> values, String result) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_REGISTERREQUEST, 
                Arrays.<Type>asList(new Utf8String(idOperation),
                new Utf8String(specificationType),
                new Utf8String(idlPath),
                new Utf8String(apiSpecificationPath),
                new Utf8String(operationPath),
                new Utf8String(operationType),
                new DynamicArray<Utf8String>(
                        Utf8String.class,
                        org.web3j.abi.Utils.typeMap(parameters, Utf8String.class)),
                new DynamicArray<Utf8String>(
                        Utf8String.class,
                        org.web3j.abi.Utils.typeMap(values, Utf8String.class)),
                new Utf8String(result)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple8<BigInteger, String, String, String, String, String, String, String>> requests(BigInteger param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_REQUESTS, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple8<BigInteger, String, String, String, String, String, String, String>>(function,
                new Callable<Tuple8<BigInteger, String, String, String, String, String, String, String>>() {
                    @Override
                    public Tuple8<BigInteger, String, String, String, String, String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple8<BigInteger, String, String, String, String, String, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue(), 
                                (String) results.get(3).getValue(), 
                                (String) results.get(4).getValue(), 
                                (String) results.get(5).getValue(), 
                                (String) results.get(6).getValue(), 
                                (String) results.get(7).getValue());
                    }
                });
    }

    @Deprecated
    public static RequestRegistry load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RequestRegistry(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RequestRegistry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RequestRegistry(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RequestRegistry load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RequestRegistry(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RequestRegistry load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RequestRegistry(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RequestRegistry> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RequestRegistry.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<RequestRegistry> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RequestRegistry.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RequestRegistry> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RequestRegistry.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RequestRegistry> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RequestRegistry.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OwnerSetEventResponse extends BaseEventResponse {
        public String oldOwner;

        public String newOwner;
    }

    public static class RequestRegisteredEventResponse extends BaseEventResponse {
        public BigInteger timestamp;

        public String idOperation;

        public String specificationType;

        public String idlPath;

        public String apiSpecificationPath;

        public String operationPath;

        public String operationType;

        public List<String> parameters;

        public List<String> values;

        public String result;
    }
}
