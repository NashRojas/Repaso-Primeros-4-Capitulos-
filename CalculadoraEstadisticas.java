public class CalculadoraEstadisticas {

    // Calcular precio promedio
    public static double calcularPromedioPrecio(Producto[] productos, int cantidad) {
        double suma = 0;
        int contador = 0;

        for (int i = 0; i < cantidad; i++) {
            if (productos[i].getPrecio() > 0) {
                suma += productos[i].getPrecio();
                contador++;
            }
        }

        if (contador == 0) {
            return 0;
        }

        return suma / contador;
    }

    // Encontrar producto mas caro
    public static Producto encontrarProductoMasCaro(Producto[] productos, int cantidad) {
        if (cantidad == 0) {
            return null;
        }

        Producto masCaro = productos[0];

        for (int i = 1; i < cantidad; i++) {
            if (productos[i].getPrecio() > masCaro.getPrecio()) {
                masCaro = productos[i];
            }
        }

        return masCaro;
    }

    // Encontrar producto mas barato
    public static Producto encontrarProductoMasBarato(Producto[] productos, int cantidad) {
        if (cantidad == 0) {
            return null;
        }

        Producto masBarato = productos[0];

        for (int i = 1; i < cantidad; i++) {
            if (productos[i].getPrecio() < masBarato.getPrecio()) {
                masBarato = productos[i];
            }
        }

        return masBarato;
    }

    // Contar productos por rango de precio
    public static int contarProductosPorRangoPrecio(Producto[] productos, int cantidad, double min, double max) {
        int contador = 0;

        for (int i = 0; i < cantidad; i++) {
            double precio = productos[i].getPrecio();
            if (precio >= min && precio <= max) {
                contador++;
            }
        }

        return contador;
    }

    // Calcular valor promedio del inventario
    public static double calcularValorPromedioInventario(Producto[] productos, int cantidad) {
        if (cantidad == 0) {
            return 0;
        }

        double total = 0;

        for (int i = 0; i < cantidad; i++) {
            total += productos[i].calcularValorTotal();
        }

        return total / cantidad;
    }

    // Mostrar estadisticas completas
    public static void mostrarEstadisticas(Producto[] productos, int cantidad) {
        System.out.println("========================================");
        System.out.println("       ESTADISTICAS DEL INVENTARIO");
        System.out.println("========================================");

        System.out.println("Total de productos: " + cantidad);
        System.out.println("Precio promedio: $" + calcularPromedioPrecio(productos, cantidad));

        Producto masCaro = encontrarProductoMasCaro(productos, cantidad);
        if (masCaro != null) {
            System.out.println("Producto mas caro: " + masCaro.getNombre() + " ($" + masCaro.getPrecio() + ")");
        }

        Producto masBarato = encontrarProductoMasBarato(productos, cantidad);
        if (masBarato != null) {
            System.out.println("Producto mas barato: " + masBarato.getNombre() + " ($" + masBarato.getPrecio() + ")");
        }

        double valorTotal = 0;
        int conStock = 0;
        int sinStock = 0;

        for (int i = 0; i < cantidad; i++) {
            valorTotal += productos[i].calcularValorTotal();

            if (productos[i].hayStock()) {
                conStock++;
            } else {
                sinStock++;
            }
        }

        System.out.println("Valor total inventario: $" + valorTotal);
        System.out.println("Productos con stock: " + conStock);
        System.out.println("Productos sin stock: " + sinStock);
        System.out.println("========================================");
    }
}
