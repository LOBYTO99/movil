package ec.edu.tecnologicoloja.contactos;
// ContactAdapter.java

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide; // Importante: Glide para cargar imágenes

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    private static List<Contacto> contactList ;
    private static OnContactClickListener onContactClickListener;
    public void setOnContactClickListener(OnContactClickListener listener) {
        this.onContactClickListener = listener;
    }

    public interface OnContactClickListener {
        default void onContactClick(Contacto contact) {

        }
    }

    public ContactAdapter(List<Contacto> contactList) {
        ContactAdapter.contactList = contactList;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_item, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
        Contacto contact = contactList.get(position);
        holder.nameTextView.setText(contact.getNom());
        holder.phoneTextView.setText(contact.getNum());

        // Cargar imagen usando Glide
        /*Glide.with(holder.itemView.getContext())
                .load(contact.getImageUrl()) // Reemplaza contact.getImageUrl() con la URL de la imagen del contacto
                .placeholder(R.drawable.default_contact_image) // Imagen de relleno mientras se carga la imagen
                .error(R.drawable.default_contact_image) // Imagen a mostrar si hay un error al cargar la imagen
                .into(holder.contactImageView);*/
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView phoneTextView;
        ImageView contactImageView;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.text_view_name);
            phoneTextView = itemView.findViewById(R.id.text_view_phone);
            contactImageView = itemView.findViewById(R.id.image_view_contact);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onContactClickListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            Contacto clickedContact = contactList.get(position);
                            onContactClickListener.onContactClick(clickedContact);
                        }
                    }
                }
            });
        }
    }
}
