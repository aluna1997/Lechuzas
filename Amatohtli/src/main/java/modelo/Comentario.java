package modelo;
// Generated 28/03/2019 11:09:54 AM by Hibernate Tools 4.3.1



/**
 * Comentario generated by hbm2java
 */
public class Comentario  implements java.io.Serializable {
     private int idComentario;
     private Calificacion calificacion;
     private Marcador marcador;
     private Usuario usuario;
     private String descripcion;
     private int numCalificaciones;

             
    public Comentario() {
    }

	
    public Comentario(int idComentario, Marcador marcador, Usuario usuario, String descripcion, int numCalificaciones) {
        this.idComentario = idComentario;
        this.marcador = marcador;
        this.usuario = usuario;
        this.descripcion = descripcion;
        this.numCalificaciones = numCalificaciones;
    }
   
    
    public int getNumCalificaciones() {
        return numCalificaciones;
    }

    public void setNumCalificaciones(int numCalificaciones) {
        this.numCalificaciones = numCalificaciones;
    }
     

    public int getIdComentario() {
        return this.idComentario;
    }
    
    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }
    public Calificacion getCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(Calificacion calificacion) {
        this.calificacion = calificacion;
    }
    public Marcador getMarcador() {
        return this.marcador;
    }
    
    public void setMarcador(Marcador marcador) {
        this.marcador = marcador;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


