package com.platzi.market.web.controller;

import com.platzi.market.domain.Client;
import com.platzi.market.domain.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/all")
    @Operation(summary = "Shows all the clients information")
    @ApiResponse(responseCode = "200", description = "Ok")
    public ResponseEntity<List<Client>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    @Operation (summary= "Search a Client with Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Client not found")
    })
    public ResponseEntity<Client> findById(@Parameter(description = "The id of the Client", required = true, schema = @Schema(implementation = String.class), example = "2552243")
            @PathVariable("id") String id){
        if(service.findById(id).isPresent()){
            return new ResponseEntity<>(service.findById(id).get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    @Operation(summary = "Save a Client")
    @ApiResponse(responseCode = "201", description = "created")
    public ResponseEntity<Client> save(@RequestBody  Client client){
        return new ResponseEntity<>(service.save(client),HttpStatus.CREATED);
    }

   @DeleteMapping("/delete/{id}")
   @Operation (summary= "Delete a Client by introducing the id")
   @ApiResponses({
           @ApiResponse(responseCode = "200", description = "Ok"),
           @ApiResponse(responseCode = "404", description = "Client not found")
   })
    public ResponseEntity delete(@Parameter(description = "The id of the Client", required = true, schema = @Schema (implementation = String.class), example = "2552243")
            @PathVariable("id") String id){
        if (service.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity((HttpStatus.NOT_FOUND));
        }
    }


}
