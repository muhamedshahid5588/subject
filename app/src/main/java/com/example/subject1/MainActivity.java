package com.example.subject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.subject1.Retrofit.RetrofitIntence;
import com.example.subject1.Retrofit.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
List<Subject>subjectslist;
SubjectAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        subjectslist=new ArrayList<>();
        recyclerView=findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ServiceApi serviceApi= RetrofitIntence.getRetrofit().create(ServiceApi.class);
        Call<List<Subject>>call=serviceApi.getAllSubjects();
        call.enqueue(new Callback<List<Subject>>() {
            @Override
            public void onResponse(Call<List<Subject>> call, Response<List<Subject>> response) {

                if (!response.isSuccessful())
                {
                    return;
                }
                subjectslist=response.body();
                adapter=new SubjectAdapter(subjectslist,MainActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Subject>> call, Throwable t) {

                Log.d("TAG","onFailure: "+t.getLocalizedMessage());
            }
        });
    }
}