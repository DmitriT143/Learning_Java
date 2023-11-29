import java.lang.reflect.Array;
import java.util.*;
import java.time.*;
import java.util.regex.Pattern;

public class BootStrappedMatrix {
    public static void main(String[] args) {
        System.out.println("Answers to fifth practise work");
        System.out.println("1)" + SamePattern("ABAB", "CDCD"));
        System.out.println("1)" + SamePattern("ABCBA", "BCDCB"));
        System.out.println("1)" + SamePattern("EDCBA", "IHGFE"));
        System.out.println("1)" + SamePattern("FFGG", "CDCD"));
        System.out.println("1)" + SamePattern("FFFF", "ABCD"));
        System.out.println("2)" + SpiderPath("H3", "E2"));
        System.out.println("2)" + SpiderPath("A4", "B2"));
        System.out.println("2)" + SpiderPath("A2", "C4"));
        System.out.println("3)" + recursiveNumLength("4666"));
        System.out.println("3)" + recursiveNumLength("544"));
        System.out.println("3)" + recursiveNumLength("121317"));
        System.out.println("3)" + recursiveNumLength("0"));
        System.out.println("3)" + recursiveNumLength("12345"));
        System.out.println("3)" + recursiveNumLength("1289396387328L"));
        System.out.println("4)" + PiratedScrambleCounter(new String[]{"cat", "create", "sat"},"caster"));
        System.out.println("4)" + PiratedScrambleCounter(new String[]{"trance", "recant"}, "recant"));
        System.out.println("4)" + PiratedScrambleCounter(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println("5)" + Arrays.deepToString(upTo8(new Integer[]{1, 2, 3, 4, 5})));
        System.out.println("5)" + Arrays.deepToString(upTo8(new Integer[]{1, 2, 3, 7, 9})));
        System.out.println("5)" + Arrays.deepToString(upTo8(new Integer[]{10, 9, 7, 2, 8})));
        System.out.println("5)" + Arrays.deepToString(upTo8(new Integer[]{1, 6, 5, 4, 8, 2, 3, 7})));
        System.out.println("6)" + takeDownBy5(new int[]{95, 83, 90, 87, 88, 93}) );
        System.out.println("6)" + takeDownBy5(new int[]{10}));
        System.out.println("6)" + takeDownBy5(new int[]{53,79}));
        System.out.println("7)" + Ceasar("hello world Zombie",true,3));
        System.out.println("7)" + Ceasar("KHOOR ZRUOG CRPELH",false,3));
        System.out.println("7)" + Ceasar("almost last task!",true,4));
        System.out.println("7)" + Ceasar("EPQSWX PEWX XEWO",false,4));
        System.out.println("8)" + placementWithoutRepeat(5, 3));
        System.out.println("8)" + placementWithoutRepeat(7, 3));
        System.out.println("9)" + dateCityToCity("Los Angeles","April 1 2011, 23:23","Canberra") );
        System.out.println("9)" + dateCityToCity("London","July 31, 1983 23:01","Rome") );
        System.out.println("9)" + dateCityToCity("New York","December 31, 1970, 13:40","Beijing") );
        System.out.println("10)" + isSmallest(3));
        System.out.println("10)" + isSmallest(30));
        System.out.println("10)" + isSmallest(321));
        System.out.println("10)" + isSmallest(123));
        System.out.println("10)" + isSmallest(1307));
    }

    // Pattern goes like <>< or >><< or =>= or any other
    // May use CharNumber to get proper pattern like > < =
    public static boolean SamePattern(String Pattern, String CheckOn){
        String[] PatternSplit = Pattern.split("");
        String[] PatternCopySplit = CheckOn.split("");
        for (int i = 0; i < Pattern.length()-2; i++){
            if ((int)CheckOn.charAt(i) - (int)CheckOn.charAt(i+1) != (int)Pattern.charAt(i)-(int)Pattern.charAt(i+1))
            {return false;};
        }
        return true;
    }

    //Spider has a Net it goes like A-00 B-45 C-90 D-135 E-180 F-225 G-270 H-315
    //Poses by R goes by 1-4 so eh. we have sin and R that's it
    //Length L by ABCDEFGH = 2*r*0,707 or goTo R for 1 per R
    public static String SpiderPath (String SpiderPos, String FlyPos){
        int i = 0;
        String[] CurFlyPos = FlyPos.split("");
        String[] CurrentPos = SpiderPos.split("");
        String Path = SpiderPos;
        while (!CurrentPos[0].equals(CurFlyPos[0]) || !CurrentPos[1].equals(CurFlyPos[1])){
            if (CurrentPos[1].equals("0") && CurrentPos[0] != CurFlyPos[0]){CurrentPos[0] = CurFlyPos[0];}
            if ( (int) CurrentPos[0].charAt(0) - (int) CurFlyPos[0].charAt(0) > 2){ CurrentPos[1] =String.valueOf(Integer.parseInt(CurrentPos[1])-1);
            } else if ( (int) CurrentPos[0].charAt(0) == (int) FlyPos.charAt(0)){
                if (Integer.parseInt(CurrentPos[1]) > Integer.parseInt(CurFlyPos[1])){CurrentPos[1] = String.valueOf(Integer.parseInt(CurrentPos[1])-1);}
                else if (Integer.parseInt(CurrentPos[1]) < Integer.parseInt(CurFlyPos[1])){CurrentPos[1] = String.valueOf(Integer.parseInt(CurrentPos[1])+1);}
            } else if( (int) CurrentPos[0].charAt(0) - (int) CurFlyPos[0].charAt(0) < 2){
                if ((int)CurrentPos[1].charAt(0) == (int) FlyPos.charAt(1)){
                    if (CurrentPos[0].charAt(0)>FlyPos.charAt(0)){CurrentPos[0] = Character.toString((CurrentPos[0].charAt(0)-1));}
                    if (CurrentPos[0].charAt(0)<FlyPos.charAt(0)){CurrentPos[0] = Character.toString((CurrentPos[0].charAt(0)+1));}
                }
                    else {
                        if(CurrentPos[1].charAt(0) > FlyPos.charAt(1)){CurrentPos[1] = String.valueOf(Integer.parseInt(CurrentPos[1])-1);}
                        else{CurrentPos[0] = Character.toString((CurrentPos[0].charAt(0)+1));}
                }
            }
            Path = Path+","+String.join("",CurrentPos);
            i++;
            if (i==6){break;}
        }
        return Path;
    }
    public static Integer recursiveNumLength(String b){
        try {
            long a = Long.parseLong(b);
            if (a > 10)
                return 1 + recursiveNumLength(String.valueOf(a/10));
            else return 1;}
        catch (NumberFormatException e){ return 0 + recursiveNumLength(b.substring(0, b.length()-1));}
    }


    //first find anagrams (+50)
    //Second take away not correct words
    //Than translate each word to points like word.len - 3 + bonuses beforehand
    public static int PiratedScrambleCounter(String[] guessed, String word){
        int score = 0;
        String[] forAnagram = word.split(""); Arrays.sort(forAnagram);
        for (int i = 0; i < guessed.length; i++) {
            String[] wordle = guessed[i].split(""); Arrays.sort(wordle);
            if (Arrays.equals(wordle, forAnagram)){score=score+50+guessed[i].length()-2;}
            else{ boolean right = true;
                String check = word;
                for (int j = 0; j < guessed[i].length(); j++){
                    if (!check.contains(wordle[j])){right = false;}
                    else {int remove = check.indexOf(wordle[j]); check = check.substring(0,remove) + check.substring(remove+1);}
                }
                if (right){score = score + guessed[i].length()-2;}
            }
        }
        return score;
    }
    // TODO
    public static Integer[][] upTo8(Integer[] listed){Integer[] temp = new Integer[0];int TopLim = 1;int DownLim = 0;
        ArrayList<Integer[]> toOut = new ArrayList<>();
        while (TopLim < listed.length){
            if(listed[TopLim]+listed[DownLim] == 8){temp= new Integer[]{listed[TopLim], listed[DownLim]};Arrays.sort(temp); toOut.add(temp);}
            DownLim++;
            if(DownLim == TopLim){TopLim++;DownLim = 0;}
        }
        Integer[][] out = new Integer[toOut.size()][];
        for (int i = 0; i < toOut.size(); i++) {
            out[i] = toOut.get(i);
        }
        return out;
    }
    public static String takeDownBy5(int[] grades){
        int myGrade;
        int Prev = 0;
        for(int i = 0; i < grades.length; i++)
            Prev = Prev + grades[i];
        myGrade = Prev / (grades.length) - 5 * (grades.length+1);
        return "\""+myGrade +"%\"";
    }
    public static String Ceasar(String text, boolean encode, int movedBy){
        if (Math.abs(movedBy)>26){movedBy = movedBy%26;}
        if(!encode){movedBy = -movedBy;}
        text = text.toUpperCase();
        String MustBeMoved = text.replaceAll("[^A-Z]","");
        String[] Placeholder =MustBeMoved.split("");
        if (movedBy > 0){Arrays.sort(Placeholder, Collections.reverseOrder());}
        else Arrays.sort(Placeholder);
        for (int i = 0; i < Placeholder.length-1; i++) {
            if (Placeholder[i].equals(Placeholder[i+1])){Placeholder[i] = "";}
        }
        MustBeMoved = String.join("",Placeholder);
        System.out.println(text);
        for (int i = 0; i < MustBeMoved.length(); i++) {char newChar; char oldChar = MustBeMoved.charAt(i);
            if (oldChar + movedBy > 90){newChar = (char)(oldChar+movedBy+6);}
            else if(oldChar + movedBy < 65){newChar = (char)(oldChar+movedBy+58);}
            else {newChar = (char)(oldChar + movedBy);}
            text = text.replace(oldChar,newChar);
        }
        text = text.toUpperCase();
        return text;
    }
    public static int placementWithoutRepeat(int n, int k){
        int factorialn = 1; int factorialk = 1;
        for(int fact = 2; fact <= n; fact++) {
            factorialn *= fact;
            if (fact == (n - k)){ factorialk = factorialn;}
        }
    k = factorialn/factorialk;
    return k;
    }
    public static String dateCityToCity (String cityA, String date, String cityB){
        String[] Month = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        Hashtable<String, Double> timeCity = new Hashtable<>();
        timeCity.put("Los Angeles",-8.00);
        timeCity.put("New York",-5.00);
        timeCity.put("Caracas",-4.50);
        timeCity.put("Buenos Aires",-3.00);
        timeCity.put("London",-0.00);
        timeCity.put("Rome",+1.00);
        timeCity.put("Moscow",+3.00);
        timeCity.put("Tehran",+3.50);
        timeCity.put("New Delhi",+5.50);
        timeCity.put("Beijing",+8.00);
        timeCity.put("Canberra",+10.00);
        String[] DatInfo = date.replace(",","").split(" "); // 0 - M 1 - DD 2 - YYYY 3-Time (H - M)
        for (int i = 0; i < Month.length; i++) {
            if (DatInfo[0].equals(Month[i])){DatInfo[0] = String.valueOf(i+1);}
        }
        try {
        } catch (NumberFormatException e){return "Error encountered in Month";}
        Double time = Double.parseDouble(DatInfo[3].replace(":",".")) - timeCity.get(cityA) + timeCity.get(cityB);
        if (time > 24.00){time = time - 24.00; DatInfo[1]=String.valueOf(Integer.parseInt(DatInfo[1])+1);}
        else if (time < 00.00){time = time + 24.00; DatInfo[1]=String.valueOf(Integer.parseInt(DatInfo[1])-1);}
        Month referenceMonth = java.time.Month.of(Integer.parseInt(DatInfo[0]));
        YearMonth yearMonth = YearMonth.of(Integer.parseInt(DatInfo[2]),referenceMonth); int minMonthLenght = yearMonth.lengthOfMonth();
        if (Integer.parseInt(DatInfo[1]) > minMonthLenght){DatInfo[1] = String.valueOf(Integer.parseInt(DatInfo[1]) - minMonthLenght); DatInfo[0] = String.valueOf(Integer.parseInt(DatInfo[0])+1);}
        if (Integer.parseInt(DatInfo[1]) <= 0){DatInfo[1] = String.valueOf(Integer.parseInt(DatInfo[1])-1);
        referenceMonth = java.time.Month.of(Integer.parseInt(DatInfo[1])); yearMonth = YearMonth.of(Integer.parseInt(DatInfo[2]),referenceMonth);
        minMonthLenght = yearMonth.lengthOfMonth(); DatInfo[1] = String.valueOf(minMonthLenght);}
        if(Integer.parseInt(DatInfo[0])>12){ DatInfo[0]="1"; DatInfo[2] = String.valueOf(Integer.parseInt(DatInfo[2])+1);}
        if(Integer.parseInt(DatInfo[0])<0){ DatInfo[0]="11"; DatInfo[2] = String.valueOf(Integer.parseInt(DatInfo[2])-1);}
        DatInfo[0] = String.valueOf(Integer.parseInt(DatInfo[0]));
        return DatInfo[2]+"-"+DatInfo[0]+"-"+DatInfo[1]+" "+ String.format("%.2f", time).replace(",",":");
    }
    public static boolean isSmallest(int input){
        String[] Placeholder = String.valueOf(input).split(""); int ZeroCounter = 0;
        Integer[] unChanged = new Integer[Placeholder.length]; ArrayList<Integer> Egor = new ArrayList<>();
        for (int i = 0; i < Placeholder.length; i++){
            unChanged[i] = Integer.parseInt(Placeholder[i]);
            if (Integer.parseInt(Placeholder[i])==0){ZeroCounter++;} else Egor.add(Integer.parseInt(Placeholder[i]));
        }Collections.sort(Egor);
        while (ZeroCounter!=0){ZeroCounter--;Egor.add(1,0);}
        Integer[] glued = Egor.toArray(new Integer[0]);
        if (Arrays.equals(glued, unChanged))
            return true;
        return false;
    }
}
