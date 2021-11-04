package com.example.payoneertestapplicationjava.models;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApplicableNetworks{
    public String code;
    public String label;
    public String method;
    public String grouping;
    public String registration;
    public String recurrence;
    public boolean redirect;
    public Links links;
    public boolean selected;
    public List<InputElement> inputElements;
    public String operationType;
    public ContractData contractData;
}
