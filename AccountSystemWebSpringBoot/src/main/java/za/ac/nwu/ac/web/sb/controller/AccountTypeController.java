package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("account-type")
public class AccountTypeController {

    private final FetchAccountTypeFlow fetchAccountTypeFlow;
    private final CreateAccountTypeFlow createAccountTypeFlow;

    @Autowired
    public AccountTypeController (FetchAccountTypeFlow fetchAccountTypeFlow,
                                  @Qualifier("createAccountTypeFlowName")CreateAccountTypeFlow createAccountTypeFlow){
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
        this.createAccountTypeFlow = createAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account Types.", notes = "Returns a list of Account Types.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message ="Account types returned", response = GeneralResponse.class),
            @ApiResponse (code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<AccountTypeDto>>> getAll() {
        List<AccountTypeDto> accountTypes = fetchAccountTypeFlow.getAllAccountTypes();
        GeneralResponse<List<AccountTypeDto>> response = new GeneralResponse<>(true, accountTypes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new AccountType.", notes = "Creates a new AccountType in DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The AccountType was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> create(
            @ApiParam(value = "Request body to create a new AccountType.",
                    required = true)
            @RequestBody AccountTypeDto accountType){
        AccountTypeDto accountTypeResponse = createAccountTypeFlow.create(accountType);
        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountTypeResponse);
         return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{mnemonic}")
    @ApiOperation(value = "Fetches the specified AccountType.", notes = "Fetches the specified AccountType in DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Goal Found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<AccountTypeDto>> getAccountType(
            @ApiParam(value = "The mnemonic that uniquely identifies the Account.",
                    example = "MILES",
                    name = "mnemonic",
                    required = true)
            @PathVariable("mnemonic") final String mnemonic){
        AccountTypeDto accountType = fetchAccountTypeFlow.getAccountTypeByMnemonic(mnemonic);

        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

//    @GetMapping("{byMnemonics}")
//    @ApiOperation(value = "Fetches the specified AccountType.", notes = "Fetches the specified AccountType in DB.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Goal Found", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<AccountType>> getAccountTypeByUsername(
//            @ApiParam(value = "The mnemonic that uniquely identifies the Account.",
//                    example = "PLAY",
//                    name = "mnemonic",
//                    required = true)
//            @RequestParam("mnemonic") final String mnemonic){
//        AccountType accountType = fetchAccountTypeFlow.getAccountTypeDbByMnemonic(mnemonic);
//
//        GeneralResponse<AccountType> response = new GeneralResponse<>(true, accountType);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }

//    @PutMapping("{mnemonic}")
//    @ApiOperation(value = "Alters the specified AccountType.", notes = "Fetches the specified AccountType in DB.")
//    @ApiResponses(value = {
//            @ApiResponse(code = 201, message = "Goal Found", response = GeneralResponse.class),
//            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
//            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
//    public ResponseEntity<GeneralResponse<AccountTypeDto>> updateAccountType(
//            @ApiParam(value = "The mnemonic that changes the Account.",
//                    example = "MILES",
//                    name = "mnemonic",
//                    required = true)
//            @PathVariable("mnemonic") final String mnemonic,
//
//            @ApiParam(value = "The accountTypeName for which the mnemonic will change",
//                    required = true)
//            @RequestParam("accountTypeName") final String accountTypeName,
//
//            @ApiParam(value = "The creation date of the account type in the format yyyy-MM-dd",
//                    name = "newCreationDate")
//            @RequestParam(value = "newCreationDate")
//            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//                    LocalDate newCreationDate
//    ){
//        AccountTypeDto accountType = fetchAccountTypeFlow.updateAccountType(mnemonic, accountTypeName, newCreationDate);
//
//        GeneralResponse<AccountTypeDto> response = new GeneralResponse<>(true, accountType);
//
//        return new ResponseEntity<>(response, HttpStatus.OK);
//
//    }


}
