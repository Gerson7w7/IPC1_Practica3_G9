
package objetos;

public class Curso {
    private int id;
    private int codigo;
    private String nombre;
    
    
    private Alumno[] alumnos;
    //siempre con un contador
    private int calumnos;

    public Curso(int id, int codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        
        
        this.alumnos = new Alumno[200];
        this.calumnos = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
