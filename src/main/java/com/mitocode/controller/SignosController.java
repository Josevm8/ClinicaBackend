package com.mitocode.controller;

import com.mitocode.dto.SignosDTO;
import com.mitocode.model.Signos;
import com.mitocode.service.ISignosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/signos")
@RequiredArgsConstructor
public class SignosController {

    private final ISignosService service;// = new PatientService();
    @Qualifier("defaultMapper")
    private final ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<Void> save(@Valid @RequestBody SignosDTO dto){
        log.info("grabar consulta: "+dto);
        log.info("convertido a entidad: "+convertToEntity(dto));
        Signos obj = service.save(convertToEntity(dto));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdSigno()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<SignosDTO>> findAll(){

        List<SignosDTO> list = service.findAll().stream().map(this::convertToDto).toList();
/*
        List<SignosDTO> list = new ArrayList<>();
        service.findAll().stream().map(this::convertToDto).forEach( x -> {
            SignosDTO s = new SignosDTO();
            SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
            s.setPatient(x.getPatient());
            s.setIdSigno(x.getIdSigno());
            s.setFecha(LocalDateTime.parse(date.format(x.getFecha())));
            //la fecha da error de parseo, deberia ser string el campo fecha del DTO
            list.add(s);
        });*/

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SignosDTO> findById(@PathVariable("id") Integer id){
        Signos obj = service.findById(id);

        return ResponseEntity.ok(convertToDto(obj));
        //return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SignosDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody SignosDTO dto){
        dto.setIdSigno(id);
        Signos obj = service.update(id, convertToEntity(dto));

        return ResponseEntity.ok(convertToDto(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id){
        service.delete(id);

        return ResponseEntity.noContent().build(); //204 NO CONTENT
    }


    private SignosDTO convertToDto(Signos obj){
        return modelMapper.map(obj, SignosDTO.class);
    }

    private Signos convertToEntity(SignosDTO dto){
        return modelMapper.map(dto, Signos.class);
    }

}
