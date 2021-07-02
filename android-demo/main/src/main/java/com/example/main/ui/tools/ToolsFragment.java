package com.example.main.ui.tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.fragment.app.Fragment;

import com.didi.drouter.api.DRouter;
import com.example.main.R;

public class ToolsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tools, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        TextView tools_intent = (TextView)getActivity().findViewById(R.id.tools_intent);
        tools_intent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/intent_activity").start();
            }
        });
        TextView tools_download = (TextView)getActivity().findViewById(R.id.tools_download);
        tools_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/download_activity").start();
            }
        });
        TextView tools_scan = (TextView)getActivity().findViewById(R.id.tools_scan);
        tools_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/scan_activity").start();
            }
        });
        TextView tools_transfer = (TextView)getActivity().findViewById(R.id.tools_transfer);
        tools_transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DRouter.build("/transfer_activity").start();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }
}