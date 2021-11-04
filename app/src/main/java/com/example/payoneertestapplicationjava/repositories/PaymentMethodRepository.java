package com.example.payoneertestapplicationjava.repositories;

import androidx.lifecycle.MutableLiveData;

import com.example.payoneertestapplicationjava.dao.ApiInterface;
import com.example.payoneertestapplicationjava.models.ApiResponse;
import com.example.payoneertestapplicationjava.utils.RetrofitCallback;
import com.example.payoneertestapplicationjava.utils.RetrofitService;

import retrofit2.Call;

public class PaymentMethodRepository {
    private static ApiInterface apiInterface;
    private final MutableLiveData<ApiResponse> paymentMethods = new MutableLiveData<>();
    private static PaymentMethodRepository paymentMethodRepository;

    public static PaymentMethodRepository getInstance(){
        if (paymentMethodRepository == null){
            paymentMethodRepository = new PaymentMethodRepository();
        }
        return paymentMethodRepository;
    }

    public PaymentMethodRepository(){
        apiInterface = RetrofitService.getInterface();
    }

    public MutableLiveData<ApiResponse> getPaymentMethods() {
        Call<ApiResponse> responseCall = apiInterface.getPaymentMethods();
        responseCall.enqueue(new RetrofitCallback<ApiResponse>(true) {
            @Override
            public void onSuccess(ApiResponse response) {
                paymentMethods.setValue(response);
            }
        });
        return paymentMethods;
    }
}
