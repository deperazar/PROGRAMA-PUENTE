/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridge;

import java.util.*;

/**
 *
 * @author Usuario
 */
public class Bridge {

    /**
     * @param args the command line arguments
     */
    
   
    public static void main(String[] args) {
        //7 PLACAS
        double L=0;//Longitud del puente: 20<=L<=30
        double axs=0;//Longitud de los ejes traseros del camión: 4.3<=axs<=9
        double x=0;//Longitud de cada placa
        int trucks=0;//Número de camiones
        double truckslft=0;//Camion sobrante
        
        Scanner lec= new Scanner(System.in) ;
        L=lec.nextDouble();
        while (L<20||L>30) {
            System.out.println("L debe estar entre 20m y 30m");
            L=lec.nextDouble();
            
        }
        
        axs=lec.nextDouble();
        while (axs<4.3||axs>9) {
           System.out.println("axs debe estar entre 4.3m y 9m");
           axs=lec.nextDouble();
        }
        
        trucks= (int) Math.floor(L/(5.3+axs));//5.3, por el espacio de 1m entre camiones
        truckslft= L/(5.3+axs)-Math.floor(L/(5.3+axs));//5.3, por el espacio de 1m entre camiones
       
        
        Camion [] camiones=new Camion[trucks+1];//arreglo de camiones enteros mas uno, de un posible camion no entero
        
        for (int i = 0; i < trucks+1; i++) {
            camiones[i]=new Camion(3,axs); 
            camiones[i].set_pos(i*(5.3+axs));//se suma 1 debido a la separación entre camiones
            if (truckslft>0 && i==trucks) {//solo una rueda esta en una plataforma   | i = trucks
                camiones[trucks].set_nruedas(1);
                if (truckslft*(5.3+axs)>4.3) {//solo dos ruedas estan en una plataforma
                camiones[trucks].set_nruedas(2);
                }
            }
        }
        
        
        
        Placa [] placas =new Placa[7];//SE UTILIZAN 7 PLACAS
        double l_placa=L/7;//Largo de cada placa
        for (int i = 0; i < 7; i++) {
            placas[i]=new Placa(L/7);
            placas[i].set_posicion(i*l_placa);
        }
        //System.out.println("posicion placa: "+placas[2].get_posicion());

        
        for (int i = 0; i < 7; i++) {
            double n=(i+1)*(L/7);
            if(i==6){
                n=L;
            }
            System.out.println("placa: "+i);
            
            for (int j = 0; j < trucks+1; j++) {
                if(placas[i].get_posicion()<=camiones[j].get_pos1() && camiones[j].get_pos1()<=n){//rueda 1 dentro de la placa?
                   
                   if(placas[i].get_r1()!=0){
                       placas[i].set_r2(1);
                       placas[i].set_p2(camiones[j].get_pos1()-placas[i].get_posicion());
                   }else{
                       placas[i].set_r1(1);
                       placas[i].set_p2(camiones[j].get_pos1()-placas[i].get_posicion());
                   }                            
                }
                if(placas[i].get_posicion()<=camiones[j].get_pos2() && camiones[j].get_pos2()<=n){//rueda 2 dentro de la placa?
                   if(placas[i].get_r1()!=0){
                       placas[i].set_r2(2);
                       placas[i].set_p2(camiones[j].get_pos2()-placas[i].get_posicion());
                   }else{
                       placas[i].set_r1(2);
                       placas[i].set_p1(camiones[j].get_pos2()-placas[i].get_posicion());
                   }   
                }
                if(placas[i].get_posicion()<=camiones[j].get_pos3() && camiones[j].get_pos3()<=n){//rueda 3 dentro de la placa?
                                     
                   if(placas[i].get_r1()!=0){
                       placas[i].set_r2(3);
                       placas[i].set_p2(camiones[j].get_pos3()-placas[i].get_posicion());
                   }else{
                       placas[i].set_r1(3);
                       placas[i].set_p1(camiones[j].get_pos3()-placas[i].get_posicion());
                   } 
                }
                //System.out.println("pos1camion "+j+": "+camiones[j].get_pos1()+"        |       ntrucks: "+trucks );//n trucks:camiones completos
            }
        }
        System.out.println("posicion aplicacion f: "+placas[1].get_p1());
        
        
    }
    
}
