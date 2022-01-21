import java.util.*;

public class GeneralHistory {

	public static ArrayList<String> fullGeneralHistoryArray = new ArrayList<String>();

	public GeneralHistory(ArrayList<String> fArray) {
		for(int i = 0; i < fArray.size(); i++) {
			fullGeneralHistoryArray.add(fArray.get(i));
		}
	}

	public ArrayList<String> getGeneralHistory() {
		return fullGeneralHistoryArray;
	}

	public static ArrayList<String> changeGeneralHistory(ArrayList<String> fArray){
		for(int i = 0; i < fArray.size(); i++) {
			if(fullGeneralHistoryArray.get(i).equals(fArray.get(i)) == false) {
				fullGeneralHistoryArray.set(i, fArray.get(i));
			}
		}

		return fullGeneralHistoryArray;
	}

}
