package ec.edu.tecnologicoloja.contactos;

import static android.content.Intent.getIntent;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetallesDelContacto extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalles);

        TextView nameTextView = findViewById(R.id.text_view_name_details);
        TextView phoneTextView = findViewById(R.id.text_view_phone_details);

        // Obtener datos del intent
        Intent intent = getIntent();
        if (intent != null) {
            String nom = intent.getStringExtra("nom");
            String num = intent.getStringExtra("num");

            // Imprimir información para verificar si los datos son nulos
            Log.d("DetallesDelContacto", "Nom: " + nom);
            Log.d("DetallesDelContacto", "Num: " + num);

            // Verificar si los datos son nulos
            if (nom != null && num != null) {
                // Actualizar las vistas con los detalles del contacto
                nameTextView.setText(nom);
                phoneTextView.setText(num);
            } else {
                // Imprimir un mensaje de error o realizar alguna acción adecuada
                Log.e("DetallesDelContacto", "Datos nulos");
            }
        }
    }

}

