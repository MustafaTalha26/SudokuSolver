package example.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Board {
	Piece[][] all;
	int[] temp;
	
	public Board() {
		all = new Piece[9][9];
		for(int x = 0; x < 9; x++) {
			for(int y = 0; y < 9; y++) {
				all[x][y] = new Piece();
			}
		}
	}
	void setBoardNew(String txtfile) throws IOException {
		String[] lines = new String[9];
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(txtfile));
			String line = reader.readLine();
			int count = 0;
			while (line != null) {
				lines[count] = line;
				count++;
				line = reader.readLine();
			}

			reader.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 9; i++) {
			String parsel = lines[i];
			int niner = 0;
			for(int j = 0; j < parsel.length(); j++) {
				if(parsel.charAt(j) == ' ') {

				}
				if(parsel.charAt(j) == '0') {
					niner++;
				}
				if(parsel.charAt(j) != ' ' && parsel.charAt(j) != '0') {
					int x = Character.getNumericValue(parsel.charAt(j));
					all[i][niner].setMod(1);
					temp = new int[1];
					temp[0] = x;
					all[i][niner].setList(temp);
					niner++;
				}
			}
			niner = 0;
		}
		
	}
	void showNakedBoard() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(all[i][j].getMod() == 1) {
					System.out.print(all[i][j].list[0]);
					System.out.print(" ");
				}
				else {
					System.out.print(" ");
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	void prepareLists() {
		for(int i = 0;i < 9; i++) {
			for(int j = 0;j < 9; j++) {
				all[i][j] = new Piece();
			}
		}
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				int[] bruh = new int[9];
				for(int x = 0; x < 9; x++) {
					bruh[x] = x+1;
				}
				all[i][j].setMod(2);
				all[i][j].setList(bruh);
			}
		}
		System.out.println();
	}
	void showSpot(int x, int y) {
		System.out.println();
		int[] temp = all[x][y].getList();
		for(int i = 0; i < 9; i++) {
			System.out.print(temp[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	void horizontalDel() {		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(all[i][j].getMod()==1) {
					for(int a = 0; a < 9; a++) {
						if(all[i][a].getMod()==2) {
							all[i][a].removeFromList(all[i][j].modOneGet());
						}
					}
				}
			}
		}
	}
	void verticalDel() {		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(all[j][i].getMod()==1) {
					for(int a = 0; a < 9; a++) {
						if(all[a][i].getMod()==2) {
							all[a][i].removeFromList(all[j][i].modOneGet());
						}
					}
				}
			}
		}
	}
	void groupSet() {
		int groupno = 1;
		for(int a = 0; a < 3; a++) {
			for(int b = 0; b < 3; b++) {
				for(int i = 0; a*3+i < (a+1)*3; i++) {
					for(int j = 0; b*3+j < (b+1)*3; j++) {
						all[a*3+i][b*3+j].setGroup(groupno);
					}
				}
				groupno++;
			}
		}
	}
	void groupDel1() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(all[i][j].getMod()==1) {
					for(int a = 0; a < 9; a++) {
						for(int b = 0; b < 9; b++) {
							if(all[a][b].getMod()==2 && all[i][j].getGroup() == all[a][b].getGroup()) {
								all[a][b].removeFromList(all[i][j].modOneGet());
							}
						}
					}
				}
			}
		}
	}
	void groupDel2() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(all[i][j].getMod()==1) {
					for(int a = 0; a < 9; a++) {
						for(int b = 0; b < 9; b++) {
							if(all[a][b].getMod()==2 && all[i][j].getGroup() == all[a][b].getGroup()) {
								all[a][b].removeFromList(all[i][j].modOneGet());
							}
						}
					}
				}
			}
		}
	}
	void checkClearity() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(all[i][j].mod == 2) {
					all[i][j].checkList();
				}
			}
		}
	}
	int checkFull() {
		int c = 0;
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				if(all[i][j].mod == 2) {
					c++;
				}
			}
		}
		return c;
	}
}
