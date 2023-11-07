package Lab3;

import java.util.Arrays;

public class TeleBook {
    public int getSize(){return NumberToContact.size();}
    private HashTableImprove<Integer,TeleContact> NumberToContact = new HashTableImprove<>();
    public void setContact(int K, String A, String B, String C){
        TeleContact V = new TeleContact();
        V.setName(A);
        V.setMail(B);
        V.setAdditional(C);
        NumberToContact.add(K, V);
    }
    public String findContact(int K){
        if(NumberToContact.isEmpty(K)){return "No Contact";};
        return "[" + K + " " + NumberToContact.get(K).getName()+" "+NumberToContact.get(K).getMail()+" "+NumberToContact.get(K).getAdditional()+"],";
    }
    public Integer[] Finale(int x){
        return NumberToContact.Fin(x);
    }
    public void removeContact(int K){NumberToContact.remove(K);}

    public static void main(String[] args) {
        TeleBook myContacts = new TeleBook();
        myContacts.setContact(79192233, "Vanya", "Hairy Wizard", "None");

        for (int i = 0; i < myContacts.NumberToContact.getNumBucket(); i++) {
            System.out.print(i);
            Integer[] keys = myContacts.Finale(i);
            for (int j = 0; j < keys.length; j++) {
                System.out.print(myContacts.findContact(keys[j]));
            }
            System.out.println();
        }


        myContacts.setContact(89450513, "Oleg", "Plumber", "None");
        myContacts.setContact(72285413, "Ilia", "Mechanic", "Reliable");
        myContacts.setContact(18002523, "Bill", "Translator", "Expensive");
        myContacts.setContact(18002525, "Bill Jr", "Translator", "Cheap, Son not Dad");


        for (int i = 0; i < myContacts.NumberToContact.getNumBucket(); i++) {
            System.out.print(i);
            Integer[] keys = myContacts.Finale(i);
            for (int j = 0; j < keys.length; j++) {
                System.out.print(myContacts.findContact(keys[j]));
            }
            System.out.println();
        }
    }
}
// Нужно показать заполненность таблицы, одну заполненую на еденицу позицию и одну заполненную на 3 позицию
// И вывести с этих позиций всё что на них заполнено