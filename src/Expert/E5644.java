package Expert;

import java.util.Scanner;

public class E5644 {
	static int M,A; 
	static int a[],b[],ti[];
	static int cnt = 0;
	static int map[][];
	static Dot bc[];
	static int di[][] = {{0,0},{0,-1},{1,0},{0,1},{-1,0}};
	public static void move() {
		int ax = 1,ay = 1;
		int bx = 10,by = 10;
		ti[0] = com(ax,ay,bx,by);
		for(int i=1;i<=M;i++) {
			ax += di[a[i-1]][0];
			ay += di[a[i-1]][1];
			bx += di[b[i-1]][0];
			by += di[b[i-1]][1];
			ti[i] = com(ax,ay,bx,by);
			//System.out.println(i+"번째:"+ti[i]);
			//System.out.println(i+"번째. ("+ax+","+ay+")"+"("+bx+","+by+")");
		}
	}
	public static int com(int ax,int ay,int bx,int by) {
		int distance_a = 0;
		int distance_b = 0;
		int a=0,b = 0;
		int max_sum = 0;
		int ab_sum = 0;
		int bi = 0;
		int ai = 0;
		
		for(int i=0;i<A;i++) {
			distance_a = Math.abs(bc[i].x - ax) + Math.abs(bc[i].y - ay);
			if(distance_a <= bc[i].c) {
				a = bc[i].p;
				ai = i;
			}
			else { 
				ai = 101; 
				a = 0;
				}
			for(int j=0;j<A;j++) {
				distance_b = Math.abs(bc[j].x - bx) + Math.abs(bc[j].y - by);
				if(distance_b <= bc[j].c) {
					b = bc[j].p;
					bi = j;
				}
				else {
					b = 0;
					bi = 100;
				}
				ab_sum = a+b;
				if(ai==bi) {
					ab_sum/=2;
				}
				if(ab_sum > max_sum) {
					max_sum = ab_sum;
				}
			}
		}
		return max_sum;
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t=1;t<=tc;t++) {
			M = sc.nextInt();
			A = sc.nextInt();
			a = new int[M];
			b = new int[M];
			ti = new int[M+1];
			map = new int[11][11];
			bc = new Dot[A];
			for(int i=0;i<M;i++) {
				a[i] = sc.nextInt();
			}
			for(int i=0;i<M;i++) {
				b[i] = sc.nextInt();
			}
			
			for(int i=0;i<A;i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int c = sc.nextInt();
				int p = sc.nextInt();
				bc[i] = new Dot(x,y,c,p);
			}
			
			move();
			int sum = 0;
			for(int j=0;j<=M;j++) {
				sum += ti[j];
			}
			System.out.println("#"+t+" "+sum);
		}
	}
	public static class Dot{
		int x;
		int y;
		int c;
		int p;
		public Dot(int x,int y,int c,int p) {
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
		}
	}
}
