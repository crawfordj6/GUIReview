package GUIReview;

public class DanceDemo {

    public static void main(String[] args) {
        // 1.
        Safety s = new Safety();
        s.dance();
        
        // 2.
        dancingThing(s);
        
        // 3.
        dancingThing(() -> { System.out.println("*Safety Dance*"); } );
        dancingThing(() -> { System.out.println("*Dancing Queen*"); } );
    }
    
    public static void dancingThing(Danceable obj) {
        obj.dance();
    }

}
