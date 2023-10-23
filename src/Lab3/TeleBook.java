package Lab3;

public class TeleBook {
    private HashTableImprove<Integer,String[]> NumberToContact = new HashTableImprove<>();
    public void setContact(int K, String[] V){NumberToContact.add(K, V);}
    public String[] findContact(int K){return NumberToContact.get(K);}
    public void removeContact(int K){NumberToContact.remove(K);}

    public static void main(String[] args){
        TeleBook myContacts = new TeleBook();
        myContacts.setContact(79192233,new String[]{"Vanya", "Hairy Wizard"});
        myContacts.setContact(89450513,new String[]{"Oleg", "Plumber"});
        myContacts.setContact(72285412,new String[]{"Ilia", "Mechanic"});
        myContacts.setContact(18002525,new String[]{"Bill", "Translator"});
        System.out.println(String.join(",",myContacts.findContact(18002525)));
    }
}