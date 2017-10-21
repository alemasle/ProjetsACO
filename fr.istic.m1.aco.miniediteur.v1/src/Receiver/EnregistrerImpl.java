package Receiver;

import java.util.*;

import Command.Command;
import Memento.Memento;

/**
 * Classe {@link EnregistrerImpl} implementant l'interface {@link Enregistreur}
 * contenant une implementation des methodes abstraite de l'interface
 *
 * @author Alexis LE MASLE et Fanny PRIEUR
 */
public class EnregistrerImpl implements Enregistreur {

    private Boolean record = false;

    private List<Memento> replay = new ArrayList<Memento>();

    public EnregistrerImpl() {

    }

    /**
     * Demarre l'enregistrement
     */
    public void demarrer() {
        setRecord(true);
    }

    /**
     * Stoppe l'enregistrement en cours
     */
    public void stopper() {
        setRecord(false);
    }

    /**
     * Rejoue le dernier enregistrement
     */
    public void rejouer() {
        for (Memento memento : replay) {

        }
    }

    /**
     * @return le record
     */
    public Boolean getRecord() {
        return record;
    }

    /**
     * @param record le record à définir
     */
    public void setRecord(Boolean record) {
        this.record = record;
    }

}
