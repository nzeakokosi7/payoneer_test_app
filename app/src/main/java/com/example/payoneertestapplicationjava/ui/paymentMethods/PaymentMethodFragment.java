package com.example.payoneertestapplicationjava.ui.paymentMethods;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.payoneertestapplicationjava.R;
import com.example.payoneertestapplicationjava.adapters.PaymentMethodAdapter;
import com.example.payoneertestapplicationjava.models.ApiResponse;
import com.example.payoneertestapplicationjava.models.ApplicableNetworks;
import com.example.payoneertestapplicationjava.models.ContractData;
import com.example.payoneertestapplicationjava.models.InputElement;
import com.example.payoneertestapplicationjava.models.Links;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodFragment extends Fragment {

    private PaymentMethodViewModel mViewModel;
    private PaymentMethodAdapter adapter;

    public static PaymentMethodFragment newInstance() {
        return new PaymentMethodFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.payment_method_fragment, container, false);
        mViewModel = new ViewModelProvider(this).get(PaymentMethodViewModel.class);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        adapter = new PaymentMethodAdapter(getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        setupLoaderWithDummyData();
        return view;
    }

    private void setupLoaderWithDummyData() {
        List<ApplicableNetworks> dummyData = new ArrayList<>();
        for(int i = 0; i<10; i++){
            Links dumL = new Links("", "", "",
                    "", "");
            List<InputElement> dumIE = new ArrayList<>();
            ContractData dumCD = new ContractData("",
                    "", "");
            ApplicableNetworks applicableNetworks =
                    new ApplicableNetworks("", "", "", "", "",
                            "", false, dumL, false, dumIE, "", dumCD);
            dummyData.add(applicableNetworks);
        }
        adapter.setPaymentMethodList(dummyData);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewModel.getPaymentMethods().observe(getViewLifecycleOwner(),
                apiResponse -> adapter.setPaymentMethodList(apiResponse.getNetworks().getApplicable()));
    }
}