package kinematics;

public class Time {

	public static double formula1(double v0, double v, double a) {
		double time = (v - v0) / a;
		return time;
	}
	
	public static double formula2(double v0, double v, double d) {
		double time =  d / ((v + v0) / 2);
		return time;
	}
	
}
