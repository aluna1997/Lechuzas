/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Marcador;
import modelo.MarcadorDAO;
import modelo.Tema;
import modelo.TemaDAO;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author ailyn
 */
@ManagedBean
@ViewScoped
public class BuscarTemasInf implements Serializable {
    private MapModel simpleModel;
    private List<Tema> lista_temas;
    private ArrayList<String> temas;
    private Tema tema;
    private String tema_elegido;
    
    @PostConstruct
    public void BuscarTemasInf(){
        simpleModel = new DefaultMapModel();
        MarcadorDAO mdao = new MarcadorDAO();
        TemaDAO tdao = new TemaDAO();
        lista_temas = tdao.findAll();
        temas = new ArrayList();
        tema_elegido = "";
        if(lista_temas != null){
            for(Tema t : lista_temas){
                ControladorSesion.UserLogged us = (ControladorSesion.UserLogged) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("informador");
                if(t.getUsuario().getCorreo().equals(us.getCorreo())){
                       temas.add(t.getNombreTema());
                }else{
                    lista_temas.remove(t);
                }
            }
        }
    }
    
    public void muestraMarcadores(){
        if(!this.tema_elegido.equals("")){
             simpleModel = new DefaultMapModel();
             MarcadorDAO mdao = new MarcadorDAO();
             List<Marcador> marcadores = mdao.findAll();
             for (Tema tem : lista_temas){
                 if(this.tema_elegido.equals(tem.getNombreTema()))
                     tema = tem;
            }
            for(Marcador m : marcadores){
                if(tema.getIdTema() == m.getTemaByIdTema().getIdTema()){
                    LatLng cord = new LatLng(m.getLatitud(),m.getLongitud());
                    Marker marc = new Marker(cord,m.getDescripcion());
                    simpleModel.addOverlay(marc);
                }    
            }
            this.tema_elegido = "";
        }else{
            Mensajes.error("No se ha elegido un tema, favor de seleccionar uno");
        }
       
    }
     

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void setSimpleModel(MapModel simpleModel) {
        this.simpleModel = simpleModel;
    }

    public ArrayList<String> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<String> temas) {
        this.temas = temas;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public List<Tema> getLista_temas() {
        return lista_temas;
    }

    public void setLista_temas(List<Tema> lista_temas) {
        this.lista_temas = lista_temas;
    }

    public String getTema_elegido() {
        return tema_elegido;
    }

    public void setTema_elegido(String tema_elegido) {
        this.tema_elegido = tema_elegido;
    }
    
    
    
        
    
    public String muestraVentana(){
        return "/informador/buscarTemasInf?faces-redirect=true";
    }
    
    
    }
    
