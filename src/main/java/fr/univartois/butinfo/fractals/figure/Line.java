package fr.univartois.butinfo.fractals.figure;

import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;

import java.awt.*;

public class Line implements IFigure{

    private String color;
    private IComplex posx;
    private IComplex posy;


    public Line(String color, IComplex posx, IComplex posy) {
        this.color = color;
        this.posx = posx;
        this.posy = posy;
    }


    @Override
    public String repr() {
        return "<line x1="+posx.getRealPart()+" x2="+posx.getImaginaryPart()+" y1="+posy.getRealPart()+" y2="+posy.getImaginaryPart()+" stroke ='"+color+"' stroke-width=5/>";


    }
}
