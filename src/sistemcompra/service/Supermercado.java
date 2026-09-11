package sistemcompra.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import sistemcompra.model.Compra;
import sistemcompra.model.Producto;
import sistemcompra.utils.TextoUtils;

public class Supermercado {
    private String nombre;
    private List<Producto> productos;
    private List<Compra> compras;

    public Supermercado(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
        this.compras = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public void agregarCompra(Compra compra) {
        compras.add(compra);
    }

    public void mostrarProductos() {
        productos.forEach(System.out::println);
    }

    public Optional<Producto> buscarPorId(int id) {
        return productos.stream().filter(p -> p.getIdProducto() == id).findFirst();
    }

    public Producto buscarPorNombre(String nombre) {
        return productos.stream().filter(p -> p.getNombre().equalsIgnoreCase(TextoUtils.quitarTildes(nombre)))
                .findFirst().orElse(null);
    }

    public List<Producto> buscarPorCategoria(String categoria) {
        return productos.stream().filter(p -> p.getCategoria().equalsIgnoreCase(TextoUtils.quitarTildes(categoria)))
                .toList();
    }

    public void actualizarProducto(
            int id,
            String nuevoNombre,
            Double nuevoPrecio,
            Integer nuevaCantidad,
            String nuevaCategoria) {

        Optional<Producto> resultado = buscarPorId(id);

        resultado.ifPresentOrElse(
                producto -> {

                    if (nuevoNombre != null) {
                        producto.setNombre(nuevoNombre);
                    }
                    if (nuevoPrecio != null) {
                        producto.setPrecio(nuevoPrecio);
                    }
                    if (nuevaCantidad != null) {
                        producto.setCantidad(nuevaCantidad);
                    }
                    if (nuevaCategoria != null) {
                        producto.setCategoria(nuevaCategoria);
                    }

                    System.out.println("Producto actualizado correctamente");
                },
                () -> System.out.println("Producto no encontrado"));
    }

    public void eliminarProducto(Producto producto) {
        productos.remove(producto);
    }

    public void mostrarCompras() {
        compras.forEach(System.out::println);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Producto> getProductos() {
        return productos;
    }

}
