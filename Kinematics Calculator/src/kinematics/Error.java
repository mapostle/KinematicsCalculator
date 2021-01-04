package kinematics;

public class Error {

	static boolean checkUnknowns(String velocity0, String velocity, String accel, String time, String displacement) {
		boolean unknown = false;
		int count = 0;
		if(velocity0.equals(""))
			count++;
		if(velocity.equals(""))
			count++;
		if(accel.equals(""))
			count++;
		if(time.equals(""))
			count++;
		if(displacement.equals(""))
			count++;
		if(count != 2)
			unknown = true;
		return unknown;
	}
	
	//Static because it doesn't hold any Problem class-specific values; independent
	static boolean checkNegTime(double t) {
		boolean negTime = false;
		if(t < 0)
			negTime = true;
		return negTime;
	}
	
	static boolean checkZeroTime(double t) {
		boolean zeroTime = false;
		if(t == 0)
			zeroTime = true;
		return zeroTime;
	}
}
