package com.example.nytimesahir.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class ApiResponse {

    @SerializedName("status")
    private String  status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNum_results() {
        return num_results;
    }

    public void setNum_results(int num_results) {
        this.num_results = num_results;
    }

    public List<News> getResults() {
        return results;
    }

    public void setResults(List<News> results) {
        this.results = results;
    }

    @SerializedName("num_results")
    private int num_results;

    @SerializedName("results")
    private  List<News> results;




    }

