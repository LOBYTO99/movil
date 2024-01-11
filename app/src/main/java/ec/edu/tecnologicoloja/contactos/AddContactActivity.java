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

        final EditText nameEditText = findViewById(R.id.txt_name);
        final EditText phoneEditText = findViewById(R.id.txt_phone);
        Button saveButton = findViewById(R.id.btn_guardar);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String phoneNumber = phoneEditText.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("phoneNumber", phoneNumber);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}
