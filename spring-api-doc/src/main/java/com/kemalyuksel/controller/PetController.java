package com.kemalyuksel.controller;

import com.kemalyuksel.dto.PetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.PostConstruct;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private List<PetDto> petDtos = new ArrayList<>();

    @PostConstruct
    public void init(){
        petDtos.add(new PetDto(1,"TestPet1",new Date()));
        petDtos.add(new PetDto(2,"TestPet2",new Date()));
        petDtos.add(new PetDto(3,"TestPet3",new Date()));
    }

    @Operation(summary = "Add Pet")
    @ApiResponse(responseCode = "201", description = "Pet added",
            content = @Content)
    @PostMapping
    public ResponseEntity<PetDto> addUser(@RequestBody PetDto petDto){
        petDtos.add(petDto);
        return ResponseEntity.ok(petDto);
    }

    @Operation(summary = "Get All pets")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found All pets",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PetDto.class)) }),
            @ApiResponse(responseCode = "404", description = "Pets not found",
                    content = @Content) })
    @GetMapping
    public ResponseEntity<List<PetDto>> getAll(){
        return ResponseEntity.ok(petDtos);
    }



}
