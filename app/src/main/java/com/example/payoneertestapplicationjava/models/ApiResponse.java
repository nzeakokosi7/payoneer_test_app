package com.example.payoneertestapplicationjava.models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    public Links links;
    public Date timestamp;
    public String operation;
    public String resultCode;
    public String resultInfo;
    public ReturnCode returnCode;
    public Status status;
    public Interaction interaction;
    public Identification identification;
    public Networks networks;
    public String operationType;
    public Style style;
    public Payment payment;
    public String integrationType;
}