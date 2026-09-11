package sistemcompra.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    public LocalDate fechaCompra;
    List<DetalleCompra> detalle;
    double  totalCompra;
    String nombreCliente;

    
    public Compra(String nombreC) {
        this.fechaCompra = LocalDate.now();
        this.detalle = new ArrayList<>();
        this.totalCompra = 0;
        this.nombreCliente = nombreC;
    }

    public double calcularTotal(){
        totalCompra = detalle.stream().mapToDouble(c->c.getSubtotal()).sum();
        return totalCompra;
    }

    public void agregarDetalle( DetalleCompra detalleCompra){
        detalle.add(detalleCompra);
    }


    @Override 
    public String toString(){
        return "Nombre del Cliente: "+nombreCliente+"\n"+"Fecha de la Compra: "+fechaCompra+"\n"+detalle+"\nEl total de esta compra ha sido de: "+totalCompra;
    }
    // public void setNombreCliente(String nombre) {
    //     this.nombreCliente = nombre;
    // }


/*     public Compra(Producto producto) {
        this.fechaCompra = LocalDateTime.now();
        this.producto = producto;
    }
    public double calcularTotal(){
        return producto.precio * producto.cantidad;
    }

    public void mostrarInformacion(){
        System.out.println(fechaCompra);
        System.out.println("Tu producto es: "+producto.nombre+ "\nCantidad: "+producto.cantidad+"\nprecio x unidad: "+producto.precio+"\nTotal: "+calcularTotal());
        System.out.println("Con mucho gusto"); */
}

