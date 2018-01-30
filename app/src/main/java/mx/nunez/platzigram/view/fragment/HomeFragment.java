package mx.nunez.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.nunez.platzigram.R;
import mx.nunez.platzigram.adapter.PictureAdapterRecyclerView;
import mx.nunez.platzigram.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Creamos la vista
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        //Mostramos el toolbar
        showToolbar(getResources().getString(R.string.tab_home), false, view);
        //Creamos el RecyclerView
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buidPictures(),R.layout.cardview_picture, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }
    //Método para cargar los datos, puede ir una consulta a BD
    public ArrayList<Picture> buidPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://www.aprendeyjuegaconea.com/Galeria/200px-3.jpg", "Juan Sepulveda", "4 días", "3 Me gusta"));
        pictures.add(new Picture("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Elizondo_trinquete.jpg/200px-Elizondo_trinquete.jpg", "Abril Marquez", "2 días", "10 Me gusta"));
        pictures.add(new Picture("https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Wimbledon_2005%2C_Wheelchair.jpg/200px-Wimbledon_2005%2C_Wheelchair.jpg", "María Soto", "7 días", "5 Me gusta"));
        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
