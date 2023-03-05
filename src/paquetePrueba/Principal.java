/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquetePrueba;

import java.util.Scanner;

/**
 *
 * 6. Crea un método estático que permita establecer una conversación con un portero hasta que
introduzcas la frase: Abortar programa.
Ejemplo:
Portero: Hola, quieres salir o entrar?
>entrar
Portero: cuantos sois?
>5
Portero: podéis pasar.
Portero: Hola, quieres salir o entrar?
>entrar
Portero: cuantos sois?
>7
Portero: Se ha alcanzado el aforo.
Portero: Hola, quieres salir o entrar?
>salir
Portero: cuantos sois?
>2
Portero: adiós.
Portero: Hola, quieres salir o entrar?
>bla bla otra cosa que no sea salir o
entrar
Portero: me estás cabreando!
Portero: Hola, quieres salir o entrar?
>entrar
Portero: fuera de aquí!
Portero: Hola, quieres salir o entrar?
>salir
Portero: cuantos sois?
>6
Portero: Hola, quieres salir o entrar?
>entrar
Portero: cuantos sois?
>5
Portero: podéis pasar.
Portero: Hola, quieres salir o entrar?
>Abortar programa
Fin del programa
paciencia portero 0/3
Aforo local 9
Aforo máximo 12 (alarma 80%)
Alarma!
 * 
 * 
 * @author alumno
 */
public class Principal {
    
    public static void main(String[] args) {
        conversacion();
    }
       
    
    public static void conversacion(){
    
        
        int topeAforo, nivelAlarma, limitePaciencia, entrarRespuesta, salirRespuesta;
        String respuesta, comentarioFinal;
        boolean doWhile1Salir = true;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Tope aforo del contador:");
        topeAforo = sc.nextInt();
        System.out.println("Nivel de alarma en %:");
        nivelAlarma = sc.nextInt();
        System.out.println("Limite paciencia del portero:");
        limitePaciencia = sc.nextInt();
                
        Contador c1 = new Contador(topeAforo,nivelAlarma);
        Portero paco = new Portero(c1,limitePaciencia);
        
        
        do{
            System.out.println("Hola, quieres salir o entrar?");
            respuesta = sc.nextLine();
        
            switch (respuesta) {
                case ("entrar")://ENTRAR
                    
                    System.out.println("Cuantos sois?");
                    entrarRespuesta = sc.nextInt(); 
                    
                    if(entrarRespuesta < c1.getTopeAforo()){    //Comprueba aforo
                        System.out.println("Podeis pasar");
                        
                        if(paco.dejarPasar(entrarRespuesta) > 0){   //En caso de que alguien no entre, indica cuantos
                            //paco.dejarPasar(entrarRespuesta) retorna el numero de personas que no han podido pasar por aforo(Contador) o paciencia(Portero)
                            System.out.println("Estas personas no han podido pasar por que el aforo esta completo");
                            System.out.println(paco.dejarPasar(entrarRespuesta));
                        }else{
                            paco.dejarPasar(entrarRespuesta);   //Pasan todos los indicados en entrarRespuesta
                        }
                    }else{
                        System.out.println("Se ha alcanzado el aforo maximo");
                    }
                                        
                    break;

                case ("salir")://SALIR
                    
                    System.out.println("Cuantos sois?");
                    salirRespuesta = sc.nextInt();
                    
                    if(c1.getAforo() >= salirRespuesta && salirRespuesta > 0){
                        paco.dejarSalir(salirRespuesta);
                        System.out.println("Adios");
                    }
                        
                    break;

                case ("abortar programa")://ABORTAR
                    
                    doWhile1Salir = false;
                    break;
                    
                default:
                    
                    System.out.println("Me estas cabreando!");
                    paco.confrontar(1);
            }   

        }while(doWhile1Salir);
        
        
        comentarioFinal = "";

        comentarioFinal += "Fin del programa \n";
        comentarioFinal += paco.toString();
        comentarioFinal += c1.toString();
        
        
        
        //Capturar Excepcion de los Scanners(sc)???
        


        
    }
}
