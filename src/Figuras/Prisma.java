package Figuras;

public class Prisma extends FiguraGeometrica {
    private double base;
    private double altura;
    private double profundidad;

    public Prisma(double base, double altura, double profundidad) {
        this.base = base;
        this.altura = altura;
        this.profundidad = profundidad;
        this.setVolumen(calcularVolumen());
        this.setSuperficie(calcularSuperficie());
    }

    public double calcularVolumen() {
        double volumen = base * altura * profundidad;
        return volumen;
    }

    public double calcularSuperficie() {
        double superficie = 2 * (base * altura + base * profundidad + altura * profundidad);
        return superficie;
    }
}
