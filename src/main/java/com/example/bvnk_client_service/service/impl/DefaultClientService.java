package com.example.bvnk_client_service.service.impl;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;
import com.example.bvnk_client_service.entity.Client;
import com.example.bvnk_client_service.entity.Report;
import com.example.bvnk_client_service.populator.Populator;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.repository.ReportDAO;
import com.example.bvnk_client_service.service.ClientService;
import com.example.bvnk_client_service.service.ReportService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DefaultClientService implements ClientService {
	private final ClientDAO clientDAO;
	private final ReportDAO reportDAO;
	private final ReportService reportService;

	private final Populator reportPopulator;

	@Autowired
	public DefaultClientService(ClientDAO clientDAO, ReportDAO reportDAO,
								ReportService reportService, Populator reportPopulator) {
		this.clientDAO = clientDAO;
		this.reportDAO = reportDAO;
		this.reportService = reportService;
		this.reportPopulator = reportPopulator;
	}

	@Transactional
	@Override
	public void addReportToClientById(final Long id, final ReportResponseData reportResponseData) { //fokusiraj se posle na ovo da vidis sta zajebava sa kljucevima
		Report report = new Report();
		reportPopulator.populate(reportResponseData, report);
		reportDAO.save(report);
		clientDAO.getReferenceById(id).setReport(report);
	}

	@Override
	public Client getClientById(final Long customerId) {
		return clientDAO.getReferenceById(customerId);
	}
}