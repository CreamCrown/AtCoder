package atcoder20200321B;
import java.util.Random;

// Q : https://atcoder.jp/contests/agc043/tasks/agc043_b
// A : https://img.atcoder.jp/agc043/editorial.pdf
// text1 : https://drken1215.hatenablog.com/entry/2020/03/22/165200
// text2 : https://www.youtube.com/watch?v=zbjSIZ16x_I&feature=youtu.be (12:05~29:26)
// answer1 : https://atcoder.jp/contests/agc043/submissions/11072807
// answer2 : https://atcoder.jp/contests/agc043/submissions/11073660

public class BmainController {
	
	public static void main(String[] args) {

		// ���p����v�Z���@�̕ύX
		Tringle123 tringle = new Tringle123Impl();
		//Tringle123 tringle = new Tringle123LoopImpl();

		// ������ a_1,a_2,a_3,...,a_n��ints�Ƃ��A���̒���N��length�Ƃ���
		//int ints[] = {1,2,3};
		int ints[] = {1,2,3,1,2,2};
		int length = ints.length;

		// ints��x_(N,1)���o��
		System.out.println("ints�� x_(N,1)=" + tringle.calculationXN1(length, ints));
		
		//�@�e�X�g�@�f�[�^�p�^�[���m�F�p�Ə������x�m�F�p
		test(tringle);
	}
	
	//�@�e�X�g�p���\�b�h
	public static void test(Tringle123 tringle) {
		
		System.out.println("*****test*****");
		
		// �f�[�^�p�^�[���m�F
		// ints1000��x_(N,1)���o��
		System.out.println("ints1000�� x_(N,1)=" + tringle.calculationXN1(ints1000.length, ints1000));
		// ints2��x_(N,1)���o��
		System.out.println("ints2�� x_(N,1)=" + tringle.calculationXN1(ints2.length, ints2));
		
		//�@�������x�m�F�p
		int randomLength = 50000;
		int intsRandomN[] = new int[randomLength];
		Random randomnuber = new Random();
		for (int i = 0 ; i < randomLength ; i++) {
			intsRandomN[i] = randomnuber.nextInt(3) + 1;
		}
				
		// ���Ԍv���p
		long start_point = System.currentTimeMillis();
		// intsRandomN��x_(N,1)���o��
		System.out.println("intsRandomN�� x_(N,1)=" + tringle.calculationXN1(intsRandomN.length, intsRandomN));
		// ���Ԍv���p
		long end_point = System.currentTimeMillis();
		System.out.println("�����ɗv��������" +  (end_point - start_point) + "�~���b");

	}
	
	// �e�X�g�f�[�^ints1000�Aints2�AintsRandomN��錾
	
		static int ints1000[] = {1,2,3,1,3,1,3,3,1,2,3,1,2,2,3,1,2,3,1,2,2,3,1,3,3,
				1,2,3,1,2,2,3,1,2,3,1,2,3,2,2,3,1,3,3,1,2,3,1,3,3,
				1,2,3,1,2,2,3,1,2,3,1,2,3,1,2,2,3,1,2,3,1,2,2,3,1,
				3,3,1,2,3,1,3,3,1,2,3,1,2,2,3,1,2,3,1,2,3,1,2,2,3,
				1,2,3,1,2,2,3,1,2,3,1,2,3,1,2,2,3,1,2,3,1,2,2,3,1,
				3,3,1,2,3,1,3,3,1,2,3,1,2,2,3,1,2,3,1,2,3,1,2,2,3,
				1,2,3,1,1,2,2,2,3,3,1,2,3,1,2,3,1,2,2,3,1,2,3,1,2,
				2,3,1,2,3,1,2,2,3,1,2,3,1,2,2,3,1,2,2,3,1,2,3,1,2,
				1,2,3,1,2,2,3,1,2,3,1,2,3,1,2,2,3,1,2,3,1,2,2,3,1,
				3,3,1,2,3,1,3,3,1,2,3,1,2,2,3,1,2,3,1,2,3,1,2,2,3,
				1,2,3,1,1,2,2,2,3,3,1,2,3,1,2,3,1,2,2,3,1,2,3,1,2,
				2,3,1,2,3,1,2,2,3,1,2,3,1,2,2,3,1,2,2,3,1,2,3,1,2,
				1,2,3,1,2,2,3,1,2,3,1,2,3,1,2,2,3,1,2,3,1,2,2,3,1,
				3,3,1,2,3,1,3,3,1,2,3,1,2,2,3,1,2,3,1,2,3,1,2,2,3,
				1,2,3,1,1,2,2,2,3,3,1,2,3,1,2,3,1,2,2,3,1,2,3,1,2,
				2,3,1,2,3,1,2,2,3,1,2,3,1,2,2,3,1,2,2,3,1,2,3,1,2,
				1,2,3,1,1,2,2,2,3,3,1,2,3,1,2,3,1,2,2,3,1,2,3,1,2,
				1,2,3,1,2,2,3,1,2,3,1,2,3,1,2,2,3,1,2,3,1,2,2,3,1,
				3,3,1,2,3,1,3,3,1,2,3,1,2,2,3,1,2,3,1,2,3,1,2,2,3,
				2,3,1,2,3,1,2,2,3,1,2,3,1,2,2,3,1,2,2,3,1,2,3,1,2};
		
		static int ints2[] = {3,3,3,3,1,1,1,3,3,3,1,3,3,1,1,3,1,3,3,3,1,3,3,1,1,
				1,1,3,3,3,1,3,3,1,1,3,3,3,1,3,3,1,1,1,3,1,3,1,3,3,
				3,1,1,3,3,1,1,3,3,3,1,3,3,3,1,3,3,1,1,3,3,3,1,3,3,
				1,1,3,3,3,1,3,3,1,1,3,3,3,1,3,3,1,1,3,3,3,1,3,1,3,
				1,1,3,3,3,1,3,3,1,1,3,3,3,1,3,3,1,1,3,3,3,1,3,1,1,
				3,1,1,3,3,3,1,3,3,3,3,1,3,3,3,1,1,3,3,3,1,3,1,3,3};

//		static int randomLength = 5;
//		static int intsRandomN[] = new int[randomLength];
//
//		void init() {
//			Random randomnuber = new Random();
//			for (int i = 0 ; i < randomLength -1 ; i++) {
//				intsRandomN[i] = randomnuber.nextInt(3);
//			}
//		}
}
