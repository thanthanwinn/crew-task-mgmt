package org.mdt.crewtaskmanagement.mapper;

import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.dto.crewAssignment.CrewAssignmentDto;
import org.mdt.crewtaskmanagement.model.Crew;
import org.mdt.crewtaskmanagement.model.CrewAssignment;
import org.mdt.crewtaskmanagement.model.Ship;
import org.mdt.crewtaskmanagement.repository.CrewRepository;
import org.mdt.crewtaskmanagement.repository.ShipRepository;

import java.time.LocalDate;
@RequiredArgsConstructor
public class CrewAssignmentMapper {

//    public static CrewAssignment fromDto(CrewAssignmentDto dto){
//        Crew crew = crewRepository.findById(dto.getCrewId()).orElseThrow();
//        Ship ship = shipRepository.findById(dto.getShipId()).orElseThrow();
//        CrewAssignment crewAssignment = new CrewAssignment();
//        crewAssignment.setCrew(crew);
//        crewAssignment.setShip(ship);
//        crewAssignment.setPosition(dto.getPosition());
//        crewAssignment.setStartDate(LocalDate.parse(dto.getStartDate()));
//        crewAssignment.setEndDate(LocalDate.parse(dto.getEndDate()));
//    }

}
