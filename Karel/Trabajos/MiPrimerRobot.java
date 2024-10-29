import kareltherobot.*;
import java.awt.Color;
public class MiPrimerRobot implements Directions
{
public static void main(String [] args)
{
// Usamos el archivo que creamos del mundo
 World.readWorld("Mundo.kwld");
 World.setVisible(true);
// Coloca el robot en la posición inicial del mundo (1,1),
// mirando al Este, sin ninguna sirena.
Robot Karel = new Robot(1, 1, East, 0);
Robot Yandel = new Robot(1, 1, East, 0, Color.blue);
// Mover el robot 4 pasos
// IMPORTANTE ES A PROPO
Karel.move();
Yandel.move();
Karel.move();
Yandel.move();
Karel.move();
Yandel.move();
Karel.move();
// Recoger los 5 beepers
Karel.pickBeeper();
Karel.pickBeeper();
Karel.pickBeeper();
Karel.pickBeeper();
Karel.pickBeeper();
// Girar a la izquierda y salir de los muros
Karel.turnLeft();
Karel.move();
Yandel.move();
Karel.move();
Yandel.turnLeft();
Yandel.move();
// Poner los beepers fuera de los muros
Karel.putBeeper();
Karel.putBeeper();
Karel.putBeeper();
Karel.putBeeper();
Karel.putBeeper();
// Ponerse en otra posición y apagar el robot
Karel.move();
Yandel.move();
Karel.turnOff();
Yandel.turnOff();// Aqui se estan ejecutando en un mismo hilo y yandel termina en una calle atras
}
}
