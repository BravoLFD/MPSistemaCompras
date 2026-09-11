package sistemcompra.model;

public class DetalleCompra {
    private Producto producto;
    private int cantidad;
    private double subTotal;

    public DetalleCompra(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subTotal = calcularSubtotal();
    }

    public double calcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getSubtotal() {
        return subTotal;
    }

    @Override
    public String toString() {
        return producto.getNombre() +
                " | Cantidad: " + cantidad +
                " | Subtotal: $" + subTotal+"\n";
    }
}
