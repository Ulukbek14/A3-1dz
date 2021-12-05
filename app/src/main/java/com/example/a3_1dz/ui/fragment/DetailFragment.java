package com.example.a3_1dz.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_1dz.databinding.FragmentDetailBinding;
import com.example.a3_1dz.ui.fragment.task.TaskViewModel;

public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializationData();
    }

    private void initializationData() {
        TaskViewModel viewModel = new ViewModelProvider(requireActivity()).get(TaskViewModel.class);
        viewModel.getSelected().observe(getViewLifecycleOwner(), taskModel -> {
            binding.detailTvName.setText(taskModel.
                    getName());
            binding.detailTvDescription.setText(taskModel.
                    getDescription());
            binding.detailIv.setImageResource(taskModel.
                    getImage());
        });
    }
}