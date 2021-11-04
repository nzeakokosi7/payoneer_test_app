package com.example.payoneertestapplicationjava.models;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContractData{
    @SerializedName("PAGE_ENVIRONMENT")
    public String page_environment;
    @SerializedName("JAVASCRIPT_INTEGRATION")
    public String javascript_integration;
    @SerializedName("PAGE_BUTTON_LOCALE")
    public String page_button_locale;
}
