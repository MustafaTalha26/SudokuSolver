package example.com;

import java.io.IOException;

public class Solver {

	public static void main(String[] args) {
		Board tahta = new Board();
		tahta.prepareLists();
		try {
			tahta.setBoardNew("dark.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		tahta.showNakedBoard();
		tahta.groupSet();
		int c = -1;
		int prev = 0;
		while(c != 0) {
			tahta.horizontalDel();
			tahta.verticalDel();
			tahta.groupDel1();
			tahta.checkClearity();
			prev = c;
			c = tahta.checkFull();
			if(prev == c) {
				c = 0;
			}
		}
		tahta.showNakedBoard();
	}

}
