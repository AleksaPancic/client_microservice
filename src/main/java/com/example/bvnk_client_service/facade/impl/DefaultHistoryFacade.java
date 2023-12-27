package com.example.bvnk_client_service.facade.impl;

import com.example.bvnk_client_service.DTO.HistoryDTO;
import com.example.bvnk_client_service.controller.ReportController;
import com.example.bvnk_client_service.facade.HistoryFacade;
import com.example.bvnk_client_service.repository.ClientDAO;
import com.example.bvnk_client_service.service.HistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Facade
public class DefaultHistoryFacade implements HistoryFacade {

	private final static Logger LOG = LoggerFactory.getLogger(ReportController.class);

	private final HistoryService historyService;
	private final ClientDAO clientDAO;

	@Autowired
	public DefaultHistoryFacade(final HistoryService historyService, ClientDAO clientDAO) {
		this.historyService = historyService;
		this.clientDAO = clientDAO;
	}

	@Override
	public HistoryDTO getHistoryForClient(final Long clientId) {
		LOG.info("Getting client history");
		if (clientId == null || !clientDAO.findById(clientId).isPresent()) {
			throw new IllegalArgumentException("Invalid client id " + clientId);
		}
		return historyService.getHistoryForClient(clientId);
	}

}
