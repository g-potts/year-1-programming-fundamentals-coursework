package lab6_exercise3;

public class Check {

	public static void main(String[] args) {
		
		MedalTable mt = new MedalTable();
		
		mt.addMedal(Countries.BRITAIN, Medals.GOLD);
		System.out.println(mt.getMedals(Countries.FRANCE, Medals.SILVER));
	}

}
