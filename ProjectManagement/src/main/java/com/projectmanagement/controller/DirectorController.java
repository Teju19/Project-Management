package com.projectmanagement.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projectmanagement.dto.DirectorRequestDto;
import com.projectmanagement.dto.DirectorResponseDto;
import com.projectmanagement.service.DirectorService;
import com.projectmanagement.entity.Director;



@RestController
@Validated
public class DirectorController {

	@Autowired
	DirectorService directorService;
	
	@PostMapping("/directors")
	public ResponseEntity<String>saveDirector(@Valid @RequestBody DirectorRequestDto directorRequestDto) {
		directorService.saveDirector(directorRequestDto);
		return new ResponseEntity<String>("Data Saved Successfully",HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/directors")
	public ResponseEntity<List<DirectorResponseDto>> getDirector(){
		return new ResponseEntity<List<DirectorResponseDto>>(directorService.getDirector(),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/directors/{id}")
	public ResponseEntity<Director> getDirectorById(@PathVariable("id") Integer directorId) {
		return new ResponseEntity<Director>(directorService.getDirectorById(directorId), HttpStatus.OK);

	}
	
	@PutMapping("/directors/{id}")
	public ResponseEntity<String> updateDirector(@PathVariable("id") Integer directorId, @RequestBody DirectorRequestDto directorRequestDto) {
		directorService.updateDirector(directorRequestDto,directorId );
		return new ResponseEntity<String>("Data Updated Successfully",HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/directors")
	public ResponseEntity<String> deleteDirector(@NotNull(message="directorId cannot be null;") @RequestParam Integer directorId){
		directorService.deleteDirector(directorId);
		return new ResponseEntity<String>("director deleted succesfully",HttpStatus.ACCEPTED);
	}
	
	
	
	
}
 