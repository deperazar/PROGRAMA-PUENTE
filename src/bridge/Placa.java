/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

/**
 *
 * @author Usuario
 */
public class Placa {
    static final double ANCHO=3.6;
    static final double ESPESOR=0.1;
     
    private double x;//Largo de la placa
    private double peso;
    private double posicion;//posicion en donde empieza la placa, tomando como origen el extremo izquierdo del puente
     
    private double pos_contacto1;//posición de contacto entre la rueda y la placa, respecto al extremo izquierdo de la misma
    private double pos_contacto2;//posición de contacto entre la rueda y la placa, respecto al extremo izquierdo de la misma
    private int r_contacto1;//1rueda de contacto con la placa
    private int r_contacto2;//2rueda de contacto con la placa
    private double R1;//reaccion primer nodo
    private double R2;//reaccion segundo nodo
     
    Placa(double x){
        this.posicion=0;
        this.pos_contacto1=0;
        this.pos_contacto2=0;
        this.r_contacto1=0;
        this.r_contacto2=0;
        this.x=x;
        this.peso=ANCHO*ESPESOR*this.x*2400*9.8;//se toma la mitad del peso
    }
     
    
    public void set_R2(double s1,double s2){
        double F1=0;
        double F2=0;
        if(r_contacto1==1){
            F1=35000;
        }else if(r_contacto1==2 || r_contacto1==3){
            F1=145000;
        }
        if(r_contacto2==1){
            F2=35000;
        }else if(r_contacto2==2 || r_contacto2==3){
            F2=145000;
        }
        this.R2=(2*F1*s1+2*F2*s2+(this.x/2)*this.peso)/this.x;
    }
    public void set_R1(double s1,double s2){
        double F1=0;
        double F2=0;
        if(r_contacto1==1){
            F1=35000;
        }else if(r_contacto1==2 || r_contacto1==3){
            F1=145000;
        }
        if(r_contacto2==1){
            F2=35000;
        }else if(r_contacto2==2 || r_contacto2==3){
            F2=145000;
        }
       
        this.R1=2*F1+2*F2+this.peso-(2*F1*s1+2*F2*s2+(this.x/2)*this.peso)/this.x;
    }
    
    public void set_x(double x){
         this.x=x;
    }
    
    
    public void set_p1(double r){
         this.pos_contacto1=r;
    }
    
    public double get_p1(){
        return this.pos_contacto1;
    }
    
    public void set_p2(double r){
         this.pos_contacto2=r;
    }
    public double get_p2(){
        return this.pos_contacto2;
    }
    
    
    public void set_r1(int r){
         this.r_contacto1=r;
    }
    
    public int get_r1(){
        return this.r_contacto1;
    }
    
    public void set_r2(int r){
         this.r_contacto2=r;
    }
    
    public int get_r2(){
        return this.r_contacto2;
    }
    
    public void set_posicion(double posicion){
         this.posicion=posicion;
    }
    public double get_posicion(){
        return this.posicion;
    }
    
    public double get_x(){
        return this.x;
    }
    
    public double get_peso(){
        return this.peso;
    }
    
}
