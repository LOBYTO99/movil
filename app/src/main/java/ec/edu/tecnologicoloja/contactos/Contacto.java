package ec.edu.tecnologicoloja.contactos;

// Contact.java

public class Contacto {
    private String nom;
    private String num;
    private String imageUrl;

    public Contacto(String nom, String num) {
        this.nom = nom;
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public String getNum() {
        return num;
    }

    // Nueva propiedad para la URL de la imagen

    // Constructor y otros métodos

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

