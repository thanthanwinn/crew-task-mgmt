package org.mdt.crewtaskmanagement.service;

import org.mdt.crewtaskmanagement.dto.material.MaterialDto;

import java.util.List;

public interface MaterialService {
    MaterialDto registerMaterial(MaterialDto materialDto);
    MaterialDto updateMaterial(MaterialDto materialDto);
    MaterialDto getMaterialById(long id);
    List<MaterialDto> getAllMaterials();
    void deleteMaterialById(long id);
}
