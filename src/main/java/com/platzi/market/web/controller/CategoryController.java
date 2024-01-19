package com.platzi.market.web.controller;

import com.platzi.market.domain.Category;
import com.platzi.market.domain.service.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    @Operation(summary = "Get All the Products Categories")
    @ApiResponse(responseCode = "200", description = "Ok")
    public ResponseEntity<List<Category>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation (summary= "Search for a Category with Id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    public ResponseEntity<Category> findById(@Parameter(description = "The id of the Category", required = true, schema = @Schema (implementation = Integer.class), example = "10")
            @PathVariable("id") Integer id){
        if(service.findById(id).isPresent()){
            return new ResponseEntity<>(service.findById(id).get(), HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    @Operation(summary = "Save Category")
    @ApiResponse(responseCode = "201", description = "created")
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity<>(service.save(category),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @Operation (summary= "Delete a Category by introducing the id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "Category not found")
    })
    public ResponseEntity delete(@Parameter(description = "The id of the Category", required = true, schema = @Schema(implementation = Integer.class), example = "10")
            @PathVariable("id") Integer id){
        if (service.delete(id)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
