package ec.edu.tecnologicoloja.contactos;

// MainActivity.java

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ContactAdapter.OnContactClickListener {

    private final List<Contacto> contactList = new ArrayList<>();
    private static final int ADD_CONTACT_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view_contacts);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Crear instancias de Contact y agregarlas a la lista
        Contacto contact1 = new Contacto("Nombre 1", "1234567890");
        contact1.setImageUrl("https://www.ejemplo.com/imagen1.jpg");
        contactList.add(contact1);

        Contacto contact2 = new Contacto("Nombre 2", "9876543210");
        contact2.setImageUrl("https://www.ejemplo.com/imagen2.jpg");
        contactList.add(contact2);

        String imageUrl = "https://via.placeholder.com/150";
        Contacto contact = new Contacto("Ejemplo", "1234567890");
        contact.setImageUrl(imageUrl);
        contactList.add(contact);

        ContactAdapter adapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(adapter);

        Button addButton = findViewById(R.id.btn_add_contact);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivityForResult(intent, ADD_CONTACT_REQUEST);
            }
        });
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_CONTACT_REQUEST && resultCode == RESULT_OK) {
            String nom = data.getStringExtra("nom");
            String num = data.getStringExtra("num");

            // Agregar el nuevo contacto a la lista
            contactList.add(new Contacto(nom, num));

            // Notificar al adaptador sobre el cambio en la lista de contactos
            RecyclerView recyclerView = findViewById(R.id.recycler_view_contacts);
            ContactAdapter adapter = (ContactAdapter) recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onContactClick(Contacto contact) {
        Log.d("MainActivity", "Clic en " + contact.getNom());
        Intent intent = new Intent(MainActivity.this, DetallesDelContacto.class);
        intent.putExtra("nom", contact.getNom());
        intent.putExtra("num", contact.getNum());
        intent.putExtra("imageUrl", contact.getImageUrl());
        startActivity(intent);
    }
}

