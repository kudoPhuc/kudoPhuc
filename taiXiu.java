import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/*Game cá cược tài xỉu.Người chơi sẽ có một tài khoản và đặt cược theo số tiền họ có
 * Game có ba điều kiện
 * có 3 cục xí ngầu mỗi cục có 6 mặt tương ứng với 6 con số nếu lắc ra random tổng là:  
 * 1.Nếu random ra =3 || = 18 thì nhà cái ăn hết
 * 2.Nếu random ra >=4 && <=10 là xỉu
 * 3.Nếu random ran >=11 && <=17 là tài
 */
public class taiXiu {
    public static void main(String[] args) {
        Locale lc = new Locale("vi", "VN");
        NumberFormat numf = NumberFormat.getInstance(lc);
        Scanner sc = new Scanner(System.in);
        int TK = 100000;
        int chon = 0;
        int cacuoc = 0;
        int lchon = 0;
        String may = null;
        int pick = 0;
        // Phần menu
        do {
            System.out.println("*******************************");
            System.out.println("*----- Moi ban lua chon ------*");
            System.out.println("*-----  1.Game ca cuoc   -----*");
            System.out.println("*-----   2.keo,bua,bao   -----*");
            System.out.println("*-----      3.Thoat!    ------*");
            System.out.println("*******************************");
            chon = sc.nextInt();
            if (chon == 1) {
                System.out.println("------ Moi ban dat cuoc ------");
                System.out.println("------ Tai khoan hien tai cua ban:" + numf.format(TK));
                System.out.println("------ Dat cuoc phai > 0 && < " + numf.format(TK));
                cacuoc = sc.nextInt();
            }
            // Phàn game kéo,bua,bao
            if (chon == 2) {
                System.out.println("------ Keo,Bua,Bao ------");
                System.out.println("------ Tai khoan hien tai cua ban:" + numf.format(TK));
                System.out.println("------ Dat cuoc phai > 0 && < " + numf.format(TK));
                cacuoc = sc.nextInt();
                Random ran = new Random();
                int r = ran.nextInt(2) + 1;
                do {
                    System.out.println("Chon 1 = keo,2 = bua, 3 = bao");
                    pick = sc.nextInt();
                    if (pick == 1) {
                        System.out.println("Ban chon Keo!");
                    } else if (pick == 2) {
                        System.out.println("Ban chon Bua!");
                    } else {
                        System.out.println("Ban chon Bao!");
                    }

                    if (r == 1)
                        may = "keo";
                    if (r == 2)
                        may = "bua";
                    if (r == 3)
                        may = "bao";
                    System.out.println("Lua chon cua may la :" + may);
                    if (pick == 1) {
                        if (r == 1) {
                            System.out.println("Ban Hoa!");
                            System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                        } else if (r == 2) {
                            System.out.println("Ban thua!");
                            TK -= cacuoc;
                            System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                        } else {
                            System.out.println("Ban thang!");
                            TK += cacuoc;
                            System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                        }
                    }
                    if (pick == 2) {
                        if (r == 2) {
                            System.out.println("Ban Hoa!");
                            System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                        } else if (r == 3) {
                            System.out.println("Ban thua!");
                            TK -= cacuoc;
                            System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                        } else {
                            System.out.println("Ban thang!");
                            TK += cacuoc;
                            System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                        }
                    }
                    if (pick == 3) {
                        if (r == 3) {
                            System.out.println("Ban Hoa!");
                            System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                        } else if (r == 1) {
                            System.out.println("Ban thua!");
                            TK -= cacuoc;
                            System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                        } else {
                            System.out.println("Ban thang!");
                            TK += cacuoc;
                            System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                        }
                    }
                } while (pick != 0);
            }
            // Chon để thoát
            else if (chon == 3) {
                System.out.println("Ban chon Thoat!");
                break;
            }
            // Phần code cá cược
            do {
                System.out.println("---- Chon 1 <-> Tai || Chon 2 <-> Xiu ----");

                lchon = sc.nextInt();
                if (lchon == 1) {
                    System.out.println("------ Ban chon Tai! ------");
                } else {
                    System.out.println("------ Ban chon Xiu! ------");
                }
                if (lchon == 3) {
                    System.out.println("Ban da thoat tro choi nen tai khoan khong bi tru!");
                    TK += cacuoc;
                    break;
                }
            } while (lchon != 1 && lchon != 2 && lchon != 3);

            Random ngauNhien = new Random();
            Random ngauNhien1 = new Random();
            Random ngauNhien2 = new Random();
            int ng = ngauNhien.nextInt(5) + 1;
            int ng1 = ngauNhien.nextInt(5) + 1;
            int ng2 = ngauNhien.nextInt(5) + 1;
            int cong = ng + ng1 + ng2;
            System.out.println("Ket qua:" + ng + "-" + ng1 + "-" + ng2);
            if (cong == 3 || cong == 18) {
                System.out.println("Tong bang:" + cong);
                System.out.println("Nha cai an!");
                TK -= cacuoc;
                System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
            } else if (cong >= 4 && cong <= 10) {
                if (lchon == 2) {
                    System.out.println("Tong bang:" + cong + " Ket qua la Xiu!");
                    System.out.println("Ban thang!");
                    TK += cacuoc;
                    System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                } else {
                    System.out.println("Ban Thua!");
                    TK -= cacuoc;
                    System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                }

            } else if (cong >= 11 && cong <= 17) {
                if (lchon == 1) {
                    System.out.println("Tong bang:" + cong + " Ket qua la Tai!");
                    System.out.println("Ban Thang!");
                    TK += cacuoc;
                    System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                } else {
                    System.out.println("Ban Thua!");
                    TK -= cacuoc;
                    System.out.println("Tai khoan hien tai cua ban la:" + numf.format(TK));
                }
            }
            // Phần hết tiền
            if (cacuoc == 0) {
                System.out.println("Hien tai so du khong du de choi. Vui long nap them hoac thoat!");
            }
        } while (chon != 0);
    }
}