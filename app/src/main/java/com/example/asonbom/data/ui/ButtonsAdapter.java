package com.example.asonbom.data.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.asonbom.R;
import com.example.asonbom.data.ui.register.Register;

public class ButtonsAdapter extends AppCompatActivity {
    GridLayout buttonsGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_buttons);

        buttonsGrid = findViewById(R.id.grid_view);

        //Set Event
        setSingleEvent(buttonsGrid);
    }

    private void setSingleEvent(GridLayout buttonsGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < buttonsGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) buttonsGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(ButtonsAdapter.this, Register.class);
                    intent.putExtra("info","This is activity from card item index  "+finalI);
                    startActivity(intent);

                }
            });
        }
    }

}
