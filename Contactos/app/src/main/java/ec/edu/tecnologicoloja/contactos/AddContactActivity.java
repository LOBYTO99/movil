package ec.edu.tecnologicoloja.contactos;

// AddContactActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        final EditText nameEditText = findViewById(R.id.edit_text_name);
        final EditText phoneEditText = findViewById(R.id.edit_text_phone);
        Button saveButton = findViewById(R.id.btn_save_contact);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom = nameEditText.getText().toString();
                String num = phoneEditText.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("nom", nom);
                resultIntent.putExtra("num", num);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
