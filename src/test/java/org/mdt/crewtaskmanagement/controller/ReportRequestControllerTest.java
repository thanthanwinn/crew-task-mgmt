package org.mdt.crewtaskmanagement.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mdt.crewtaskmanagement.service.ReportRequestService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


class ReportRequestControllerTest {
    private final ReportRequestService reportRequestService = mock(ReportRequestService.class);
    private final ReportRequestController reportRequestController = new ReportRequestController(reportRequestService);

    @Test
    void createReportRequest() {
    }

    @Test
    void addMaterials() {
    }

    @Test
    void getAllMaterials() {
    }

    @Test
    void addApprovalToReportRequest() {
    }

    @Test
    void getApprovedReportRequests() {
    }

    @Test
    void getAllReportRequests() {
   }
//    @Test
//    void addTest() {
//        reportRequestController.add(2,2);
//        assertEquals(4,reportRequestController.add(2,2));
//        assertNotEquals(4,reportRequestController.add(2,2));
//        assertTrue(true);
//        assertFalse(false);
//        assertNotNull(reportRequestController.add(2,2));
//        assertThrows(NullPointerException.class, () -> reportRequestController.add(2,2));
//    }
}
