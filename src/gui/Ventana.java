package gui;
import modelo.Manguera;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame
{
    private Container panel;
    private JTextField entrada, volumen, salida;
    private JButton botonEntrada, botonVolumen, botonSalida;
    private JProgressBar barra;
    private Manguera llena;

    public Ventana()
    {
        super("Lab: Deposito de agua");
        setSize(360,200);
        setLayout(null);
        panel = getContentPane();

        //Fila 1
        JLabel e = new JLabel("Entrada");
        e.setBounds(10,10,100,30);
        JLabel v = new JLabel("Volumen");
        v.setBounds(120,10,100,30);
        JLabel s = new JLabel("Salida");
        s.setBounds(240,10,100,30);
        panel.add(e);
        panel.add(v);
        panel.add(s);

        //fila 2
        entrada = new JTextField("");
        entrada.setBounds(10,50,100,30);
        panel.add(entrada);
        volumen = new JTextField("");
        volumen.setBounds(120,50,100,30);
        panel.add(volumen);
        salida = new JTextField("");
        salida.setBounds(240,50,100,30);
        panel.add(salida);

        botonEntrada = new JButton("Abrir / Cerrar");
        botonEntrada.setBounds(10,90,100,30);
        botonVolumen =new JButton("Actualizar");
        botonVolumen.setBounds(120,90,100,30);
        botonSalida = new JButton("Abrir / Cerrar");
        botonSalida.setBounds(240,90,100,30);
        panel.add(botonEntrada);
        panel.add(botonVolumen);
        panel.add(botonSalida);

        barra = new JProgressBar(0,100);
        barra.setBounds(10,130,320,30);

        barra.setStringPainted(true);
        barra.setValue(50);
        panel.add(barra);

        llena = new Manguera("Entrada", barra);
         botonEntrada.addActionListener(actionEvent ->
         {
            if (llena.getState() == Thread.State.RUNNABLE)
            {
                try
                {
                    llena.wait();
                } catch (InterruptedException ex)
                {
                    ex.printStackTrace();
                }
            } else
            {
                llena.start();
            }
        });

        setVisible(true);
    }
}




