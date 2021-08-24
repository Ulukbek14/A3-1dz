package com.example.a3_1dz.ui.fragment;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a3_1dz.R;
import com.example.a3_1dz.model.Books;

import java.util.ArrayList;

public class SharedViewModel extends ViewModel {

    public MutableLiveData<ArrayList<Books>> listMutableLiveData = new MutableLiveData<>();
    int pos ;
    ArrayList<Books> list = new ArrayList<>() ;

    public void onSetPost(int pos){
        this.pos = pos;
    }


    public void getBooks() {
        list.add(new Books(R.drawable.godzilla,"Godzilla","1954-2021"));
        list.add(new Books(R.drawable.kong,"Kong","1933_2021"));
        list.add(new Books(R.drawable.mechagodzilla,"Mechagodzilla","1974_2021"));
        list.add(new Books(R.drawable.mothra,"Mothra","1961 - 2019"));
        list.add(new Books(R.drawable.rodan,"Rodan","1956-2019"));
        list.add(new Books(R.drawable.ghidorah,"Ghidorah","1964-2019"));
        listMutableLiveData.setValue(list);
    }
}
