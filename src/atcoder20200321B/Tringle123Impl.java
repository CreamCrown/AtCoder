package atcoder20200321B;

public class Tringle123Impl implements Tringle123 {

	// x_(N,1)��Ԃ��֐�
	@Override
	public int calculationXN1(int length , int[] ints) {

		//�@�ő��R�[�h�p���\�b�h
		//�@return fast(length, ints);

		// �����Ƃ�ݖ�̂���,����a_n��-1�����Ă����ɉe���͂Ȃ�
		// ����S�̂�-1�����������intMinus1�Ƃ���
		// �킩��₷�悤�ɋL�ڂ���B��̐�����������Ȃ炢��Ȃ��B
		int intsMinus1[] = new int[length];
		for (int i  : ints) {
			intsMinus1[i] = ints[i] -1;
		}

		//�@�����1���܂܂�Ȃ����Ƃ��m�F
		boolean exactNumber1= false;
		
		int x_n1 = 0;
		int x_n1_2 = 0;
		
		for (int i=0 ; i < length ; i++) {
			//�@�񍀌W���������łȂ����m�F
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
	
    //�@�g�ݍ��킹�̐�nCr���v�Z
	//�@http://osishow3.hateblo.jp/entry/2017/04/03/235027
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
