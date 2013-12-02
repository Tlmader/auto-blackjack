public class AggressiveStrategy implements Strategy{

	public int hitOrStand(int handValue){
		int decision = 1;
		if(handValue >= 20){
			decision = 0;
		}
		return decision;
	}
}