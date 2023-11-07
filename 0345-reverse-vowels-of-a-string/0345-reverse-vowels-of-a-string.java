class Solution {
    public String reverseVowels(String s) {
        int length_s=s.length();
        ArrayList<Integer> arr1 =new ArrayList<>();
        ArrayList<Character> arr2 =new ArrayList<>();
        for(int i=0;i<length_s;i++)
        {
            char c= s.charAt(i);
            if(c=='a'|| c=='e'||c=='i'|| c=='o'|| c=='u'||c=='A'|| c=='E'||c=='I'|| c=='O'|| c=='U')
            {
                arr1.add(i);
                arr2.add(c);
            }
        }
        Collections.reverse(arr2);
        StringBuilder str = new StringBuilder(s);
        int j=0;
        for(int i:arr1)
        {
            str.setCharAt(i,arr2.get(j));
            j++;
        }
        return str.toString();
    }
}