package fr.univartois.butinfo.fractals.color.palettes;

import fr.univartois.butinfo.fractals.color.IColor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Déclaration de la classe PaletteMagenta qui implémente Icolor qui represente la palette magenta
 * @author Amaury Bonsigne
 */
public class PaletteGreen implements IColor {
    /**
     * Déclare l'attribut color representant la couleur de la palette
     */
    private Color color;

    /**
     * Constructeur de la classe PaletteMagenta qui donne la couleur Magenta a color
     */
    public PaletteGreen(){
        this.color=Color.GREEN;
    }

    /**
     * Déclaration de la méthode getPalette
     * @param nbIteration Nombre d'iterations de la suite
     * @param iterationsMax Nombre d'iterations max de la suite
     * @return renvoie la nouvelle color donc les composantes sont le ratio entre nbIteration et iteratoonsMax
     */
    @Override
    public Color getPalette(int nbIteration, int iterationsMax) {
        float nbIte = (float) nbIteration-1;
        float maxIte = (float) iterationsMax;
        float ratio = nbIte/maxIte;
        return new Color(0.5F, ratio, 0.5F);
    }

    /**
     * Declaration de la methode masque
     * @return La color du constructeur
     */
    @Override
    public Color masque() {
        return color;
    }
}
