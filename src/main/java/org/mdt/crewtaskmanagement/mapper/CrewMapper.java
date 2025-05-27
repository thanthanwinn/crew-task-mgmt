package org.mdt.crewtaskmanagement.mapper;

import org.mdt.crewtaskmanagement.dto.crew.CrewDto;
import org.mdt.crewtaskmanagement.model.Crew;
import org.mdt.crewtaskmanagement.model.type.CrewRank;
import org.mdt.crewtaskmanagement.model.type.Gender;
import org.mdt.crewtaskmanagement.model.type.Section;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class CrewMapper {

    public static Crew fromDto(CrewDto dto) {
        if (dto == null) {
            return null;
        }

        Crew crew = Crew.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .gender(Enum.valueOf(Gender.class, dto.getGender()))
                .phone(dto.getPhone())
                .birthDate(LocalDate.parse(dto.getBirthDate()))
                .joinedDate(LocalDate.parse(dto.getJoinedDate()))
                .active(dto.isActive())
                .section(dto.getSection() != null ? Enum.valueOf(Section.class, dto.getSection()) : null)
                .crewRank(dto.getCrewRank() != null ? Enum.valueOf(CrewRank.class, dto.getCrewRank()) : null)
                .nationality(dto.getNationality())
                .emergencyPhone(dto.getEmergencyPhone())
                .emergencyEmail(dto.getEmergencyEmail())
                .photoUrl(dto.getPhotoUrl())
                .certificates(dto.getCertificates())
                .certificatesExpiry(LocalDate.parse(dto.getCertificatesExpiry()))
                .licenseNo(dto.getLicenseNo())
                .licenseExpiry(dto.getLicenseExpiry())
                .build();

        if (dto.getId() != 0L) {
            crew.setId(dto.getId());
        }

        return crew;
    }

    public static CrewDto toDto(Crew entity) {
        if (entity == null) {
            return null;
        }

        return CrewDto.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .gender(entity.getGender().toString())
                .phone(entity.getPhone())
                .birthDate(entity.getBirthDate().toString())
                .joinedDate(entity.getJoinedDate().toString())
                .active(entity.isActive())
                .section(entity.getSection() != null ? entity.getSection().name() : null)
                .crewRank(entity.getCrewRank() != null ? entity.getCrewRank().name() : null)
                .nationality(entity.getNationality())
                .emergencyPhone(entity.getEmergencyPhone())
                .emergencyEmail(entity.getEmergencyEmail())
                .photoUrl(entity.getPhotoUrl())
                .certificates(entity.getCertificates())
                .certificatesExpiry(entity.getCertificatesExpiry().toString())
                .licenseNo(entity.getLicenseNo())
                .licenseExpiry(entity.getLicenseExpiry())
                .build();
    }


}
