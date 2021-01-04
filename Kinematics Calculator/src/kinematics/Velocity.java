package kinematics;

public class Velocity {

	public static double formula1(double v0, double a, double t) {
		 double velocity = v0 + a*t;
		 return velocity;
	}
	
	public static double formula2(double v0, double a, double d) {
		 double velocity = Math.sqrt(v0*v0 + 2*a*d);
		 return velocity;
	}
	
	public static double formula3(double v0, double t, double d) {
		 double velocity = 2d/t - v0;
		 return velocity;
	}
	
}
