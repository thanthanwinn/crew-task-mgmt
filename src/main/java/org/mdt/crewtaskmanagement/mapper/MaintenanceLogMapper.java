package org.mdt.crewtaskmanagement.mapper;
package org.mdt.crewtaskmanagement.mapper;

import org.mdt.crewtaskmanagement.dto.maintenancelog.MaintenanceLogDto;
import org.mdt.crewtaskmanagement.model.Maintenance;
import org.mdt.crewtaskmanagement.model.MaintenanceLog;
import org.mdt.crewtaskmanagement.model.Material;
import org.springframework.web.bind.annotation.Mapping;

import javax.swing.*;


public interface MaintenanceLogMapper {
    @Mapping(target = "category", source = "category", defaultValue = "EngineRoom")
    @Mapping(target = "status", source = "status", defaultValue = "PENDING")
    MaintenanceLog toEntity(MaintenanceLogDto dto);

    MaintenanceLogDto toDto(MaintenanceLog entity);
}
public static MaintenanceLogDto toDto(Maintenance entity) {
    if (entity == null) {
        return null;
    }

    return MaintenanceLogDto.builder()
            .id(entity.getId())
            .title(entity.getTitle())
            .remark(entity.getRemark())
            .maintainedBy(entity.getMaintainedBy())
            .build();
}

// Optional: If you need to include material information in the DTO
public static MaintenanceLogDto toDtoWithMaterial(Maintenance entity) {
    if (entity == null) {
        return null;
    }

    return MaintenanceLogDto.builder()
            .id(entity.getId())
            .title(entity.getTitle())
            .remark(entity.getRemark())
            .maintainedBy(entity.getMaintainedBy())
            // Add material ID or other material info if needed
            .build();
}
}
