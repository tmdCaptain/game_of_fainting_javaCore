package GameMini_TaiXiu;

import java.util.Random;
import java.util.Scanner;

public class TaiXiu {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		double taiKhoanNguoiChoi = 500;
		double datCuoc = 0 ;
		double soTienNap = 0;
		int chon;
		do {
			System.out.println("---------- Mời bạn chọn-----------");
			System.out.println(" Chọn (1) để nạp thêm tiền");
			System.out.println(" Chọn (2) để tiếp tục chơi game ");
			System.out.println(" Chọn phím bất kỳ để thoát game");
			chon = sc.nextInt();
			switch(chon) {
				case 1:
					System.out.println(" Tài khoản hiện tại " + taiKhoanNguoiChoi);
					System.out.println(" Nhập số tiền mà bạn nạp vào tài khoản");
					soTienNap = sc.nextDouble();
					taiKhoanNguoiChoi+= soTienNap;
					System.out.println(" Tài khoản của bạn sau khi nạp số tiền: " +soTienNap
							+ " là: " + taiKhoanNguoiChoi );
					break;
				case 2:
					do {
						System.out.println(" Tài khoản hiện tại " + taiKhoanNguoiChoi );
						System.out.println(" Đặt cược (0 < số tiền cược <= " + taiKhoanNguoiChoi + ")");
						System.out.println(" Mời bạn đặt cược:");
						datCuoc = sc.nextDouble();
					}while(datCuoc<=0 || datCuoc > taiKhoanNguoiChoi);
					
					
//					Lựa chọn tài hoặc xỉu
					int luaChonTaiXiu = 0;
					do {
						System.out.println("1. Tài");
						System.out.println("2. Xỉu");
						System.out.println(" Mời lựa chọn:");
						luaChonTaiXiu = sc.nextInt();
					}while(luaChonTaiXiu!=1&&luaChonTaiXiu!=2);

//					Tung xúc xắc để biết tài hay xỉu
					Random xucsac1 = new Random();
					Random xucsac2 = new Random();
					Random xucsac3 = new Random();
					
//					Xúc xắc có 6 giá trị từ 1 - 6, trong random nó sẽ sinh ra từ 0 - 5 
//					chúng ta phải +1 để thành từ 1-6 như con xúc sắc
					int giatri1 = xucsac1.nextInt(5)+1;
					int giatri2 = xucsac1.nextInt(5)+1;
					int giatri3 = xucsac1.nextInt(5)+1;
					int tong = giatri1 + giatri2 + giatri3;
//					Kết quả từng con lắc
					System.out.println(" Kết quả từng xúc xắc");
					System.out.print(" Xúc xắc thứ nhất: " + giatri1 + "");
					System.out.print(" Xúc xắc hai: " + giatri2 + "");
					System.out.println(" Xúc xắc ba:  " + giatri3 + "");
					
					if(tong ==3 || tong ==18) {
						System.out.println(" Kết quả xúc sắc " + tong);
						System.out.println(" Bạn đã thua ");
						taiKhoanNguoiChoi-=datCuoc;
						System.out.println(" Tài khoản của bạn hiện tại " + taiKhoanNguoiChoi);
					}else if(tong>=4&&tong <=10) {
						System.out.println(" Kết quả xúc sắc " + tong + "=> Xỉu");
						if(luaChonTaiXiu==2) { 
							System.out.println(" Bạn đã thắng cược ");
							taiKhoanNguoiChoi+=datCuoc;
							System.out.println(" Tài khoản của bạn hiện tại " + taiKhoanNguoiChoi);
						}else { 
							System.out.println(" Bạn đã thua cược ");
							taiKhoanNguoiChoi-=datCuoc;
							System.out.println(" Tài khoản của bạn hiện tại " + taiKhoanNguoiChoi);
						}
					}else {
						System.out.println(" Kết quả xúc sắc " + tong + "=> Tài");
						if(luaChonTaiXiu==1) { 
							System.out.println(" Bạn đã thắng cược ");
							taiKhoanNguoiChoi+=datCuoc;
							System.out.println(" Tài khoản của bạn hiện tại " + taiKhoanNguoiChoi);
						}else {
							System.out.println(" Bạn đã thua cược ");
							taiKhoanNguoiChoi-=datCuoc;
							System.out.println(" Tài khoản của bạn hiện tại " + taiKhoanNguoiChoi);
						}
					}
					break;	
				default:
					System.out.println(" Out Game!!");
			}
		}while(chon==1||chon==2);
	}


}
