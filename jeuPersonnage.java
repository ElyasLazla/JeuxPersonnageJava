/**
 jeupersonnage
 */
import Personnage.*;
import java.awt.*;
import java.awt.TrayIcon.MessageType;
public class jeuPersonnage {

    public static void main(String[] args) throws AWTException {
        Personnage UnSorcier = new Personnage("Sorcier", 200, 300);
        Personnage Goblin = new Personnage("Goblin", 50, 300);
        while (!UnSorcier.isDeath()) {
            
            System.out.println("Bienvenue " + UnSorcier.LeNom());
            System.out.println("ATTENTION un " + Goblin.LeNom() + " vient d'apparaitre!");
            System.out.println("Le goblin attaque et vous fait 200 de degat.");

            Goblin.Attaque(UnSorcier, 200);
            if (UnSorcier.isDeath()) {
                if (SystemTray.isSupported()) {
                    jeuPersonnage td = new jeuPersonnage();
                    td.Notifys("Vous avez était tuer par un " + Goblin.LeNom(), "Vous êtes mort!", "INFO");
                }
                else{
                    System.err.println("Vous avez était tuer par un " + Goblin.LeNom());
                }
            }
            System.out.println("Attention il vous reste "+ UnSorcier.LaVie() + ".\nVous attaquer avec le sort de degat d'une force de 50!");
            UnSorcier.Attaque(Goblin, 50);
        }
        System.exit(0);
    }
    public void Notifys(String msg, String title, String type) throws AWTException{
        SystemTray tray = SystemTray.getSystemTray();
        MessageType types = MessageType.NONE;
        if (type == "INFO") {
           types = MessageType.INFO;
        }
        if (type == "WARNING") {
           types = MessageType.WARNING;
        }
        if (type == "ERROR") {
           types = MessageType.ERROR;
        }

        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Dead player");
        trayIcon.setToolTip("Test");
        tray.add(trayIcon);

        trayIcon.displayMessage(title, msg, types);

    }
}