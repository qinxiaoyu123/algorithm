package reflect;

public class Bob {
    private String name;
    public String sayHello(String s){
        return ("Hello "+s);
    }
    private void introduction(String s){
        System.out.println(s+" "+name);
    }
}
