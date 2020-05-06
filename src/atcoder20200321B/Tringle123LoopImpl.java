package atcoder20200321B;
import java.util.Random;

public class Tringle123LoopImpl implements Tringle123 {

	// x_(N,1)Çï‘Ç∑ä÷êî
	@Override
	public int calculationXN1(int length , int[] ints) {

		if (length == 1) {
			return ints[0];
		}
		
		int differenceInts[] = {0};
		
		while (length != 1) {
			differenceInts = new int[length-1];
			for (int i = 0 ; i < length -1 ; i++) {
				//int difference = (ints[i + 1] - ints[i]);
				//differenceInts[i] = (difference >= 0) ? difference : -difference;
				differenceInts[i] = Math.abs(ints[i + 1] - ints[i]);
			}
			ints = differenceInts;
			length -= 1;
		}

		return differenceInts[0];
	}

}
