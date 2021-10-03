package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.MilesAccountDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateMilesAccountFlow;
import za.ac.nwu.ac.logic.flow.FetchMilesAccountFlow;

import java.util.List;

@RestController
@RequestMapping("miles-account")
public class MilesAccountController {

    private final FetchMilesAccountFlow fetchMilesAccountFlow;
    private final CreateMilesAccountFlow createMilesAccountFlow;

    @Autowired
    public MilesAccountController(FetchMilesAccountFlow fetchMilesAccountFlow,
                                  @Qualifier("createMilesAccountFlowName")CreateMilesAccountFlow createMilesAccountFlow){
        this.fetchMilesAccountFlow = fetchMilesAccountFlow;
        this.createMilesAccountFlow = createMilesAccountFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Miles Accounts.", notes = "Returns a list of Miles Accounts.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message ="Miles Accounts returned", response = GeneralResponse.class),
            @ApiResponse (code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<MilesAccountDto>>> getAll() {
        List<MilesAccountDto> milesAccounts = fetchMilesAccountFlow.getAllMilesAccounts();
        GeneralResponse<List<MilesAccountDto>> response = new GeneralResponse<>(true, milesAccounts);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new MilesAccount.", notes = "Creates a new MilesAccount in DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The MilesAccount was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MilesAccountDto>> create(
            @ApiParam(value = "Request body to create a new MilesAccount.",
                    required = true)
            @RequestBody MilesAccountDto milesAccount){
        MilesAccountDto milesAccountResponse = createMilesAccountFlow.create(milesAccount);
        GeneralResponse<MilesAccountDto> response = new GeneralResponse<>(true, milesAccountResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
