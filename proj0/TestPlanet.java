public class TestPlanet {
    public static void main(String[] args) {
        Planet planet1 = new Planet(0, 0, 0, 0, 100, "jupiter.gif");
        Planet planet2 = new Planet(1000, 2000, 0, 0, 2000, "jupiter.gif");
        for (int i = 0; i < 10000000 ; i++) {
            planet1.update(1, planet1.calcForceExertedByX(planet2), planet1.calcForceExertedByX(planet2));
            planet2.update(1, planet2.calcForceExertedByX(planet1), planet2.calcForceExertedByX(planet1));
        }
        planet1.show();
        planet2.show();
        return;
    }
}
