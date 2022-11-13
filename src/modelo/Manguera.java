package modelo;

//La biblioteca swing sirve para crear interfaces gráficas
import javax.swing.*;

//Extends Thread define los hilos en ejecuciones concurrentes
//Objetos actuan concurrentemente con otros
public class Manguera extends Thread
{
    //Función JProgressBar es una barra de progreso
    JProgressBar barra;
    public Manguera (String nombre, JProgressBar barra)
    {
        //El metodo super indica la clase superior o sea la clase padre
        super(nombre);
        this.barra = barra;
    }

    //Metodo run construye el cuerpo de un hilo en ejecución
    public void run()
    {
        //para numeros enteros iguales a 10 menores que 100, sumatoria
        for (int i=0; i<100; i++)
        {
            //La barra proporciona el valor de i
            barra.setValue(i);
            //Declaración try codigo que puede fallar
            try
            {
                sleep(500);
            } catch (InterruptedException e) //catch a excepción de su catch
            {
                e.printStackTrace();
            }
        }
    }
}
