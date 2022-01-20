package com.projectmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Iterator;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectmanagement.dto.DirectorRequestDto;
import com.projectmanagement.dto.DirectorResponseDto;
import com.projectmanagement.entity.Director;
import com.projectmanagement.exception.MyCustomizeedException;
import com.projectmanagement.repository.DirectorRepository;
import com.projectmanagement.service.DirectorService;



@Service
public class DirectorServiceImpl implements DirectorService {

	@Autowired
	DirectorRepository directorRepository;
	
	@Override
	public void saveDirector(@Valid DirectorRequestDto directorRequestDto) {
		Director director = new Director();
		BeanUtils.copyProperties(directorRequestDto, director);
		directorRepository.save(director);
		
	}

	@Override
	public List<DirectorResponseDto> getDirector() {
		List<DirectorResponseDto> directorResponseDtoList = new ArrayList<DirectorResponseDto>();
		Iterator<Director> it	=directorRepository.findAll().iterator();

		while (it.hasNext()) {
			DirectorResponseDto directorResponseDto = new DirectorResponseDto();
			BeanUtils.copyProperties(it.next(), directorResponseDto);
			directorResponseDtoList.add(directorResponseDto);
		}
		return directorResponseDtoList;
	}

	@Override
	public void deleteDirector(Integer directorId) {
		Optional<Director>opC= directorRepository.findById(directorId);
		if(!opC.isPresent()) throw new MyCustomizeedException("No customer with the id: "+directorId);
		Director director=new Director();
		director.setDirectorId(directorId);
		directorRepository.delete(director);
		
	}

	@Override
	public Director getDirectorById(Integer directorId) {
		return directorRepository.findById(directorId).orElseThrow(() -> 
		new MyCustomizeedException("No customer with the id: "+directorId));
	}

	@Override
	public void updateDirector(DirectorRequestDto directorRequestDto, Integer directorId) {
		
		Director existingDirector = directorRepository.findById(directorId)
				.orElseThrow(() -> new MyCustomizeedException("No customer with the id: "+directorId));

		existingDirector.setDirectorName(directorRequestDto.getDirectorName());
		existingDirector.setPhoneNo(directorRequestDto.getPhoneNo());
		existingDirector.setEmail(directorRequestDto.getEmail());
		directorRepository.save(existingDirector);

	}

	

	
	

	
	

	
	

}
