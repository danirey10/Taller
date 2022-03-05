package taller;

/**
 *
 * @author xavi
 */
public class Diagnostico {
    public enum Status {PENDENTE,EN_TRAMITE,DIAGNOSTICADO,ACEPTADO,ANULADO,REPARADO,PAGADO};
    private final String codigo;  // Codigo de diagnostico
    private final Producto producto;  // Producto a diagnosticar
    private final Cliente cliente;    // Cliente
    private final String descricion_problema; // Descrición do problema
    private String descricion_diagnostico;  // Descrición da solución
    private Status estado;  // Estado do diagnóstico
    private final Reparacion[] lista_reparacions; // Reparacións necesarias
    private int nreparacions;
    
    /**
    * @param cliente Pide un cliente
    * @see Cliente 
    * @param producto Pide un producto
    * @see Producto
    * @param codigo Pide un código
    * @param descricion La descripción
    */
    
    public Diagnostico(Cliente cliente,Producto producto,String codigo,String descricion) {
        this.cliente=cliente;
        this.producto=producto;
        // Validar codigo
        this.codigo=codigo;
        this.descricion_problema=descricion;
        this.estado=Status.PENDENTE;
        this.lista_reparacions=new Reparacion[20]; // Maximo 20 reparacions
        this.nreparacions=0;
    }
    
    public void addReparacion(Reparacion r) {
        lista_reparacions[nreparacions]=r;
        nreparacions++;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public Producto getProducto() {
        return producto;
    }
    
    public String getProblema() {
        return descricion_problema;
    }
    
    public int getNumReparacions() {
        return this.nreparacions;
    }
    
    public Reparacion getReparacion(int idx) {
        return lista_reparacions[idx];
    }

    public String getDiagnostico() {
        return descricion_diagnostico;
    }

    public void setDiagnostico(String descricion_diagnostico) {
        this.descricion_diagnostico = descricion_diagnostico;
    }

    public Status getEstado() {
        return estado;
    }

    public void setEstado(Status estado) {
        this.estado = estado;
    }
    
    public double getImporte() {
        double total=0;
        int nr=getNumReparacions();
        for(int idx=0;idx<nr;idx++) total+=lista_reparacions[idx].getImporte();
        return total;
    }
    
}
