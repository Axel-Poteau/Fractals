package fr.univartois.butinfo.fractals.suites.chaotiques;

import fr.univartois.butinfo.fractals.complex.points.IPointPlan;

import java.util.Iterator;

/**
 * Creation de la classe SuiteFeigenbaum qui implementera l'interface ISuiteChaotique
 * et etends la classe abstraite SuiteChaotique
 * @author Bonsigne Amaury
 */
public class SuiteCirculaire extends SuiteChaotique implements SuitesChaotiqueStrategy {
    /**
     * Constructeur de la classe SuiteCirculaire
     * @param premier Paramètre de type IPointPlan qui est un point du plan
     * @param nbMaxIterations Nombre maximum d'iterations de la suite
     */
    public SuiteCirculaire(IPointPlan premier, int nbMaxIterations, int k, float e) {
        super(premier, nbMaxIterations, k, e);
    }

    /**
     * declaration de la methode getNext
     * @param point Point du plan
     * @return Le prochain point du plan
     */
    @Override
    public double getNext(IPointPlan point) {
        double tiers = (double) 1 / (double) 3;
        return point.getY()+(point.getX()*Math.sin(2*Math.PI* point.getY())/2*Math.PI)+tiers;
    }

    @Override
    public Iterator<IPointPlan> iterator(){
        return new SuiteChaotiqueIterator(this,this.premier,this.nbMaxIterations, k, e);
    }

}
