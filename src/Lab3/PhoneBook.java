package Lab3;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
public class PhoneBook {
    private Hashtable<Integer, String[]> NumberToContact = new Hashtable<>(0,1);
    public void setContact(int k, String[]  v){
        NumberToContact.put(k,v);
    }
    public String[] findContact(int k){
        return NumberToContact.get(k);
    }
    public void removeContact(int k){
        NumberToContact.remove(k);
    }
    public void allKnownContacts(){
        Enumeration<Integer> values = NumberToContact.keys();
        Enumeration<String[]> info = NumberToContact.elements();
        while (values.hasMoreElements()){
        System.out.print(values.nextElement());
        System.out.println(" " + Arrays.toString(info.nextElement()).replace("[","").replace("]", ""));}
    }
    private int Instance;
    public PhoneBook (){Instance++;}

    public static void main(String[] args){
        PhoneBook MyContacts = new PhoneBook();
        MyContacts.setContact(79192233,new String[]{"Vanya", "Hairy Wizard"});
        MyContacts.setContact(89450513,new String[]{"Oleg", "Plumber"});
        MyContacts.setContact(72285412,new String[]{"Ilia", "Mechanic"});
        MyContacts.setContact(18002525,new String[]{"Bill", "Translator"});
        MyContacts.allKnownContacts();
    }
}
