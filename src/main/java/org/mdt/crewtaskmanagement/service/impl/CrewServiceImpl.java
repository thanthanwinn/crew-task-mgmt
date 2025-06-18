package org.mdt.crewtaskmanagement.service.impl;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.dto.crew.CrewDto;
import org.mdt.crewtaskmanagement.mapper.CrewMapper;
import org.mdt.crewtaskmanagement.model.Crew;
import org.mdt.crewtaskmanagement.param.CrewParam;
import org.mdt.crewtaskmanagement.repository.entity.CrewRepository;
import org.mdt.crewtaskmanagement.repository.entity.RoleRepository;
import org.mdt.crewtaskmanagement.service.CrewService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CrewServiceImpl implements CrewService {
    private final CrewRepository crewRepository;
    private final RoleRepository roleDao;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CrewDto registerCrew(CrewDto dto) {
         Crew crew = CrewMapper.fromDto(dto);

        return CrewMapper.toDto(crewRepository.save(crew));
    }

    @Override
    public CrewDto updateCrew(CrewDto dto) {
        Crew crew = crewRepository.findById(dto.getId()).orElseThrow();

        Crew c = CrewMapper.fromDto(dto);
        if(c.getPassword().isBlank()){
            c.setPassword(passwordEncoder.encode("12345"));
        }else{
            c.setPassword(crew.getPassword());
        }
        c.setId(crew.getId());
        return CrewMapper.toDto(crewRepository.saveAndFlush(c));
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

    @Override
    public List<CrewDto> getCrewsForAssignments() {
        return crewRepository.findAvailableCrewsForAssignment().stream().map(CrewMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<CrewDto> getAllCrewsByShipId(long shipId) {
        return crewRepository.findCrewsByShipId(shipId).stream().map(CrewMapper::toDto).collect(Collectors.toList());
    }
@Override
    public List<CrewDto> search(CrewParam param){
        Function<CriteriaBuilder, CriteriaQuery<Crew>> query = cb -> {
            var cq = cb.createQuery(Crew.class);
            var root = cq.from(Crew.class);

             cq.select(root);
             cq.where(param.where(cb,root));
             cq.orderBy(cb.asc(root.get("firstName")));

             return cq;
        };

        return crewRepository.search(query).stream().map(CrewMapper::toDto).collect(Collectors.toList());
    }


}
