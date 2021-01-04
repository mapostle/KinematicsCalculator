package kinematics;

public class Displacement {

	public static double formula1(double v0, double a, double t) {
		 double displacement = v0*t + 0.5*a*t*t;
		 return displacement;
	}
	
	public static double formula2(double v0, double v, double a) {
		 double displacement = (v*v - v0*v0) / (2*a);
		 return displacement;
	}
	
	public static double formula3(double v0, double v, double t) {
		 double displacement = ((v + v0) / 2) * t;
		 return displacement;
	}
	
}
