package com.example.payoneertestapplicationjava.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payment{
    public String reference;
    public int amount;
    public String currency;
}