import java.util.Scanner;

public class SistemaGestion {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion;

        do {
            System.out.println("========================================");
            System.out.println("  SISTEMA DE GESTION DE PRODUCTOS");
            System.out.println("========================================");
            System.out.println("1. Agregar producto");
            System.out.println("2. Buscar producto por codigo");
            System.out.println("3. Listar todos los productos");
            System.out.println("4. Listar productos con stock");
            System.out.println("5. Listar productos sin stock");
            System.out.println("6. Eliminar producto");
            System.out.println("7. Modificar stock de producto");
            System.out.println("8. Aplicar descuento general");
            System.out.println("9. Mostrar estadisticas");
            System.out.println("10. Calcular valor total del inventario");
            System.out.println("11. Salir");
            System.out.println("========================================");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Ingrese el codigo: ");
                    String codigo = scanner.nextLine();

                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el precio: ");
                    double precio = scanner.nextDouble();

                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = scanner.nextInt();

                    Producto nuevo = new Producto(codigo, nombre, precio, cantidad);

                    if (inventario.agregarProducto(nuevo)) {
                        System.out.println("Producto agregado exitosamente");
                    } else {
                        System.out.println("No se pudo agregar el producto");
                    }
                    
                    break;

                case 2:
                    System.out.print("Ingrese el codigo a buscar: ");
                    codigo = scanner.nextLine();

                    Producto encontrado = inventario.buscarProducto(codigo);

                    if (encontrado != null) {
                        encontrado.mostrarInfo();
                    } else {
                        System.out.println("Producto no encontrado");
                    }
                    break;

                case 3:
                    inventario.listarProductos();
                    break;

                case 4:
                    inventario.listarProductosConStock();
                    break;

                case 5:
                    inventario.listarProductosSinStock();
                    break;

                case 6:
                    System.out.print("Ingrese el codigo del producto a eliminar: ");
                    codigo = scanner.nextLine();

                    if (inventario.eliminarProducto(codigo)) {
                        System.out.println("Producto eliminado correctamente");
                    } else {
                        System.out.println("No se encontro el producto");
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el codigo del producto: ");
                    codigo = scanner.nextLine();

                    Producto prod = inventario.buscarProducto(codigo);

                    if (prod != null) {
                        System.out.println("1. Agregar stock");
                        System.out.println("2. Retirar stock");
                        System.out.print("Seleccione una opcion: ");
                        int opStock = scanner.nextInt();

                        System.out.print("Ingrese la cantidad: ");
                        int cant = scanner.nextInt();

                        if (opStock == 1) {
                            prod.agregarStock(cant);
                            System.out.println("Stock agregado correctamente");
                        } else if (opStock == 2) {
                            if (prod.retirarStock(cant)) {
                                System.out.println("Stock retirado correctamente");
                            } else {
                                System.out.println("No hay suficiente stock");
                            }
                        } else {
                            System.out.println("Opcion invalida");
                        }
                    } else {
                        System.out.println("Producto no encontrado");
                    }
                    break;

                case 8:
                    System.out.print("Ingrese el porcentaje de descuento: ");
                    double descuento = scanner.nextDouble();

                    inventario.aplicarDescuentoGeneral(descuento);
                    System.out.println("Descuento aplicado a todos los productos");
                    break;

                case 9:
                    CalculadoraEstadisticas.mostrarEstadisticas(
                            inventario.getProductos(),
                            inventario.getTotalProductos()
                    );
                    break;

                case 10:
                    double total = inventario.calcularValorTotalInventario();
                    System.out.println("Valor total del inventario: $" + total);
                    break;

                case 11:
                    System.out.println("Gracias por usar el sistema");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opcion != 11);

        scanner.close();
    }
}
