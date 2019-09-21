import java.util.HashMap;

public class CustomerStorage
{
    final String EMAIL_FORMAT = "[A-Za-z0-9]+\\S[A-Za-z0-9]+[@][A-Za-z0-9]+[.][a-zA-Z]{2,5}$";
    final String NUMBER_FORMAT = "[+]\\d+";

    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
        if (components.length != 4){
            throw new IllegalArgumentException("Wrong format. Correct format: add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        String name = components[0] + " " + components[1];
        if (!components[2].matches(EMAIL_FORMAT)){
            throw new IllegalArgumentException("Wrong e-mail format. Correct format: abc111@def222.com");
        }
        if (!components[3].matches(NUMBER_FORMAT)){
            throw new IllegalArgumentException("Wrong phone number format. Correct format: +123456789");
        }
        storage.put(name, new Customer(name, components[3], components[2]));
    }

    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        if (!storage.containsKey(name)){throw new IllegalArgumentException("Wrong name written");}
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}