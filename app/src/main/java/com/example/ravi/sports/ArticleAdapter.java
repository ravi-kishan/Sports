package com.example.ravi.sports;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravi on 29-07-2018.
 */

public class ArticleAdapter extends ArrayAdapter<Article> {

    private Context mContext;
    private List<Article> newsList = new ArrayList<>();



    public ArticleAdapter(@NonNull Context context, ArrayList<Article> articles) {
        super(context, 0, articles);
        mContext = context;
        newsList = articles;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.card_view,parent,false);

        Article currentArticle = newsList.get(position);
        CardView cardView = (CardView)listItem.findViewById(R.id.cardView);
        ImageView imageView = (ImageView)listItem.findViewById(R.id.image);
        TextView textView1 = (TextView)listItem.findViewById(R.id.textView1);
        TextView textView2 = (TextView)listItem.findViewById(R.id.textView2);
        TextView textView3 = (TextView)listItem.findViewById(R.id.textView3);
        TextView textView4 = (TextView)listItem.findViewById(R.id.textView4);
        textView1.setText(newsList.get(position).getTitle());
        textView2.setText(newsList.get(position).getDescription());
        textView3.setText("Date: " + newsList.get(position).getPublishedAt().substring(0,10));
        textView4.setText("Time: " + newsList.get(position).getPublishedAt().substring(11,19));

        Glide.with(getContext()).load(newsList.get(position).getUrlToImage()).into(imageView);




        return listItem;
    }
}
