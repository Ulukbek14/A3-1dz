package com.example.a3_1dz.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_1dz.R;
import com.example.a3_1dz.databinding.FragmentDetailBinding;


public class DetailFragment extends Fragment {

    FragmentDetailBinding binding;
    SharedViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        binding = FragmentDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDataInPosition();

    }

    private void getDataInPosition() {
        viewModel.onSetPost(viewModel.pos);
        binding.tvTitle.setText(viewModel.list.get(viewModel.pos).getTitle());
        binding.tvDescription.setText(viewModel.list.get(viewModel.pos).getDescription());
        binding.iv.setImageResource(viewModel.list.get(viewModel.pos).getImage());
    }
}