package com.projectmanagement.service;

import java.util.List;

import javax.validation.Valid;

import com.projectmanagement.dto.DirectorRequestDto;
import com.projectmanagement.dto.DirectorResponseDto;
import com.projectmanagement.entity.Director;

public interface DirectorService {


	void saveDirector(@Valid DirectorRequestDto directorRequestDto);

	List<DirectorResponseDto> getDirector();

	void deleteDirector(Integer directorId);

	Director getDirectorById(Integer directorId);

	void updateDirector(DirectorRequestDto directorRequestDto, Integer directorId);

	

	
}
