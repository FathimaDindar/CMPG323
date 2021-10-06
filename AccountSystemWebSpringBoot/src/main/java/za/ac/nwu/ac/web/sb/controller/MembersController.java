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
import za.ac.nwu.ac.domain.dto.MembersDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateMembersFlow;
import za.ac.nwu.ac.logic.flow.FetchMembersFlow;

import java.util.List;

@RestController
@RequestMapping("member")
public class MembersController {

    private final FetchMembersFlow fetchMembersFlow;
    private final CreateMembersFlow createMembersFlow;

    @Autowired
    public MembersController (FetchMembersFlow fetchMembersFlow,
                                  @Qualifier("createMembersFlowName")CreateMembersFlow createMembersFlow){
        this.fetchMembersFlow = fetchMembersFlow;
        this.createMembersFlow = createMembersFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Members.", notes = "Returns a list of Members.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message ="Members returned", response = GeneralResponse.class),
            @ApiResponse (code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<List<MembersDto>>> getAll() {
        List<MembersDto> members = fetchMembersFlow.getAllMembers();
        GeneralResponse<List<MembersDto>> response = new GeneralResponse<>(true, members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Creates a new Members.", notes = "Creates a new Members in DB.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The Members was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse<MembersDto>> create(
            @ApiParam(value = "Request body to create a new Members.",
                    required = true)
            @RequestBody MembersDto member){
        MembersDto memberResponse = createMembersFlow.create(member);
        GeneralResponse<MembersDto> response = new GeneralResponse<>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
