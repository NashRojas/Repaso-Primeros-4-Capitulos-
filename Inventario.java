public class Inventario {

    private Productos[] productos;
    private int totalProductos;

    public Inventario(){
        productos = new Productos[100];
        totalProductos = 0;
    }

    public boolean agregarProducto(Productos p) {
        if (p == null) {
            return false;
        }

        if (totalProductos >= 100) {
            return false;
        }

        for (int i = 0; i < totalProductos; i++) {
            if (productos[i].getCodigo().equals(p.getCodigo())) {
                return false;
            }
        }

        productos[totalProductos] = p;
        totalProductos++;
        return true;
    }

    // busqueda de producto por codigo
    public Productos buscarProducto(String codigo) {
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                return productos[i];
            }
        }
        return null;
    }

    // Eliminar producto
    public boolean eliminarProducto(String codigo) {
        for (int i = 0; i < totalProductos; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                // desplazar productos
                for (int j = i; j < totalProductos - 1; j++){
                    productos[j] = productos[j + 1];
                }
                productos[totalProductos - 1] = null;
                totalProductos--;
                return true;
            }
        }
        return false;
    }
    
    // calcular valor total de inventario
    public double calcularValorTotal(){
        double total = 0;

        for (int i = 0; i < totalProductos; i++) {
            total += productos[i].calcularValorTotal();
        }
        return total;
    }

    // Listar todos los productos
    public void listarProductos(){
        if (totalProductos == 0) {
            System.out.println("No hay productos en el inventario....");
            return;
        }

        for (int i =0; i <totalProductos; i++) {
            productos[i].mostrarInfo();
        }
    }

    // Listar productos con stock
    public void listarProductosConStock() {
        boolean hayProductos = false;

        for (int i = 0; i < totalProductos; i++) {
            if (productos[i].hayStock()) {
                productos[i].mostrarInfo();
                hayProductos = true;
            }
        }

        if (!hayProductos) {
            System.out.println("No hay productos con stock......");
        }
    }

    // Listar productos sin stock
    public void listarProductosSinStock() {
        boolean hayProductos = false;

        for (int i = 0; i < totalProductos; i++) {
            if (!productos[i].hayStock()) {
                productos[i].mostrarInfo();
                hayProductos = true;
            }
        }

        if (!hayProductos) {
            System.out.println("No hay productos sin stock");
        }
    }

    // aplicar descuento general
    public void aplicarDescuentoGeneral(double porcentaje) {
        for (int i = 0; i < totalProductos; i++) {
            productos[i].aplicarDescuento(porcentaje);
        }
    }

    // Contar productos con stock
    public int contarProductosConStock() {
        int contador = 0;

        for (int i = 0; i < totalProductos; i++) {
            if (productos[i].hayStock()) {
                contador++;
            }
        }

        return contador;
    }

    // Getters  para estadisticas
    public Productos[] getProductos() {
        return productos;
    }

    public int getTotalProductos() {
        return totalProductos;
    }
}
