package com.example.payoneertestapplicationjava.ui.paymentMethods;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.payoneertestapplicationjava.models.ApiResponse;
import com.example.payoneertestapplicationjava.repositories.PaymentMethodRepository;

public class PaymentMethodViewModel extends AndroidViewModel {
    private final PaymentMethodRepository repository;

    public PaymentMethodViewModel(@NonNull Application application) {
        super(application);
        repository = PaymentMethodRepository.getInstance();
    }

    public LiveData<ApiResponse> getPaymentMethods() {
        MutableLiveData<ApiResponse> paymentMethods = new MutableLiveData<>();
        paymentMethods = repository.getPaymentMethods();
        return paymentMethods;
    }
}