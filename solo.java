public class solo {
	public static void main(String args[]) {
		String input = "1@123.23@1#0+@126.75#1#";
		//!+!=0
		//!+#=4
		//#+@=20
		//@+@=7
		//#+#=13
		int plusindex=0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i)=='+')
				plusindex = i;
		}
		int com1=-1, com2=-1;
		for(int i=0; i<plusindex; i++) {
			if(input.charAt(i)=='.')
				com1 = i;
		}
		for(int i=plusindex+1; i<input.length(); i++) {
			if(input.charAt(i)=='.')
				com2 = i;
		}
		String bith1 = input.substring(0,com1);
		String bitl1 = input.substring(com1+1,plusindex);
		String bith2 = input.substring(plusindex+1,com2);
		String bitl2 = input.substring(com2+1,input.length());
		int[] highresult;
		if(bith1.length()>bith2.length()) {
			highresult = new int[bith1.length()];
		}
		else
			highresult = new int[bith2.length()];
		int[] lowresult;
		if(bitl1.length()>bitl2.length()) {
			lowresult = new int[bitl1.length()];
		}
		else
			lowresult = new int[bitl2.length()];
		int flag = 0;
		for(int i=lowresult.length-1; i>=0; i--) {
			if(bitl1.length()>bitl2.length()&&i>=bitl2.length()) {
				lowresult[i] =  (int)bitl1.charAt(i) - '0';
			}
			else if(bitl2.length()>bitl1.length()&&i>=bitl1.length()) {
				lowresult[i] =  (int)bitl2.charAt(i) - '0';
			}
			else {
				if(bitl1.charAt(i)=='!'&&bitl2.charAt(i)=='!') {
					lowresult[i] = 0 + flag;
					flag = 0;
				}
				else if(bitl1.charAt(i)=='!'&&bitl2.charAt(i)=='#'||bitl1.charAt(i)=='#'&&bitl2.charAt(i)=='!') {
					lowresult[i] = 4 + flag;
					flag = 0;
				}
				else if(bitl1.charAt(i)=='#'&&bitl2.charAt(i)=='@'||bitl1.charAt(i)=='@'&&bitl2.charAt(i)=='#') {
					lowresult[i] = 0 + flag;
					flag = 2;
				}
				else if(bitl1.charAt(i)=='@'&&bitl2.charAt(i)=='@') {
					lowresult[i] = 7 + flag;
					flag = 0;
				}
				else if(bitl1.charAt(i)=='#'&&bitl2.charAt(i)=='#') {
					lowresult[i] = 3 + flag;
					flag = 1;
				}
				else {
					lowresult[i] = (int)bitl2.charAt(i)-'0' + bitl1.charAt(i) -'0' + flag;
					if(lowresult[i]>=10) {
						lowresult[i] = lowresult[i]%10;
						flag = 1;
					}
					else
						flag = 0;
				}
			}
		}
		for(int i=highresult.length-1; i>=0; i--) {
			if(bith1.length()>bith2.length()&&i<bith1.length()-bith2.length()) {
				highresult[i] =  (int)bith1.charAt(i) - '0' + flag;
				if(highresult[i]>=10) {
					highresult[i] = highresult[i]%10;
					flag = 1;
				}
				else
					flag = 0;
			}
			else if(bith2.length()>bith1.length()&&i<bith2.length()-bith1.length()) {
				highresult[i] =  (int)bitl2.charAt(i) - '0' + flag;
				if(highresult[i]>=10) {
					highresult[i] = highresult[i]%10;
					flag = 1;
				}
				else
					flag = 0;
			}
			else {
				int a;
				if(bith1.length()>bith2.length()) {
					a = i-(bith1.length()-bith2.length());
					if(bith1.charAt(i)=='!'&&bith2.charAt(a)=='!') {
						highresult[i] = 0 + flag;
						flag = 0;
					}
					else if(bith1.charAt(i)=='!'&&bith2.charAt(a)=='#'||bith1.charAt(i)=='#'&&bith2.charAt(a)=='!') {
						highresult[i] = 4 + flag;
						flag = 0;
					}
					else if(bith1.charAt(i)=='#'&&bith2.charAt(a)=='@'||bith1.charAt(i)=='@'&&bith2.charAt(a)=='#') {
						highresult[i] = 0 + flag;
						flag = 2;
					}
					else if(bith1.charAt(i)=='@'&&bith2.charAt(a)=='@') {
						highresult[i] = 7 + flag;
						flag = 0;
					}
					else if(bith1.charAt(i)=='#'&&bith2.charAt(a)=='#') {
						highresult[i] = 3 + flag;
						flag = 1;
					}
					else {	
							highresult[i] = (int)bith1.charAt(i)-'0' + bith2.charAt(a) -'0' + flag;
						if(highresult[i]>=10) {
							highresult[i] = highresult[i]%10;
							flag = 1;
						}
						else
							flag = 0;
					}
				}
				else {
					a = i-(bith2.length()-bith1.length());
					if(bith1.charAt(a)=='!'&&bith2.charAt(i)=='!') {
						highresult[i] = 0 + flag;
						flag = 0;
					}
					else if(bith1.charAt(a)=='!'&&bith2.charAt(i)=='#'||bith1.charAt(a)=='#'&&bith2.charAt(i)=='!') {
						highresult[i] = 4 + flag;
						flag = 0;
					}
					else if(bith1.charAt(a)=='#'&&bith2.charAt(i)=='@'||bith1.charAt(a)=='@'&&bith2.charAt(i)=='#') {
						highresult[i] = 0 + flag;
						flag = 2;
					}
					else if(bith1.charAt(a)=='@'&&bith2.charAt(i)=='@') {
						highresult[i] = 7 + flag;
						flag = 0;
					}
					else if(bith1.charAt(a)=='#'&&bith2.charAt(i)=='#') {
						highresult[i] = 3 + flag;
						flag = 1;
					}
					else {	
							highresult[i] = (int)bith1.charAt(a)-'0' + bith2.charAt(i) -'0' + flag;
						if(highresult[i]>=10) {
							highresult[i] = highresult[i]%10;
							flag = 1;
						}
						else
							flag = 0;
					}
				}	
			}
		}
		double highres = 0;
		double lowres = 0;
		if(flag!=0)
			highres = flag;
		for(int i:highresult) {
			highres = highres*10 + i;
		}
		for(int i =lowresult.length-1; i>=0; i--) {
			lowres = lowres*0.1 + lowresult[i];
		}
		double result = highres + lowres;
		System.out.print(result);	
	}
}
