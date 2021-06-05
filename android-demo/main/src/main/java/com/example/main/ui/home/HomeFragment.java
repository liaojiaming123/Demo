package com.example.main.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.didi.drouter.annotation.Router;
import com.didi.drouter.api.DRouter;
import com.example.common.BaseApplication;
import com.example.main.R;
import com.example.main.databinding.FragmentHomeBinding;
//import com.sankuai.waimai.router.Router;
//import com.sankuai.waimai.router.annotation.RouterUri;

@Router(path = "/home_fragment")
//@RouterUri(path = "/home_fragment")
public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        Button home_test = getActivity().findViewById(R.id.home_test);
        home_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/my_activity").start();
//                Router.startUri(BaseApplication.getContext(),"/my_activity");
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}