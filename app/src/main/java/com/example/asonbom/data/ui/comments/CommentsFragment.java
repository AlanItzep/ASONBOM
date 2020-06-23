package com.example.asonbom.data.ui.comments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.asonbom.R;

public class CommentsFragment extends Fragment{

    private CommentsViewModel commentsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        commentsViewModel =
                ViewModelProviders.of(this).get(CommentsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_comments, container, false);
        final TextView textView = root.findViewById(R.id.text_comments);
        commentsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
