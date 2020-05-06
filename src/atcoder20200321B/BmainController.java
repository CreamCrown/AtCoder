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

		// 利用する計算方法の変更
		Tringle123 tringle = new Tringle123Impl();
		//Tringle123 tringle = new Tringle123LoopImpl();

		// 数字列 a_1,a_2,a_3,...,a_nをintsとし、その長さNをlengthとする
		//int ints[] = {1,2,3};
		int ints[] = {1,2,3,1,2,2};
		int length = ints.length;

		// intsのx_(N,1)を出力
		System.out.println("intsの x_(N,1)=" + tringle.calculationXN1(length, ints));
		
		//　テスト　データパターン確認用と処理速度確認用
		test(tringle);
	}
	
	//　テスト用メソッド
	public static void test(Tringle123 tringle) {
		
		System.out.println("*****test*****");
		
		// データパターン確認
		// ints1000のx_(N,1)を出力
		System.out.println("ints1000の x_(N,1)=" + tringle.calculationXN1(ints1000.length, ints1000));
		// ints2のx_(N,1)を出力
		System.out.println("ints2の x_(N,1)=" + tringle.calculationXN1(ints2.length, ints2));
		
		//　処理速度確認用
		int randomLength = 50000;
		int intsRandomN[] = new int[randomLength];
		Random randomnuber = new Random();
		for (int i = 0 ; i < randomLength ; i++) {
			intsRandomN[i] = randomnuber.nextInt(3) + 1;
		}
				
		// 時間計測用
		long start_point = System.currentTimeMillis();
		// intsRandomNのx_(N,1)を出力
		System.out.println("intsRandomNの x_(N,1)=" + tringle.calculationXN1(intsRandomN.length, intsRandomN));
		// 時間計測用
		long end_point = System.currentTimeMillis();
		System.out.println("処理に要した時間" +  (end_point - start_point) + "ミリ秒");

	}
	
	// テストデータints1000、ints2、intsRandomNを宣言
	
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
