package com.example.bvnk_client_service.service;

import com.example.bvnk_client_service.DTO.response.ReportResponseData;


/**
 * This interface defines the methods that the Report Service provides.
 * The Report Service is responsible for managing the reports generated by the clients.
 * It allows the clients to update and retrieve their reports.
 */
public interface ReportService {

	/**
	 * Updates the report for the specified client.
	 *
	 * @param clientId the ID of the client for whom the report is to be updated
	 *
	 * @return the updated report data
	 *
	 * @throws IllegalStateException if the report cannot be updated for any reason
	 */
	ReportResponseData updateReportForClient(Long clientId, ReportResponseData reportResponseData) throws IllegalStateException;

	/**
	 * Retrieves the report for the specified client.
	 *
	 * @param clientId the ID of the client for whom the report is to be retrieved
	 *
	 * @return the report data
	 *
	 * @throws IllegalStateException if the report cannot be retrieved for any reason
	 */
	ReportResponseData getReportForClient(Long clientId) throws IllegalStateException;

}
