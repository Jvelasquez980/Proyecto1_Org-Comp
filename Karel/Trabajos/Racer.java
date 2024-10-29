import kareltherobot.*;
import java.awt.Color;

class Racer extends Robot implements Runnable {
    public Racer(int Street, int Avenue, Direction direction, int beepers, Color color) {
        super(Street, Avenue, direction, beepers, color);
    } // World.setupThread(this);  // Decidi comentar esta parte debido a que no le encontraba utilidad a usarlo, no cambia en nada

    public void race() {
        while (!nextToABeeper()) // Tratara de moverse al estar encima de un beeper, luego recoge el beeper y se apaga
            move();
            pickBeeper();
            turnOff();
        }

    public void run() {
        race();
    }

    public static void main(String[] args) {
        World.readWorld("Mundo.kwld");
        World.setVisible(true);
        Racer first = new Racer(1, 1, East, 0, Color.blue);
        Racer second = new Racer(2, 1, East, 0, Color.red);
        Thread fiThread = new  Thread(first); //Implementando Runnable, nos permite el crear hilos funcionales y ejecutarlos con el metodo start(), al comenzar o iniciar el thread automaticamente llama al metodo run
        Thread sThread = new  Thread(second);
        sThread.start();    //Iniciamos los hilos de manera independiente y estos se ejecutan en paralelo, pero ambos hacen lo que el metodo race() especifica, por lo que siguen una misma ruta
        fiThread.start();
        
        
    }

}
