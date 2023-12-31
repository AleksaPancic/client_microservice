package com.example.bvnk_client_service.controller;

import com.example.bvnk_client_service.DTO.ReportDTO;
import com.example.bvnk_client_service.facade.ReportFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.CLIENT_ID_NOT_NULL_MESSAGE_FORMAT;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.NOT_NULL_MESSAGE_FORMAT;
import static com.example.bvnk_client_service.util.constants.ClientMicroserviceConstants.UPDATED_SUCCESSFUL;


@RestController
@RequestMapping("/report")
public class ReportController {
	private final ReportFacade reportFacade;

	@Autowired
	public ReportController(final ReportFacade reportFacade) {
		this.reportFacade = reportFacade;
	}

	@GetMapping("/{clientId}")
	public ResponseEntity<ReportDTO> getReportForClient(@PathVariable final Long clientId) {

		Objects.requireNonNull(clientId, String.format(NOT_NULL_MESSAGE_FORMAT, Long.class.getSimpleName()));

		return ResponseEntity.ok(reportFacade.getReportForClient(clientId));
	}

	@PostMapping("/update")
	public ResponseEntity<String> updateClientReport(@RequestParam final Long clientId,
													 @RequestBody final ReportDTO report) {

		Objects.requireNonNull(clientId, CLIENT_ID_NOT_NULL_MESSAGE_FORMAT);
		Objects.requireNonNull(report, String.format(NOT_NULL_MESSAGE_FORMAT, ReportDTO.class.getSimpleName()));

		//exception handled within GlobalExceptionHandler
		reportFacade.updateClientReport(clientId, report);

		return ResponseEntity.ok(String.format(UPDATED_SUCCESSFUL, ReportDTO.class.getSimpleName()) + clientId);
	}

}
