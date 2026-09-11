package sistemcompra.model;

public class Producto {
    private String nombre;
    private double precio;
    private int cantidad;
    private String categoria;
    private int idProducto;

    public Producto(String nombre, double precio, int cantidad, String categoria, int idProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.idProducto = idProducto;
    }

    @Override 
    public String toString(){
        return "ID: "+idProducto +"| Nombre: "+nombre+"| Precio: "+precio +"| Cantidad: "+cantidad+"| Categoria: "+categoria;
    }

    
    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    
}
