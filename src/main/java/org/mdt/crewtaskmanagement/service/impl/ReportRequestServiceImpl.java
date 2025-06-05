package org.mdt.crewtaskmanagement.service.impl;

import lombok.RequiredArgsConstructor;
import org.mdt.crewtaskmanagement.dto.approval.ApprovalDto;
import org.mdt.crewtaskmanagement.dto.material.MaterialDto;
import org.mdt.crewtaskmanagement.dto.mrrequest.MRRDto;
import org.mdt.crewtaskmanagement.dto.reportrequest.ReportRequestDto;
import org.mdt.crewtaskmanagement.mapper.MaterialMapper;
import org.mdt.crewtaskmanagement.mapper.ReportRequestMapper;
import org.mdt.crewtaskmanagement.model.*;
import org.mdt.crewtaskmanagement.model.type.CrewRank;
import org.mdt.crewtaskmanagement.repository.*;
import org.mdt.crewtaskmanagement.service.MaterialService;
import org.mdt.crewtaskmanagement.service.ReportRequestService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReportRequestServiceImpl implements ReportRequestService {
    private final CrewRepository crewRepository;
    private final MaterialRepository materialRepository;
    private final ReportRequestRepository reportRequestRepository;
    private final MaterialReportRequestRepository mrrRepository;
    private final TaskScheduleRepository ts_dao;
    private final ApprovalRepository approvalRepository;
    private final MaterialServiceImpl materialService;


    @Override
    public ReportRequestDto createReportRequest(ReportRequestDto reportRequestDto) {
        ReportRequest reportRequest = new ReportRequest();
        reportRequest.setTitle(reportRequestDto.getTitle());
        reportRequest.setContent(reportRequestDto.getContent());
        Crew crew = crewRepository.findById(reportRequestDto.getCrewId()).orElseThrow();
        reportRequest.setCrew(crew);
        TaskAssignment t_a = ts_dao.findById(reportRequestDto.getT_a_id()).orElseThrow();
        reportRequest.setTaskAssignment(t_a);
        reportRequest.setReportType(reportRequestDto.getReportType());
        reportRequest.setRequestDate(LocalDate.now());
        reportRequestRepository.save(reportRequest);
        return ReportRequestMapper.toDto(reportRequest);
    }

    @Override
    public List<MaterialDto> getMaterialsFromReportRequest(long reportRequestId) {
        List<Material> materials = mrrRepository.getMaterialsUsedInReportRequestByReportRequestId(reportRequestId);
        List<MaterialDto> materialDtos = materials.stream()
                .map(m -> MaterialMapper.toDto(m))
                .collect(Collectors.toList());
        return materialDtos;
    }
    @Transactional
    public String assignMaterialsToReportRequest(long reportRequestId, long materialId, int quantity) {
        MaterialReportRequest mrr = new MaterialReportRequest();
        ReportRequest reportRequest = reportRequestRepository.findById(reportRequestId).orElseThrow();
        Material material = materialRepository.findById(materialId).orElseThrow();
        mrr.setMaterial(material);
        mrr.setQuantity(quantity);
        mrr.setReportRequest(reportRequest);
        mrrRepository.save(mrr);
        System.out.println(mrr.getReportRequest().getId() + " " + mrr.getMaterial().getId() + " " + mrr.getMaterial().getName());
        return "added material " + mrr.getMaterial().getName() + " to report request " + mrr.getReportRequest().getTitle();
    }

    @Override
    public List<ReportRequestDto> getPendingReportRequests(long crewId) {
        CrewRank position = crewRepository.findById(crewId).get().getCrewRank();
        List<ReportRequest> reportRequests = new ArrayList<>();
        if(position == CrewRank.valueOf("first")){
            reportRequests = reportRequestRepository.getReportRequestsForFirstLeader();
        }
        else if(position == CrewRank.valueOf("second")){
            reportRequests = reportRequestRepository.getReportRequestsForSecondLeader();
        }
        else if(position == CrewRank.valueOf("third")){
            reportRequests = reportRequestRepository.getReportRequestsForThirdLeader();
        }
        return reportRequests.stream()
                .map(r -> ReportRequestMapper.toDto(r))
                .collect(Collectors.toList());
    }

    @Override
    public void addApprovalForReportRequest( ApprovalDto approvalDto) {
        ReportRequest reportRequest = reportRequestRepository.findById(approvalDto.getReportRequestId()).orElseThrow();
        Approval approval = new Approval();
        approval.setApprovalTimestamp(LocalDateTime.now());
        var crew =crewRepository.findById(approvalDto.getCrewId()).orElseThrow();
        approval.setCrew(crew);

        approval.setPosition(CrewRank.valueOf(crew.getCrewRank().toString()));
        approval.setReportRequest(reportRequest);
        approvalRepository.save(approval);
        reportRequest.addApproval(approval);
        List<MaterialReportRequest> mrrList = reportRequest.getMaterialReportRequest();
        if (mrrList != null && approval.getPosition().toString() == "first") {
            mrrList.forEach(mrr -> {
                materialService.reduceQuantity(mrr.getMaterial().getId(), mrr.getQuantity());
                System.out.println(mrr.getMaterial().getId() + " " + mrr.getQuantity());
            });
        }



    }

    @Override
    public List<ReportRequestDto> getApprovedReportRequest(long crewId) {
        return reportRequestRepository.getApprovedReportRequests(crewId).stream()
                .map(r -> ReportRequestMapper.toDto(r))
                .collect(Collectors.toList());
    }
}
