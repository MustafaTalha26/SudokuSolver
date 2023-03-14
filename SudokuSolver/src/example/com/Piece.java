package example.com;

public class Piece {
	int mod;
	int group;
	int[] list;
	public Piece() {
		list = new int[9];
	}
	public int getMod() {
		return mod;
	}
	public void setMod(int mod) {
		this.mod = mod;
	}
	public int[] getList() {
		return list;
	}
	public void setList(int[] list) {
		this.list = list;
	}
	public int getGroup() {
		return group;
	}
	public void setGroup(int group) {
		this.group = group;
	}
	public void removeFromList(int a) {
		for(int i = 0; i < 9; i++) {
			if(list[i] == a) {
				list[i] = 0;
			}
		}
	}
	public int modOneGet() {
		if(mod == 1) {
			return list[0];
		}
		else {
			return 0;
		}
	}
	public void checkList() {
		int c =0;
		int sayi = 0;
		for(int x = 0; x < 9; x++) {
			if(list[x] != 0) {
				c++;
				sayi = list[x];
			}
		}
		if(c == 0) {
			System.out.print("hata var");
		}
		if(c == 1) {
			list = new int[1];
			list[0] = sayi;
			mod = 1;
		}
	}
}
