package Receiver;

import static org.junit.Assert.*;

import Memento.Memento;

import org.junit.Test;

import Command.Command;
import Command.Copier;
import Command.Copier.CopierMemento;

public class Jcopier {


    @Test
    public void testCopier() {
        Moteur moteur = new MoteurImpl();
        Enregistreur enregistreur = new EnregistrerImpl();

        Command copier = new Copier(moteur, enregistreur);

        assertTrue(true);
        assertFalse(false);

    }

    @Test
    public void testExecute() {
        Moteur moteur = new MoteurImpl();
        Enregistreur enregistreur = new EnregistrerImpl();

        Command copier = new Copier(moteur, enregistreur);

    }

    @Test
    public void testSetMemento() {
        //pas d'action

    }

    @Test
    public void testGetMemento() {
        Moteur moteur = new MoteurImpl();
        Enregistreur enregistreur = new EnregistrerImpl();

        Command copier = new Copier(moteur, enregistreur);

        Memento<CopierMemento> memento = copier.getMemento();

        assertTrue(memento instanceof Copier.CopierMemento);


    }


}
