package sistemcompra;

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
    
}
