package taller;

/**
 *
 * @author xavi
 */
public class Reparacion {
    private final String codigo;
    private final Material[] material;
    private final String descricion;
    private int minutos;
    private double prezohora;
    private int cmaterial;
    
    public Reparacion(String codigo,String descricion,int minutos,double prezohora) {
        // Validar Codigo
        this.codigo=codigo;
        this.descricion=descricion;
        this.minutos=minutos;
        this.prezohora=prezohora;
        this.material=new Material[10]; // Máximo 10 materiais
        this.cmaterial=0;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricion() {
        return descricion;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public double getPrezohora() {
        return prezohora;
    }

    public void setPrezohora(float prezohora) {
        this.prezohora = prezohora;
    }
    
    public void addMaterial(Material m) {
        // Engadimos o Material ao atributo material
        material[cmaterial]=m;
        cmaterial++;
    }
    
    public Material getMaterial(int idx) {
        // Retornamos o material idx
        return material[idx];
    }
    
    public int getCantidadMaterial() {
        return cmaterial;
    }
    
    public double getImporteMaterial() {
        double total=0;
        for(int idx=0;idx<cmaterial;idx++) {
            total+=material[idx].getPrezo();
        }
        return total;
    }
    
    public double getImporte() {
        return prezohora*(minutos/60.0)+getImporteMaterial();
    }
    
    @Override
    public String toString() {
        double imaterial=getImporteMaterial();
        double mhtotal=prezohora*(minutos/60.0);
        
        return codigo+" - "+descricion+"\n\t"+String.format("Mano de Obra: %.2fh",(minutos/60.0))+"*"+
               String.format("%.4f€/h",prezohora)+" ("+mhtotal+"€) \t"+String.format("Material: %.4f€",imaterial)+"\t"+
               String.format("Total: %.4f€", (mhtotal+imaterial));
    }
}
