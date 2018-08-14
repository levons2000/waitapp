package com.example.hp.waitingdialog.activities;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.hp.waitingdialog.R;
import com.example.hp.waitingdialog.fragments.ProgressDialogFragment;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_FOR_DIALOG = "key";
    private ImageButton imageButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListener();
    }

    private void findViews(){
        imageButton = findViewById(R.id.run_dialog);
        editText = findViewById(R.id.input_time);
    }

    private void setListener(){
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString(KEY_FOR_DIALOG, editText.getText().toString());
                final ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
                progressDialogFragment.setArguments(bundle);
                progressDialogFragment.show(getSupportFragmentManager(), "tag");

            }
        });
    }
}
