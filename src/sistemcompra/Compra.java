package sistemcompra;

import java.time.LocalDateTime;

public class Compra {
    public LocalDateTime fechaCompra;
    Producto producto;

    public Compra(Producto producto) {
        this.fechaCompra = LocalDateTime.now();
        this.producto = producto;
    }
    public double calcularTotal(){
        return producto.precio * producto.cantidad;
    }

    public void mostrarInformacion(){
        System.out.println(fechaCompra);
        System.out.println("Tu producto es: "+producto.nombre+ "\nCantidad: "+producto.cantidad+"\nprecio x unidad: "+producto.precio+"\nTotal: "+calcularTotal());
        System.out.println("Con mucho gusto");
    }
}
