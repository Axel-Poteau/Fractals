package fr.univartois.butinfo.fractals.color.masques;

import fr.univartois.butinfo.fractals.color.ColorDecorator;

import java.awt.*;

/**
 * Déclaration de la classe MasqueBlueDecorator qui extends la classe abtraite ColorDecorateur
 * @author Amaury Bonsigne
 */
public class MasqueBlueDecorator extends ColorDecorator {

    /**
     * Déclaration du constructeur de MasqueBlueDecorator qui reprend celui ColorDecorator
     * @param color Attribut color de ColorDecorator
     */
    public MasqueBlueDecorator(Color color) {
        super(color);
    }

    /**
     * Declaration de la methode getPalette
     * @param nbIteration Nombre d'iterations de la suite
     * @param iterationsMax Nombre d'iterations max de la suite
     * @return attribut Color de la classe
     */
    @Override
    public Color getPalette(int nbIteration, int iterationsMax) {
        return this.getColor();
    }
    /**
     * Déclaration de la méthode Masque
     * @return L'attribut color en gardant que la composante bleu du rgb
     */
    @Override
    public Color masque() {
        return new Color(0,0,this.getColor().getBlue());
    }
}
