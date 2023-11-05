package Lab3;

import java.util.Arrays;

public class TeleBook {
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
        return NumberToContact.get(K).getName()+" "+NumberToContact.get(K).getMail()+" "+NumberToContact.get(K).getAdditional();
    }
    public void removeContact(int K){NumberToContact.remove(K);}

    public static void main(String[] args) {
        TeleBook myContacts = new TeleBook();
        myContacts.setContact(79192233, "Vanya", "Hairy Wizard", "None");
        myContacts.setContact(89450513, "Oleg", "Plumber", "None");
        myContacts.setContact(72285413, "Ilia", "Mechanic", "Reliable");
        myContacts.setContact(18002523, "Bill", "Translator", "Expensive");
        System.out.println(myContacts.findContact(79192233));
        System.out.println(myContacts.findContact(18002523));
        myContacts.removeContact(79192233);
        System.out.println(myContacts.findContact(79192233) + " must be false");
        myContacts.setContact(18002525, "Bill Jr", "Translator", "Cheap, Son not Dad");
        System.out.println(myContacts.findContact(18002525));
        System.out.println(myContacts.findContact(89450513));
        System.out.println(myContacts.findContact(7919223));
        System.out.println(myContacts.findContact(72285413));
    }
}
// Нужно показать заполненность таблицы, одну заполненую на еденицу позицию и одну заполненную на 3 позицию
// И вывести с этих позиций всё что на них заполнено