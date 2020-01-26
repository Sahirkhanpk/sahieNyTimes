package com.example.nytimesahir;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.nytimesahir.Model.ApiResponse;



public class AdapterNyTimes extends RecyclerView.Adapter<AdapterNyTimes.ViewHolder> {


    Context mContext;

   ApiResponse media;

    public AdapterNyTimes(Context context, ApiResponse media) {
        mContext = context;
        this.media = media;

    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView picture;
        public LinearLayout details;

        //*** code changed ***
        //public TextView txt_item_list_product_name;
        public TextView Title;

        //*** code added ***
        public TextView Abstract;

        public TextView date;


        public ViewHolder(@NonNull View v) {
            super(v);
            picture = v.findViewById(R.id.newsPicture);
            Abstract = v.findViewById(R.id.newsheadline);
            Title = v.findViewById(R.id.newsTitle);
            date = v.findViewById(R.id.newsDate);
            details = v.findViewById(R.id.layoutDetails);


        }
    }



    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public AdapterNyTimes.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.newlayout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {



        holder.details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(mContext, DetailsActivity.class);
                intent.putExtra("title",media.getResults().get(position).getTitle() );
                intent.putExtra("url",media.getResults().get(position).getMediaMetadata().get(0).getPictures().get(position).getUrl() );
                intent.putExtra("detail",media.getResults().get(position).getByline() );
                intent.putExtra("date",media.getResults().get(position).getPublished_date() );
               mContext. startActivity(intent);


            }
        });

        try {

            String url =media.getResults().get(position).getMediaMetadata().get(0).getPictures().get(position).getUrl();
            Glide.with(mContext).load(media.getResults().get(position).getMediaMetadata().get(0).getPictures().get(position).getUrl()).into(holder.picture);



            holder.Title.setText(media.getResults().get(position).getTitle());
            String ntilte =media.getResults().get(position).getTitle();
            holder.Abstract.setText(media.getResults().get(position).getByline());
            String nline=media.getResults().get(position).getByline();
            holder.date.setText(media.getResults().get(position).getPublished_date());




        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return media.getResults().size();
    }




 /*   public static boolean isNetworkAvalible(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
      //  NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
       // return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }*/

}

