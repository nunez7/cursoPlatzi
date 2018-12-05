package mx.nunez.platzigram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import java.util.ArrayList;

import mx.nunez.platzigram.R;
import mx.nunez.platzigram.adapter.PictureAdapterRecyclerView;
import mx.nunez.platzigram.model.Picture;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Creamos la vista
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        showToolbar("", false, view);

        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecyclerSearch);
        GridLayoutManager gridLayout = new GridLayoutManager(getContext(), buidPictures().size());
        gridLayout.setOrientation(GridLayout.HORIZONTAL);



        picturesRecycler.setLayoutManager(gridLayout);
        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buidPictures(),R.layout.cardview_picture_horizontal, getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }
    public ArrayList<Picture> buidPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://www.aprendeyjuegaconea.com/Galeria/200px-3.jpg", "Juan Sepulveda", "4 días", "3 Me gusta"));
        pictures.add(new Picture("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Elizondo_trinquete.jpg/200px-Elizondo_trinquete.jpg", "Abril Marquez", "2 días", "10 Me gusta"));
        pictures.add(new Picture("https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Wimbledon_2005%2C_Wheelchair.jpg/200px-Wimbledon_2005%2C_Wheelchair.jpg", "María Soto", "7 días", "5 Me gusta"));
        pictures.add(new Picture("http://www.aprendeyjuegaconea.com/Galeria/200px-3.jpg", "Juan Sepulveda", "4 días", "3 Me gusta"));
        pictures.add(new Picture("https://upload.wikimedia.org/wikipedia/commons/thumb/1/15/Elizondo_trinquete.jpg/200px-Elizondo_trinquete.jpg", "Abril Marquez", "2 días", "10 Me gusta"));
        pictures.add(new Picture("https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Wimbledon_2005%2C_Wheelchair.jpg/200px-Wimbledon_2005%2C_Wheelchair.jpg", "María Soto", "7 días", "5 Me gusta"));

        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        SearchView search = (SearchView) view.findViewById(R.id.searchView);
        //((AppCompatActivity)getActivity()).setContentView(search);

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
