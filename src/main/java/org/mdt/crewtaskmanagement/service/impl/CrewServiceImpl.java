package org.mdt.crewtaskmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.dto.crew.CrewDto;
import org.mdt.crewtaskmanagement.mapper.CrewMapper;
import org.mdt.crewtaskmanagement.model.Crew;
import org.mdt.crewtaskmanagement.repository.CrewRepository;
import org.mdt.crewtaskmanagement.service.CrewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CrewServiceImpl implements CrewService {
    private final CrewRepository crewRepository;
    @Override
    public CrewDto registerCrew(CrewDto dto) {
         Crew crew = CrewMapper.fromDto(dto);
        return CrewMapper.toDto(crewRepository.save(crew));
    }

    @Override
    public CrewDto updateCrew(CrewDto dto) {
        Crew  c = CrewMapper.fromDto(dto);
        c.setId(dto.getId());
        return CrewMapper.toDto(crewRepository.save(c));
    }

    @Override
    public CrewDto getCrewById(long id) {
        return CrewMapper.toDto(crewRepository.findById(id).orElseThrow());
    }

    @Override
    public List<CrewDto> getAllCrews() {
        return crewRepository.findAll().stream().map(CrewMapper::toDto).collect(Collectors.toList());
    }



    @Override
    public void deleteCrew(long id) {
        crewRepository.deleteById(id);
    }
}
