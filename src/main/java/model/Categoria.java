
package model;


public class Categoria {
    private int id;
    private String nombre;
    private String created;
    private String update;

    public Categoria() {
    }

    public Categoria(int id, String nombre, String created, String update) {
        this.id = id;
        this.nombre = nombre;
        this.created = created;
        this.update = update;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
    
    
}
