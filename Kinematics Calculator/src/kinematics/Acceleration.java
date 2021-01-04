package kinematics;

public class Acceleration {

	public static double formula1(double v0, double v, double t) {
		double acceleration = (v - v0) / t;
		return acceleration;
	}
	
	public static double formula2(double v0, double t, double d) {
		double acceleration = (2*(d - v0*t)) / (t*t);
		return acceleration;
	}
	
	public static double formula3(double v0, double v, double d) {
		double acceleration = (v*v - v0*v0) / 2d;
		return acceleration;
	}
	
}
