package objetos;

public class Alumno {

    private int id;
    private int carnet;
    private String nombre;
    private String fNacimiento;
    private String genero;

    private Curso[] cursos;
    //el contador respectivo
    private int cCursos;

    public Alumno(int id, int carnet, String nombre, String fNacimiento, String genero) {
        this.id = id;
        this.carnet = carnet;
        this.nombre = nombre;
        this.fNacimiento = fNacimiento;
        this.genero = genero;
        
        this.cursos = new Curso[200];
        this.cCursos = 0;
    }

    //Metodo para que al alumno se le llenen sus cursos
    public void AsignarCursos(Curso agregarCurso) {
        getCursos()[getcCursos()] = agregarCurso;
        cCursos++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getfNacimiento() {
        return fNacimiento;
    }

    public void setfNacimiento(String fNacimiento) {
        this.fNacimiento = fNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
    //-----------------

    public Curso[] getCursos() {
        return cursos;
    }

    public void setCursos(Curso[] cursos) {
        this.cursos = cursos;
    }

    public int getcCursos() {
        return cCursos;
    }

    public void setcCursos(int cCursos) {
        this.cCursos = cCursos;
    }

}
