package sistemcompra;

import sistemcompra.utils.ScannerUtils;

public class Main {
   public static void main(String[] args) {
       System.out.println("Bienvenido al menu\n1. Crear producto\n" + "2. Crear compra\n" + "3. Mostrar compra\n" + "4. Salir" );
       int menu = ScannerUtils.capturarNum("Elige la opcion");
       Producto producto = null;
       Compra compra = null;
       
       while  (menu != 4) {

           if (menu == 1){
               String nombre = ScannerUtils.capturarTexto("Ingrese el nombre del producto");
               Double precio = ScannerUtils.capturarDecimal("Ingrese el precio del producto");
               int cantidad =  ScannerUtils.capturarNum("Ingrese el cantidad del producto");
               producto = new Producto(nombre, precio, cantidad);
           }
           if (menu == 2) {
               if (producto == null) {
                   System.out.println("No existe el producto");
               } else {
                   compra = new Compra(producto);
               }
           }
           if (compra == null) {
               System.out.println("No existe una compra");
           } else {
               compra.mostrarInformacion();
           }
           if (menu == 4){
               System.exit(0);
           }
           System.out.println("Bienvenido al menu\n1. Crear producto\n" + "2. Crear compra\n" + "3. Mostrar compra\n" + "4. Salir" );
           menu = ScannerUtils.capturarNum("Elige la opcion");
       }

   }
}
