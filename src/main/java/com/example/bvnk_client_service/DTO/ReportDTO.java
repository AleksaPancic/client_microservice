package com.example.bvnk_client_service.DTO;

import lombok.Data;


@Data
public class ReportDTO {
	private Long clientId; //reference to the client
	private String reportName;
	private String reportDescription;

}
