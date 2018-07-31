package com.example.ravi.sports;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CricketFragment extends Fragment {


    BBC bbcData;
    ListView listView ;
    ArrayList<Article> newsList;
    ArticleAdapter articleAdapter;




    public CricketFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_item, container, false);

        listView = (ListView)rootView.findViewById(R.id.listView);
        newsList = new ArrayList<Article>();
        articleAdapter = new ArticleAdapter(getActivity(),newsList);
        listView.setAdapter(articleAdapter);

        getData();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(newsList.get(position).getUrl()));
                startActivity(i);
            }
        });



        return rootView;
    }


    private void getData(){

        retrofit2.Call<BBC> bbcCall = NetworkUtils.getCricketService().getBBC();
        bbcCall.enqueue(new Callback<BBC>() {
            @Override
            public void onResponse(retrofit2.Call<BBC> call, Response<BBC> response) {

                bbcData = response.body();
                newsList = (ArrayList)bbcData.getArticles();

                //Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
                articleAdapter = new ArticleAdapter(getActivity(),newsList);
                listView.setAdapter(articleAdapter);

            }

            @Override
            public void onFailure(retrofit2.Call<BBC> call, Throwable t) {

                Toast.makeText(getActivity(),"Failure",Toast.LENGTH_SHORT).show();

            }
        });


    }

}
