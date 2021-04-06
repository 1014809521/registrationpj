package com.gpj.result;

import lombok.Data;

@Data
public class PatientQueryResult {
    private long pageNum = 1;
    private long pageSize = 5;
    private String patientName;
    private String doctorName;
    private Integer patientId;
    private Integer userId;
    private Integer doctorId;
    private Integer registrationId;
}
