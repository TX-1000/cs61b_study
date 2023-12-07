import java.lang.Math;

public class Planet {
    private static final double G = 6.67E-11;

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    
    public Planet(double xP, double yP, double xV, double yV, double m, String name) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = name;
    }

    public Planet(Planet example) {
        xxPos = example.xxPos;
        yyPos = example.yyPos;
        xxVel = example.xxVel;
        yyVel = example.yyVel;
        mass = example.mass;
        imgFileName = example.imgFileName;
    }

    // priva void show() {
    //     System.out.println("  xP: " + xxPos + "  yP: " + yyPos + "  xV: " + xxVel + "  yV: " + yyVel + "  mass: " + mass + "  img: " + imgFileName);
    // }

    public double calcDistance(Planet other) {
        return Math.pow((xxPos-other.xxPos)*(xxPos-other.xxPos)+(yyPos-other.yyPos)*(yyPos-other.yyPos), 0.5);
    }

    public double calcForceExertedBy(Planet other) {
        return G*mass*other.mass/Math.pow(this.calcDistance(other),2);
    }

    public double calcForceExertedByX(Planet other) {
        return this.calcForceExertedBy(other)*(other.xxPos-xxPos)/this.calcDistance(other);
    }
    
    public double calcForceExertedByY(Planet other) {
        return this.calcForceExertedBy(other)*(other.yyPos-yyPos)/this.calcDistance(other);
    }

    public double calcNetForceExertedByX(Planet[] others) {
        double Fx = 0;
        for (Planet planet : others) {
            if (planet.equals(this)) continue ;
            Fx += calcForceExertedByX(planet);
        }
        return Fx;
    }
    
    public double calcNetForceExertedByY(Planet[] others) {
        double Fy = 0;
        for (Planet planet : others) {
            if (planet.equals(this)) continue ;
            Fy += calcForceExertedByY(planet);
        }
        return Fy;
    }

    public void update(double dt, double Fx, double Fy) {
        double ax = Fx / mass;
        double ay = Fy / mass;
        xxVel += dt * ax;
        yyVel += dt * ay;
        xxPos += dt * xxVel;
        yyPos += dt * yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos,yyPos,"images/"+imgFileName);
        StdDraw.show();
    }

}