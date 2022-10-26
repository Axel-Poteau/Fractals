package fr.univartois.butinfo.fractals.image;


import fr.univartois.butinfo.fractals.color.IColor;
import fr.univartois.butinfo.fractals.color.PaletteMagenta;
import fr.univartois.butinfo.fractals.complex.Complex;
import fr.univartois.butinfo.fractals.complex.IComplex;
import fr.univartois.butinfo.fractals.complex.MultiplyPlan;
import fr.univartois.butinfo.fractals.complex.Plan;
import fr.univartois.butinfo.fractals.suites.EnsembleJulia;
import fr.univartois.butinfo.fractals.suites.EnsembleMandelbrot;
import fr.univartois.butinfo.fractals.suites.SuiteIterator;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageBuilder {

    private int width;

    private int height;

    private double scale;

    private double focusX;

    private double focusY;

    private String suite;

    private String palette;

    private String pathToFile;

    private int iterationsMax;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setScale(double scale) {
        this.scale = scale;
    }

    public void setFocusX(double focusX) {
        this.focusX = focusX;
    }

    public void setFocusY(double focusY) {
        this.focusY = focusY;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public void setPalette(String palette) {
        this.palette = palette;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }

    public void setIterationsMax(int iterationsMax) {
        this.iterationsMax = iterationsMax;
    }

    public IFractalImage getResult() throws IOException {
        IFractalImage image = new BufferedImageAdapter(height, width);
        Plan plan = new Plan(height, width);
        MultiplyPlan scaledPlan = new MultiplyPlan(scale, plan, height, width);
        IComplex c = new Complex(-0.4,0.6);
        IColor paletteColor = new PaletteMagenta();

        for(int x = 0; x<width; x++){
            for(int y = 0; y<height; y++){
                IComplex point = scaledPlan.asComplex(x, y);
                EnsembleJulia typeSuite = new EnsembleJulia(point, c, iterationsMax);
                SuiteIterator iterator = (SuiteIterator) typeSuite.iterator();
                while(iterator.hasNext()){
                    iterator.next();
                }
                int nbIteration = iterator.getNbIterations();

                Color color = paletteColor.getPalette(nbIteration, iterationsMax);
                Pixel pixel = image.getPixel(x, y);
                pixel.setColor(color);
            }
        }
        image.saveAs(pathToFile);
        return image;
    }
}