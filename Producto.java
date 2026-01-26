public class Producto {
    
    private String codigo;
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor Vacio
    public Producto(){
        this.codigo = "";
        this.nombre = "";
        this.precio = 0.0;
        this.cantidad = 0;


    }

    // Constructor con parametros
    public Producto(String codigo, String nombre, double precio, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;

        if (precio >= 0){
            this.precio = precio;
        }
        else {
            this.precio = 0.0;
        }

        if (cantidad >= 0){
            this.cantidad = cantidad;
        } 
        else {
            this.cantidad = 0;
        }
    }

    // Getters y Setters 
    public String getCodigo(){
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre(){
        return nombre;
    }

    public voidd setNombre(String nombre){
        if (nombre != null && !nombre.equals("")) {
            this.nombre = nombre;
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0){
            this.precio = precio;
        }
    }

    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        }
    }


    // Metodos de negocio

    public double calcularValorTotal() {
        return precio * cantidad;
    }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje >= 0 &&  porcentaje <= 100) {
            double descuento = precio * (porcentaje / 100);
            precio = precio - descuento;
        }
    }

    public boolean hayStock() {
        return cantidad > 0;
    }

    public void agregarStock(int cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }
    }

    public boolean retirarStock(int cantidad) {
        if (cantidad > 0 && this.cantidad >= cantidad) {
            this.cantidad -= cantidad;
            return true;
        }
        return false;
    }

    public void mostrarInfo(){
        System.out.println("-------------------------------------------");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Precio: $" + precio);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Valor Total: $" + calcularValorTotal());

        if (hayStock()) {
            System.out.println("Stock: Disponible");
        } else {
            System.out.println("Stock: Sin stock");
        }

        System.out.println("=================================");
    }
}