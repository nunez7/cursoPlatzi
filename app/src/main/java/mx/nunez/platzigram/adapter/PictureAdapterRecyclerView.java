package mx.nunez.platzigram.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mx.nunez.platzigram.R;
import mx.nunez.platzigram.model.Picture;
import mx.nunez.platzigram.view.PictureDetailActivity;

/**
 * Created by nunez-pc on 29/01/2018.
 */

public class PictureAdapterRecyclerView  extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{
    private ArrayList<Picture> pictures;
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creamos el view en dónde insertaremos el código a mostrar
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        //Se trabaja la lista de elementos, paso de datos a la lista
        Picture picture = pictures.get(position);
        holder.usernameCard.setText(picture.getUsername());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLikeNumber());
        //Implementando imagenes de internet, en el manifest se debe dar permiso para conectar a Internet
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        //Eventos en las cards/imagenes
        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, PictureDetailActivity.class);

                //Transition
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    //Efecto para la actividad
                    activity.getWindow().setExitTransition(explode);
                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(activity, view, activity.getString(R.string.transitionname_picture)).toBundle());
                }else{
                    activity.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder{

        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;

        public PictureViewHolder(View itemView) {
            super(itemView);
            pictureCard = (ImageView) itemView.findViewById(R.id.picture_card);
            usernameCard = (TextView) itemView.findViewById(R.id.username_card);
            timeCard = (TextView) itemView.findViewById(R.id.time_card);
            likeNumberCard = (TextView) itemView.findViewById(R.id.like_numbercard);


        }
    }
}
