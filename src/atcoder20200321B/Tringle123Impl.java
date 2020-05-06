package atcoder20200321B;

public class Tringle123Impl implements Tringle123 {

	// x_(N,1)を返す関数
	@Override
	public int calculationXN1(int length , int[] ints) {

		//　最速コード用メソッド
		//　return fast(length, ints);

		// 差をとる設問のため,数字a_nに-1をしても解に影響はなし
		// 数列全体に-1をした数列をintMinus1とする
		// わかりやすように記載する。後の整合性が取れるならいらない。
		int intsMinus1[] = new int[length];
		for (int i  : ints) {
			intsMinus1[i] = ints[i] -1;
		}

		//　数列に1が含まれないことを確認
		boolean exactNumber1= false;
		
		int x_n1 = 0;
		int x_n1_2 = 0;
		
		for (int i=0 ; i < length ; i++) {
			//　二項係数が偶数でないか確認
			if (!exactNumber1 && (ints[i] == 1)) {
				exactNumber1 = true;
			}
			
			if ((calcNumOfCombination(length-1, i) %2) == 1) {
				if (ints[i] == 1) {
					x_n1++;
				} 
				if (!exactNumber1 && (ints[i] == 2)) {
					x_n1_2++;
				}
			}			
		}
		
		return (x_n1 %2 ==1 ) ? 1 : exactNumber1 ? 0 : (x_n1_2 %2 ==1 ) ? 2 : 0;
	}
	
    //　組み合わせの数nCrを計算
	//　http://osishow3.hateblo.jp/entry/2017/04/03/235027
    int calcNumOfCombination(int n, int r){
        int num = 1;
        for(int i = 1; i <= r; i++){
            num = num * (n - i + 1) / i;
        }
        return num;
    }
	

	public int fast(int length , int[] ints) {
		boolean exactNumber2 = false;
		int countDifference1 = 0;
		int countDifference2 = 0;
		int absolute;

		for (int i = 0 ; i < length ; i++) {
			if (ints[i] == 2) exactNumber2 =true;

			if (i != length-1) { 
				absolute = Math.abs(ints[i] - ints[i+1]);
				if (absolute == 1) countDifference1++;
				if ((!exactNumber2) && (absolute == 2)) countDifference2++;
			} 
		}

		return (countDifference1%2 == 0) ? 1 :((countDifference2 + length)%2 == 0) ? 2: 1;
	}
}
