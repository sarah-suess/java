import java.util.ArrayList;
public class BullTerrier extends Terrier {
    public void eat() { System.out.println("BullTerrier's eat"); } 
    public void bark() { System.out.println ("Bullterrier's bark");}

    public static void main(String[] args) {
        Object o2 = new BullTerrier();
        ((BullTerrier)o2).bark();
    }
}