package es.us.idlRegistry.web3j;

import es.us.idlRegistry.web3j.util.Constants;
import es.us.idlRegistry.web3j.util.RequestEntity;
import es.us.idlRegistry.web3j.wrapper.RequestRegistry;
import es.us.isa.idlreasoner.analyzer.Analyzer;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.exceptions.TransactionException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static es.us.idlRegistry.web3j.util.PropertyManager.readWeb3jProperty;
import static es.us.idlRegistry.web3j.util.Web3jConfiguration.initConfigurationFile;

public class SmartContractIntegrator {

    private static final Logger log = LoggerFactory.getLogger(SmartContractIntegrator.class);

    //Configuration
    private final String pass;
    private final String source;
    private final String network;
    private final String account_address;
    private final String smartContract_address;

    //SmartContract
    private RequestRegistry smartContract;

    public SmartContractIntegrator() {
        //Create configuration file if does not exist
        initConfigurationFile();
        this.pass = readWeb3jProperty("password");
        this.source = readWeb3jProperty("source");
        this.network = readWeb3jProperty("network");
        this.account_address = readWeb3jProperty("account.address");
        this.smartContract_address = readWeb3jProperty("smartContract.address");
        integrate();
    }

    private void integrate() {
        try {
            // We start by creating a new web3j instance to connect to remote nodes on the
            // network.
            Web3j web3j = Web3j.build(new HttpService(network));
            log.info("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());
            Credentials credentials = WalletUtils.loadCredentials(pass, source);
            log.info("Credentials loaded");
            ContractGasProvider contractGasProvider = new DefaultGasProvider();
            if (StringUtils.isNotBlank(smartContract_address)) {
                log.info("Loading Smart Contract... " + smartContract_address);
                smartContract = RequestRegistry.load(smartContract_address, web3j, credentials, contractGasProvider);
                log.info("SmartContract loaded");
            } else {
                requestEther(web3j, credentials);
                log.info("Deploying Smart Contract...");
                smartContract = RequestRegistry.deploy(web3j, credentials, contractGasProvider).send();
                String contractAddress = smartContract.getContractAddress();
                log.info("Smart contract deployed to address " + contractAddress);
                log.info("View contract at https://rinkeby.etherscan.io/address/" + contractAddress);
            }

        } catch (IOException e) {
            log.error("Error while trying to create a new web3j instance to connect to remote nodes", e);
        } catch (CipherException e) {
            log.error("Error while loading wallet's credentials", e);
        } catch (InterruptedException e) {
            log.error("Error while requesting some Ether for the Rinkeby test network at https://www.rinkeby.io/#faucet", e);
        } catch (TransactionException e) {
            log.error("Error while requesting some Ether for the Rinkeby test network at https://www.rinkeby.io/#faucet", e);
        } catch (Exception e) {
            log.error("Unexpected error integrating with the SmartContract via Web3j");
        }
    }

    /**
     * Request some Ether for the Rinkeby test network at https://www.rinkeby.io/#faucet
     * @param web3j
     * @param credentials
     * @throws Exception
     */
    private void requestEther(Web3j web3j, Credentials credentials) throws Exception{
        log.info("Sending 1 Wei ("
                + Convert.fromWei("1", Convert.Unit.ETHER).toPlainString() + " Ether)");
        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j, credentials,
                account_address,  // you can put any address here
                BigDecimal.ONE, Convert.Unit.WEI)  // 1 wei = 10^-18 Ether
                .send();
        log.info("Transaction complete, view it at https://rinkeby.etherscan.io/tx/" + transferReceipt.getTransactionHash());
    }

    /**
     * Call IDLReasoner and register request and result on the deployed Smart Contract (Blockchain)
     * @param req - Request
     */
    public boolean register(RequestEntity req){
        boolean res = false;
        try{

            Analyzer analyzer = new Analyzer(req.getSpecificationType(), req.getIdlPath(), req.getApiSpecificationPath(), req.getOperationPath(), req.getOperationType());
            res = analyzer.isValidRequest(req.getRequest());
            req.setResult(Boolean.toString(res));
            List<String> params = new ArrayList<>(req.getRequest().keySet());
            List<String> values = new ArrayList<>(req.getRequest().values());
            TransactionReceipt transferReceipt = smartContract.registerRequest(Constants.REQUEST_IS_VALID, req.getSpecificationType(), req.getIdlPath(), req.getApiSpecificationPath(), req.getOperationPath(), req.getOperationType(), params, values, req.getResult()).send();
            log.info("Transaction complete, view it at https://rinkeby.etherscan.io/tx/" + transferReceipt.getTransactionHash());
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return res;
    }

}
