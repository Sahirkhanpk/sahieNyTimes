package com.example.nytimesahir;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;


import com.example.nytimesahir.Model.ApiResponse;
import com.example.nytimesahir.Model.News;
import com.example.nytimesahir.api.ApiClient;
import com.example.nytimesahir.api.IEndPoints;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;






public class MainActivity extends AppCompatActivity {


    List<News> ArticalsList = new ArrayList<News>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        getArticals();
    }



    public void getArticals() {
        try {


            IEndPoints iEndPoints = ApiClient.getClient().create(IEndPoints.class);




            rx.Observable<ApiResponse> observableUserdata = iEndPoints.getNewsDetails("all-sections", "1", "BPBMGAWRLKQlpZ5hZSx57YGnCaEbtqTm")
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
            observableUserdata.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ApiResponse>() {
                        @Override
                        public void onCompleted() {



                        }

                        @Override
                        public void onError(Throwable e) {


                            Toast.makeText(MainActivity.this,
                                    "Network Error" + e, Toast.LENGTH_SHORT).show();
                            e.printStackTrace();

                        }

                        @Override
                        public void onNext( ApiResponse userdataResponse) {
                            if (userdataResponse != null) {


                             //   int statusCode = Integer.parseInt(userdataResponse.getStatus());

                             //   if (statusCode == 200) {
                                ArticalsList = userdataResponse.getResults();


//                                    for(int a =0;a<userdataResponse.getNum_results()-1;a++)
//                                    {
//
//                                   // media.setUrl(userdataResponse.get(a).getUrl());
//                                    ArticalsList.get(a).setUrl(userdataResponse.getMedia().get(a));
//
//
//                                    }

                               // }

                             /*   for(int a =0;a<10;a++)
//                                    {
//
                                     ArticalsList.add(userdataResponse.getResults().get(a));
//
//
//                                    }
*/



                                AdapterNyTimes adapterNyTimes = new AdapterNyTimes(MainActivity.this, userdataResponse);
                                recyclerView.setAdapter(adapterNyTimes);

                            }

                        }

                    });
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
}
