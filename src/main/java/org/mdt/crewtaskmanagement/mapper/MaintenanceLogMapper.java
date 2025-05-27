package org.mdt.crewtaskmanagement.mapper;

import org.mdt.crewtaskmanagement.dto.maintenancelog.MaintenanceLogDto;
import org.mdt.crewtaskmanagement.model.MaintenanceLog;
import org.mdt.crewtaskmanagement.model.Material;

public class MaintenanceLogMapper {

    public static MaintenanceLog fromDto(MaintenanceLogDto dto, Material material) {
        if (dto == null) {
            return null;
        }

        MaintenanceLog maintenanceLog = new MaintenanceLog();
        maintenanceLog.setTitle(dto.getTitle());
        maintenanceLog.setRemark(dto.getRemark());
        maintenanceLog.setMaintainedBy(dto.getMaintainedBy());
        maintenanceLog.setMaterial(material);

        // Only set ID if present in DTO (not 0)
        if (dto.getId() != 0L) {
            maintenanceLog.setId(dto.getId());
        }

        return maintenanceLog;
    }

    public static MaintenanceLogDto toDto(MaintenanceLog entity) {
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
    public static MaintenanceLogDto toDtoWithMaterial(MaintenanceLog entity) {
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
