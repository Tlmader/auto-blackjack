public class TimidStrategy implements Strategy{

	public int hitOrStand(int handValue){
		int decision = 1;
		if(handValue >= 14){
			decision = 0;
		}
		return decision;
	}
}