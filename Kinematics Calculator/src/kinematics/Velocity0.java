package kinematics;

public class Velocity0 {

	public static double formula1(double v, double a, double t) {
		 double velocity0 = v - a*t;
		 return velocity0;
	}
	
	public static double formula2(double a, double t, double d) {
		 double velocity0 = (d - (0.5*a*t*t)) / t;
		 return velocity0;
	}
	
	public static double formula3(double v, double a, double d) {
		 double velocity0 = Math.sqrt(v*v-2*a*d);
		 return velocity0;
	}
	
	public static double formula4(double v, double t, double d) {
		 double velocity0 = (2*d)/t - v;
		 return velocity0;
	}
}
