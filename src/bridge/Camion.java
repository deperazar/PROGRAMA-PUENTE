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
public class Camion{
        private int nruedas;
        private double axs;
        private double pos1;//posicion rueda1
        private double pos2;//posicion rueda2
        private double pos3;//posicion rueda3
        
        Camion(int a, double axs){
            this.nruedas=a;
            this.axs=axs;
            this.pos1=0;
            this.pos2=0;
            this.pos3=0;
            
        }
        
        public void set_nruedas(int nruedas){
            this.nruedas=nruedas;
        }
        public void set_axs(double axs){
            this.axs=axs;
        }
        public int get_nruedas(){
            return this.nruedas;
        }
        
         
        public void set_pos(double pos1){
            this.pos1=pos1;
            this.pos2=pos1+4.3;
            this.pos3=pos2+this.axs;
        }
        
        public double get_pos1(){
            return this.pos1;
        }
        
        public double get_pos2(){
            return this.pos2;
        }
        
        public double get_pos3(){
            return this.pos3;
        }
        
    }
