package com.example.asonbom.data.ui.comments;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CommentsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CommentsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is comments fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}