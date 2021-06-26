package com.example.main.ui.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.didi.drouter.annotation.Router;
import com.didi.drouter.api.DRouter;
import com.example.common.BaseApplication;
import com.example.main.R;

import java.util.Objects;

@Router(path = "/home_fragment")
public class HomeFragment extends Fragment {
//    private FragmentManager fragmentManager;
    private Context context;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        fragmentManager = getParentFragmentManager();
        context = BaseApplication.getContext();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ImageView iv_activity_ui = getActivity().findViewById(R.id.iv_activity_ui);
        iv_activity_ui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/ui_activity").start();
            }
        });
        LinearLayout lv_activity_ui = getActivity().findViewById(R.id.lv_activity_ui);
        lv_activity_ui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/ui_activity").start();
            }
        });

        ImageView iv_activity_helper = getActivity().findViewById(R.id.iv_activity_helper);
        iv_activity_helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/helper_activity").start();
            }
        });
        LinearLayout lv_activity_helper = getActivity().findViewById(R.id.lv_activity_helper);
        lv_activity_helper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/helper_activity").start();

            }
        });
        ImageView iv_activity_media = getActivity().findViewById(R.id.iv_activity_media);
        iv_activity_media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/media_activity").start();
            }
        });
        LinearLayout lv_activity_media = getActivity().findViewById(R.id.lv_activity_media);
        lv_activity_media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/media_activity").start();

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}