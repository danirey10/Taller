package taller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author xavi
 */
public class Factura {
    private static final String NIE_EMPRESA="2332323F";
    private static final String NOME_TALLER="Taller S.L.";
    
    private final String codigo;
    private LocalDate datafactura;
    private final Diagnostico diagnostico;
    
    public Factura(String codigo,Diagnostico diagnostico) throws Exception {
        this.codigo=comprobaCodigo(codigo);
        if (diagnostico.getEstado()!=Diagnostico.Status.PAGADO) throw new Exception("Pago pendente");
        this.diagnostico=diagnostico;
        this.datafactura=LocalDate.now();
    }
    
    public String imprimeFactura() {
        Cliente cl=diagnostico.getCliente();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/YYYY");
        double total=diagnostico.getImporte();
        double ive=total*0.21;
        
        String strfact  =   "Factura: "+codigo+"  Fecha: "+formatter.format(datafactura)+"\n"+
                            NIE_EMPRESA+" "+NOME_TALLER+"\n\n"+
                            cl.getDni()+" - "+cl.getApelidosenome()+"\n"+
                            cl.getDireccion()+"\n"+
                            cl.getEmail()+" - "+cl.getTelefono()+"\n\n"+
                            "Reparación: "+diagnostico.getProblema()+"\n"+
                            "Diagnóstico: "+diagnostico.getDiagnostico()+"\n\n"+
                            "Lista de Conceptos Facturados\n"+
                            detalleFactura()+"\n"+
                            "IVE (21%): "+String.format("%.4f",ive)+"\nTOTAL: "+String.format("%.4f",(total+ive));
        return strfact;
    }
    
    private String detalleFactura() {
        String lineafac="";
        int nr=diagnostico.getNumReparacions();
        for(int idx=0;idx<nr;idx++) lineafac+=diagnostico.getReparacion(idx)+"\n";
        return lineafac;
    }
    
    private String comprobaCodigo(String codigo) throws Exception {
        try {
            char letra=codigo.toUpperCase().charAt(0);
            if (letra!='F') throw new Exception("Codigo de factura erróneo");
            Integer.parseInt(codigo.substring(1));
        } catch(IndexOutOfBoundsException | NumberFormatException e) {
            throw new Exception("Código de factura erróneo");
        }
        return codigo;
    }
    
    
    public static void main(String[] args) throws Exception {
        Cliente cl=new Cliente("36073287A","Cliente de Test","mail@cliente","suKasa","7847348");
        Producto pr=new Producto("PR2323","Producto de Prueba");
        
        Reparacion r=new Reparacion("R99","Pegado con cinta americana",15,20.12);
        Material m=new Material("M382347","Cinta Americana",12.23);
        r.addMaterial(m);
        
        Diagnostico d=new Diagnostico(cl,pr,"D4545","Se rompió el asa");
        d.addReparacion(r);
        d.setDiagnostico("Es reparable con cienta americana");
        
        d.setEstado(Diagnostico.Status.PAGADO);
        Factura f=new Factura("F0001",d);
        System.out.println(f.imprimeFactura());
    }
}
