public class NBody {
    public static double readRadius(String path) {
        In in = new In(path);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String path) {
        In in = new In(path);
        int num = in.readInt();
        Planet[] planets = new Planet[num];
        double s = in.readDouble();
        for (int i = 0 ; i < num ; i++ ) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            String name = in.readString();
            planets[i] = new Planet(xP,yP,xV,yV,mass,name);
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String path = args[2];
        double radius = readRadius(path);
        Planet[] planets = readPlanets(path);
        StdDraw.setScale(-radius,radius);
        StdDraw.enableDoubleBuffering();
        for (int t = 0 ; t < T ; t += dt) {
            StdDraw.picture(0,0,"images/starfield.jpg");

            double[] xFarr = new double[planets.length];
            double[] yFarr = new double[planets.length];
            for (int i = 0 ; i < planets.length ; i++) {
                xFarr[i] = planets[i].calcNetForceExertedByX(planets);
                yFarr[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (Planet planet : planets) {
                StdDraw.picture(planet.xxPos,planet.yyPos,"images/"+planet.imgFileName);
                StdDraw.show();
            }
            for (int i = 0 ; i < planets.length ; i++) {
                planets[i].update(dt,xFarr[i],yFarr[i]);
            }
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
        planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
        planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
    }
}

