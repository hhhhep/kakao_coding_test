public class Tmon {
	public static String str1, str2, sub;
	public static int max = 0, len1, len2;

	public static void main(String[] args) {
		String first = "photography";
	    String second = "autography";

	    int longestCommon = 0;
	    int compareValue = 0;
	    String commonstring = null;

	    for(int i = 0 ; i < first.length() ; i++){

	        for(int j = 0 ; j < second.length() ; j++){

	            if(first.charAt(i) == second.charAt(j)){

	                int minoftwo = Math.min(first.length(), second.length());
	                String common = "";

	                for(int k = 0 ; k < minoftwo  ; k++){

	                    try{
	                        if(first.charAt(i+k)==second.charAt(j+k)){
	                            common=common.concat(String.valueOf(first.charAt(i+k)));
	                            longestCommon++;
	                        }
	                    }catch(StringIndexOutOfBoundsException e){

	                    }


	                }
	                if(longestCommon > compareValue){
	                    compareValue = longestCommon;
	                    commonstring = common;
	                }
	                longestCommon=0;
	            }

	        }

	    }
	    System.out.println(commonstring+" 공통 문자열");
	    System.out.println(compareValue+" 공통 문자열 길이");
	}

	public static void q1(String[] strs) {		
		StringBuilder result = new StringBuilder();
		boolean same = true;

		for(int i = 0; i < strs[0].length(); i++) {
			char temp = strs[0].charAt(i);
			for(int j = 1; j < strs.length; j++) {
				if(strs[j].length() <= i) {
					same = false;       
					break;   
				}
				else if(temp == strs[j].charAt(i)) {
					continue;
				}
				same = false;       
				break;
			}

			if(same) result.append(temp);
			else break;
		}

		System.out.println(result.toString());
	}
	
	public static int q2(int arg) {
	    for (byte i = 32; i > 0; i--)
	    {
	        var b = (int)1 << (i - 1);
	        if ((arg & b) == b)
	            return i;
	    }
	    return 0;
	}
}
