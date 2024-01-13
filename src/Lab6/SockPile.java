package Lab6;

public class SockPile {
    static HomebrewStack<String> SockPile = new HomebrewStack<String>(10);

    public static void main(String[] args) {
        SockPile.addItem("Yellow pair");
        SockPile.addItem("Brown pair");
        SockPile.addItem("Red pair");
        SockPile.addItem("Blue pair");
        System.out.println(SockPile.peak());
        SockPile.pop();
        SockPile.pop();
        System.out.println(SockPile.pop());
        System.out.println(SockPile.pop());
        SockPile.addItem("Red pair");
        System.out.println(SockPile.pop());
        SockPile.addItem("Blue pair");
        SockPile.addItem("Brown pair");
        System.out.println(SockPile.peak());
        System.out.println(SockPile.pop());
    }
}
