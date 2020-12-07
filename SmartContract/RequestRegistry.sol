// SPDX-License-Identifier:UNLICENSED
pragma solidity 0.7.4;
pragma experimental ABIEncoderV2;

contract RequestRegistry{
    
    address private owner;
    
    struct Request {
        uint256 timestamp;
        string idOperation;
        string specificationType;
        string idlPath;
        string apiSpecificationPath;
        string operationPath;
        string operationType;
        string[] parameters;
        string[] values;
        string result;
    }
    
    uint256 counter;
    mapping(uint256 => Request) public requests;
     
    // Event for EVM
    event OwnerSet(address indexed oldOwner, address indexed newOwner);
    
    event requestRegistered(
        uint256 timestamp,
        string idOperation,
        string specificationType,
        string idlPath,
        string apiSpecificationPath,
        string operationPath,
        string operationType,
        string[] parameters,
        string[] values,
        string result
        );
    
    // Modifier
    modifier onlyOwner(){
        require(msg.sender == owner, "Only the owner can do this action");
        _;
    }
    
    /*Constructor (only run once when deployed)*/
    constructor(){
        owner = msg.sender; // 'msg.sender' is sender of current call, contract deployer for a constructor
        counter = 0;
        emit OwnerSet(address(0), owner);
    }
   
   function changeOwner(address newOwner) public onlyOwner {
        emit OwnerSet(owner, newOwner);
        owner = newOwner;
    }
    
    function registerRequest(string memory idOperation,
                            string memory specificationType,
                            string memory idlPath,
                            string memory apiSpecificationPath,
                            string memory operationPath,
                            string memory operationType,
                            string[] memory parameters,
                            string[] memory values,
                            string memory result) public onlyOwner{
        validateRequest(idOperation, specificationType, idlPath, apiSpecificationPath, operationPath, operationType, parameters, values, result);
        requests[counter] = Request(block.timestamp, idOperation, specificationType, idlPath, apiSpecificationPath, operationPath, operationType, parameters, values, result);
        counter++;
        emit requestRegistered(block.timestamp, idOperation, specificationType, idlPath, apiSpecificationPath, operationPath, operationType, parameters, values, result);
    }
    
    
    function validateRequest(string memory idOperation,
                            string memory specificationType,
                            string memory idlPath,
                            string memory apiSpecificationPath,
                            string memory operationPath,
                            string memory operationType,
                            string[] memory parameters,
                            string[] memory values,
                            string memory result) private pure{
                                
        if(bytes(idOperation).length == 0 || bytes(specificationType).length == 0 || bytes(idlPath).length == 0 || 
           bytes(apiSpecificationPath).length == 0 || bytes(operationPath).length == 0 || bytes(operationType).length == 0 ||
           parameters.length != values.length || bytes(result).length == 0) {
                
            revert("Invalid request");
        }
                                
    }
    
    function getCounter() public view returns (uint256){
        return counter;
    }
  
  
}
