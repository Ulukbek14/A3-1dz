package com.example.a3_1dz.ui.fragment.task;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a3_1dz.R;
import com.example.a3_1dz.databinding.FragmentTaskBinding;
import com.example.a3_1dz.ui.adapter.TaskAdapter;

public class TaskFragment extends Fragment {

    private FragmentTaskBinding binding;
    private TaskViewModel viewModel;
    private TaskAdapter adapter = new TaskAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onClickListeners();
        initAlization();
        initRecyclerView();
        setUpObserve();
        detail();
    }

    private void initAlization() {
        viewModel = new ViewModelProvider(requireActivity()).
                get(TaskViewModel.class);
    }

    private void detail() {
        adapter.setOnItemClick(model -> {
            TaskViewModel viewModel = new ViewModelProvider(TaskFragment.this.requireActivity()).get(TaskViewModel.class);
            viewModel.setSelected(model);
            TaskFragment.this.navigationСlose();
        });
    }

    private void navigationСlose() {
        NavController navController = Navigation.findNavController(requireActivity(),
                R.id.nav_host_fragment);
        navController.navigate(R.id.detailFragment);
    }


    private void setUpObserve() {
        viewModel.mutableLiveData.observe(getViewLifecycleOwner(), taskModels -> {
            binding.rv.setVisibility(View.VISIBLE);
            adapter.setBooks(taskModels);
            binding.btn.setVisibility(View.GONE);
        });
    }

    private void onClickListeners() {
        binding.btn.setOnClickListener(v -> {
            binding.rv.setVisibility(View.VISIBLE);
            binding.btn.setVisibility(View.GONE);
            viewModel.getListBooks();
        });
    }

    private void initRecyclerView() {
        setViews();
    }

    private void setViews() {
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rv.setAdapter(adapter);
    }
}