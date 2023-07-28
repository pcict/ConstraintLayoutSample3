package com.websarva.wings.android.constraintlayoutsample3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btConfirm = findViewById(R.id.btConfirm);
        Button btSend = findViewById(R.id.btSend);
        Button btClear = findViewById(R.id.btClear);

        btConfirm.setOnClickListener(new BtClickListener());
        btSend.setOnClickListener(new BtClickListener());
        btClear.setOnClickListener(new BtClickListener());

    }

    private class BtClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            EditText etName = findViewById(R.id.etName);
            EditText etMail = findViewById(R.id.etMail);
            EditText etComment = findViewById(R.id.etComment);

            int id = view.getId();

            if(id == R.id.btConfirm){
                InputConfirmDialogFragment inputConfirmDialog = new InputConfirmDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putString("etName", etName.getText().toString());
                bundle.putString("etMail", etMail.getText().toString());
                bundle.putString("etComment", etComment.getText().toString());
                inputConfirmDialog.setArguments(bundle);

                inputConfirmDialog.show(getSupportFragmentManager(), "InputConfirmDialogFragment");

            }
            else if(id == R.id.btSend){
                Toast.makeText(MainActivity.this,"送信しました",Toast.LENGTH_SHORT).show();

            }
            else if(id == R.id.btClear){
                etName.setText("");
                etMail.setText("");
                etComment.setText("");
            }

        }
    }
}