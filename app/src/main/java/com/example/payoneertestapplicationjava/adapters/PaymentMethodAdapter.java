package com.example.payoneertestapplicationjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.elyeproj.loaderviewlibrary.LoaderImageView;
import com.elyeproj.loaderviewlibrary.LoaderTextView;
import com.example.payoneertestapplicationjava.R;
import com.example.payoneertestapplicationjava.models.ApplicableNetworks;

import java.util.ArrayList;
import java.util.List;

public class PaymentMethodAdapter extends RecyclerView.Adapter<PaymentMethodAdapter.PaymentMethodViewModel> {

    private final LayoutInflater mInflater;
    private List<ApplicableNetworks> mPaymentMethodList;
    private Context mContext;

    public PaymentMethodAdapter(Context mContext) {
        this.mInflater = LayoutInflater.from(mContext);;
        this.mPaymentMethodList = new ArrayList<>();
        this.mContext = mContext;
    }

    public void setPaymentMethodList(List<ApplicableNetworks> methods) {
        this.mPaymentMethodList.clear();
        this.mPaymentMethodList.addAll(methods);

        notifyDataSetChanged();

    }

    @NonNull
    @Override
    public PaymentMethodViewModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.payment_method_item_view, parent, false);
        return new PaymentMethodViewModel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PaymentMethodViewModel viewHolder, int position) {
        final ApplicableNetworks currentNetwork = this.mPaymentMethodList.get(position);
        viewHolder.setItem(currentNetwork);
        viewHolder.mView.setOnClickListener(v -> Toast.makeText(mContext, currentNetwork.getLabel(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        if (mPaymentMethodList != null)
            return mPaymentMethodList.size();
        else return 0;
    }

    public class PaymentMethodViewModel extends RecyclerView.ViewHolder {

        View mView;
        private final LoaderImageView mPaymentLogo;
        private final LoaderTextView mPaymentName;

        public PaymentMethodViewModel(@NonNull View itemView) {
            super(itemView);

            mView = itemView;
            mPaymentLogo = mView.findViewById(R.id.network_logo);
            mPaymentName = mView.findViewById(R.id.network_name);
        }

        public void setItem(ApplicableNetworks currentNetwork) {
            mPaymentName.setText(currentNetwork.getLabel());

            Glide.with(mContext)
                    .load(currentNetwork.getLinks().getLogo())
                    .thumbnail(0.1f)
                    .apply(new RequestOptions())
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mPaymentLogo);
        }
    }
}
