package com.example.subject1.Retrofit;

import com.example.subject1.Subject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("GetSubjectMasters")
    Call<List<Subject>>getAllSubjects();
}
