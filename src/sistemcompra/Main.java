package sistemcompra;

import java.util.List;
import java.util.Optional;

import sistemcompra.model.Compra;
import sistemcompra.model.DetalleCompra;
import sistemcompra.model.Producto;
import sistemcompra.service.Supermercado;
import sistemcompra.utils.ScannerUtils;

public class Main {
    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_ID = 3;
    public static final int BUSCAR_NOMBRE = 4;
    public static final int BUSCAR_CATEGORIA = 5;
    public static final int ACTUALIZAR = 6;
    public static final int ELIMINAR = 7;
    public static final int CREAR_COMPRA = 8;
    public static final int MOSTRAR_COMPRA = 9;
    public static final int SALIR = 10;
    public static final String NOMBRE_SUPERMERCADO = "Salsamentaria Doña Anita";

    public static void main(String[] args) {
        Supermercado superMercado = new Supermercado(NOMBRE_SUPERMERCADO);
        while (true) {
            int opcionMenu = ScannerUtils.capturarNum("""
                    Menu:
                    1.Agregar Producto
                    2.Mostrar Productos
                    3.Buscar Por ID_Producto
                    4.Buscar Por Nombre del Producto
                    5.Bucar por Categoria
                    6.Actualizar (Nombre,Precio,Cantidad,Categoria)
                    7.Eliminar Producto
                    8.Crear Compra
                    9.Mostrar Compra
                    10.Salir del Sistema
                    """);
            switch (opcionMenu) {
                case AGREGAR -> {
                    int idProducto = ScannerUtils.capturarNum("Ingrese el ID del producto");
                    String nombre = ScannerUtils.capturarTexto("Ingrese el nombre del producto");
                    Double precio = ScannerUtils.capturarDecimal("Ingrese el precio del producto");
                    int cantidad = ScannerUtils.capturarNum("Ingrese el cantidad del producto");
                    String categoria = ScannerUtils.capturarTexto("Ingrese la categoria del producto");

                    superMercado.agregarProducto(new Producto(nombre, precio, cantidad, categoria, idProducto));
                    System.out.println("Agregado Correctamente");
                }

                case MOSTRAR_TODO -> superMercado.mostrarProductos();

                case BUSCAR_ID -> {
                    int bId = ScannerUtils.capturarNum("Introduce el ID del Producto a Buscar");
                    Optional<Producto> producto = superMercado.buscarPorId(bId);

                    producto.ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println("Producto no encontrado"));
                }
                case BUSCAR_NOMBRE -> {
                    String bNombre = ScannerUtils.capturarTexto("Introduce el nombre del Producto a Buscar");
                    Producto producto = superMercado.buscarPorNombre(bNombre);
                    if (producto != null) {
                        System.out.println(producto);
                    } else {
                        System.out.println("Error el producto a buscar no esta en " + superMercado.getNombre());
                    }
                }
                case BUSCAR_CATEGORIA -> {
                    String bCategoria = ScannerUtils.capturarTexto("Introduce la categoria a Buscar");
                    List<Producto> categoriaProducto = superMercado.buscarPorCategoria(bCategoria);
                    System.out.println(categoriaProducto.size() + " encontrados para la categoria " + bCategoria);
                    categoriaProducto.forEach(System.out::println);
                }

                case ACTUALIZAR -> {
                    int id = ScannerUtils.capturarNum("Introduce el ID del producto a actualizar");

                    Optional<Producto> producto = superMercado.buscarPorId(id);

                    producto.ifPresentOrElse(
                            p -> {
                                System.out.println("Producto encontrado:");
                                System.out.println(p);

                                int opcion = ScannerUtils.capturarNum("""
                                        ¿Qué deseas actualizar?
                                        1. Nombre
                                        2. Precio
                                        3. Cantidad
                                        4. Categoría
                                        5. Todo
                                        """);

                                switch (opcion) {
                                    case 1 -> {
                                        String nuevoNombre = ScannerUtils.capturarTexto(
                                                "Introduce el nuevo nombre");
                                        superMercado.actualizarProducto(id, nuevoNombre, null, null, null);
                                    }

                                    case 2 -> {
                                        double nuevoPrecio = ScannerUtils.capturarDecimal(
                                                "Introduce el nuevo precio");
                                        superMercado.actualizarProducto(id, null, nuevoPrecio, null, null);
                                    }

                                    case 3 -> {
                                        int nuevaCantidad = ScannerUtils.capturarNum(
                                                "Introduce la nueva cantidad");
                                        superMercado.actualizarProducto(id, null, null, nuevaCantidad, null);
                                    }

                                    case 4 -> {
                                        String nuevaCategoria = ScannerUtils.capturarTexto(
                                                "Introduce la nueva categoría");
                                        superMercado.actualizarProducto(id, null, null, null, nuevaCategoria);
                                    }

                                    case 5 -> {
                                        String nuevoNombre = ScannerUtils.capturarTexto(
                                                "Nuevo nombre");
                                        double nuevoPrecio = ScannerUtils.capturarDecimal(
                                                "Nuevo precio");
                                        int nuevaCantidad = ScannerUtils.capturarNum(
                                                "Nueva cantidad");
                                        String nuevaCategoria = ScannerUtils.capturarTexto(
                                                "Nueva categoría");

                                        superMercado.actualizarProducto(
                                                id,
                                                nuevoNombre,
                                                nuevoPrecio,
                                                nuevaCantidad,
                                                nuevaCategoria);
                                    }

                                    default -> System.out.println("Opción inválida");
                                }
                            },
                            () -> System.out.println("Producto no encontrado"));
                }

                case ELIMINAR -> {
                    int id = ScannerUtils.capturarNum("Introduce el ID del producto a eliminar");
                    Optional<Producto> producto = superMercado.buscarPorId(id);
                    producto.ifPresentOrElse(p -> {
                        superMercado.eliminarProducto(p);
                        System.out.println("Producto eliminado");
                    },
                            () -> System.out.println("No existe el producto en el" + superMercado.getNombre()));
                }

                case CREAR_COMPRA -> {
                    String nombreC = ScannerUtils.capturarTexto("Introduce el nombre del cliente");
                    Compra compra = new Compra(nombreC);
                    boolean registrarCompra = true;

                    while (registrarCompra) {

                        int id = ScannerUtils.capturarNum(
                                "Introduce el ID del producto");

                        Optional<Producto> producto = superMercado.buscarPorId(id);

                        producto.ifPresentOrElse(
                                p -> {
                                    int cantidad = ScannerUtils.capturarNum(
                                            "Introduce la cantidad a comprar");

                                    DetalleCompra detalle = new DetalleCompra(p, cantidad);

                                    compra.agregarDetalle(detalle);

                                    System.out.println("Producto agregado a la compra");
                                },
                                () -> System.out.println("Producto no encontrado"));

                        int continuar = ScannerUtils.capturarNum("""
                                ¿Desea agregar otro producto?
                                1. Sí
                                2. No
                                """);

                        if (continuar == 2) {
                            registrarCompra = false;
                        }
                    }

                    compra.calcularTotal();
                    superMercado.agregarCompra(compra);

                    System.out.println("Compra creada correctamente");
                    System.out.println(compra);
                }

                case MOSTRAR_COMPRA -> {
                    superMercado.mostrarCompras();
                }
                case SALIR -> System.exit(0);
            }
        }
    }
}
