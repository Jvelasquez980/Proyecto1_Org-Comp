import kareltherobot.*;
import java.awt.Color;

class Racer extends Robot implements Runnable {
    public Racer(int Street, int Avenue, Direction direction, int beepers, Color color) {
        super(Street, Avenue, direction, beepers, color);
        World.setupThread(this);  // Configura el robot para correr en un hilo
    }

    public void race() {
        while (!nextToABeeper()) {
            move();
        }
        pickBeeper();
        turnOff();
    }

    @Override
    public void run() {
        race();
    }

    public static void main(String[] args) {
        // Configura el mundo
        World.readWorld("Mundo.kwld");
        World.setVisible(true);

        // Crea dos robots que correrán en paralelo
        Racer first = new Racer(1, 1, East, 0, Color.red);    // Robot rojo
        Racer second = new Racer(2, 1, East, 0, Color.blue);  // Robot azul

        // Crea y ejecuta hilos para cada robot
        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);

        firstThread.start();
        secondThread.start();

        first.move();
        second.move();

    }
}

