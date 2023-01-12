package com.grupo3.androiddsa;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.grupo3.androiddsa.adapters.AdapterFaqs;
import com.grupo3.androiddsa.domain.Faqs;
import com.grupo3.androiddsa.retrofit.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FaqsFragment extends Fragment {
    public List<Faqs> listFaqs;
    private RecyclerView recycler;
    private AdapterFaqs adapterFaqs;
    private ProgressBar progressBarFaqs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_faqs,container,false);
        recycler=(RecyclerView) rootView.findViewById(R.id.recyclerView);
        recycler.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        progressBarFaqs = rootView.findViewById(R.id.progressBarStore);
        getListFaqs();
        return rootView;
    }
    private void getListFaqs(){
        progressBarFaqs.setVisibility(View.VISIBLE);
        Api service = Api.retrofit.create(Api.class);
        Call<List<Faqs>> call = service.getFaqs();
        call.enqueue(new Callback<List<Faqs>>() {
            @Override
            public void onResponse(Call<List<Faqs>> call, Response<List<Faqs>> response) {
                progressBarFaqs.setVisibility(View.GONE);
                listFaqs = response.body();
                adapterFaqs = new AdapterFaqs(listFaqs);
                recycler.setAdapter(adapterFaqs);
            }

            @Override
            public void onFailure(Call<List<Faqs>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_LONG).show();
                progressBarFaqs.setVisibility(View.GONE);
            }
        });
    }
}
