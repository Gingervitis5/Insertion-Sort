import java.util.*;
public class Main {

	public static class StringCard{
		private String faceCard;
		private int value;
		
		private StringCard(String card) {
			this.faceCard = card;
			this.value = 0;
		}
	}

		public static void main(String[] args) {
		Scanner con = new Scanner(System.in);		
		StringCard[] hand; ArrayList<StringCard[]> deck= new ArrayList<StringCard[]>();
		hand = setArray(con);
		while (!hand[0].faceCard.equals("00")) {
			for (int j = 1; j < hand.length; j++) {
				StringCard key = hand[j];
				int i = j - 1;
				while ( i >= 0 && (compareCards(hand[i], key) > 0) ) {
					hand[i+1] = hand[i];
					i = i - 1;
				}
				hand[i+1] = key;
			}
			deck.add(hand);
			hand = setArray(con);
		}
		printArray(deck);
		
	}
		
		public static void setValue(StringCard sc) {
			String faceValue = sc.faceCard.substring(0, 1); char suit = sc.faceCard.charAt(1);
			switch(faceValue) {
			case "A":
				sc.value += 1;
				break;
			case "T":
				sc.value += 10;
				break;
			case "J":
				sc.value += 11;
				break;
			case "Q":
				sc.value += 12;
				break;
			case "K":
				sc.value += 13;
				break;
			default:
				sc.value += Integer.parseInt(faceValue);
				break;
			}
			switch(suit) {
			case 'S':
				sc.value += 100;
				break;
			case 'H':
				sc.value += 200;
				break;
			case 'C':
				sc.value += 300;
				break;
			case 'D':
				sc.value += 400;
				break;
			}
		}
		
		private static int compareCards(StringCard sc1, StringCard sc2) {
			return sc1.value - sc2.value;
		}
		
		private static void printArray(ArrayList<StringCard[]> deck) {
			int i;
			for (StringCard[] sc : deck) {
				for (i = 0; i < sc.length-1; i++) {
					System.out.print(sc[i].faceCard + " ");
				}
				System.out.println(sc[i].faceCard);
			}
		}
		
		private static StringCard[] setArray(Scanner con) {
			StringCard[] array = new StringCard[5];
			for(int i = 0; i < array.length; i++) {
				String next = con.next();
				if (next.equals("00")) {
					array[0] = new StringCard(next);
					return array;
				}
				else {
				array[i] = new StringCard(next);
				setValue(array[i]);
				}
			}	
			return array;
		}
	
}
