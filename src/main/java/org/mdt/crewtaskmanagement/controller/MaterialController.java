package org.mdt.crewtaskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.dto.material.MaterialDto;
import org.mdt.crewtaskmanagement.service.MaterialService;
import org.mdt.crewtaskmanagement.service.impl.MaterialServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mdt/material")
public class MaterialController {
    private final MaterialServiceImpl materialService;

    @PostMapping("/register")
    public ResponseEntity<MaterialDto> registerMaterial(@RequestBody MaterialDto materialDto) {
        return ResponseEntity.ok(materialService.registerMaterial(materialDto));
    }

    @PostMapping("/update")
    public ResponseEntity<MaterialDto> updateMaterial(@RequestBody MaterialDto materialDto) {
        return ResponseEntity.ok(materialService.updateMaterial(materialDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDto> getMaterialById(@PathVariable("id") long id) {
        return ResponseEntity.ok(materialService.getMaterialById(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<MaterialDto>> getAllMaterials() {
        return ResponseEntity.ok(materialService.getAllMaterials());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMaterialById(@PathVariable("id") long id) {
        materialService.deleteMaterialById(id);
        return ResponseEntity.ok("Deleted material with id " + id);
    }
}
