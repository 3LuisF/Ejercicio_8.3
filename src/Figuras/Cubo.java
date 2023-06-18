package Figuras;

public class Cubo extends FiguraGeometrica {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = Math.pow(lado, 3.0);
        return volumen;
    }

    public double calcularSuperficie() {
        double superficie = 6.0 * Math.pow(lado, 2.0);
        return superficie;
    }
}

