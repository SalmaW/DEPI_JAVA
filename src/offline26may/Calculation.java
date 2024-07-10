package offline26may;

//structure programming:
//sequence - branching - looping

/*OOP concepts: after ANALYSIS - APIE
 * 1. Abstraction -> focused on the base,objects to class, as they share the same features/functions
 *      abstract keyword:
 *          for class -> must be --inherited--
 *          for method -> must be --overriden--
 *      final for method: to NOT be overriden
 *      final for class: to NOT be inherited
 *      final for variable: to be constant
 *
 *      - final and abstract used for performance
 *
 *      - protected for variable: (bad practice) variable just seen to the children of the super ONLY
 *
 *      - CLASS CANNOT BE INHERITED AND CANNOT CREATE FROM AN IT OBJECT.
 *
 *      - static for variable -> seen in ALL classes as 1 variable, like: public static int bios = 512;
 *
 * 2. Encapsulation -> start after -Abstraction-,*data grouping, by nature the properties/variables are Private and functions are Public which all of this known as (*data hiding)
 *      validation: as in SET AND GET
 * 3. Inheritance -> (between classes only) super/base class and child/subclass, *code reuse, substitution role, *substitution = الإحلال
 *      class casting: Person p = new Student(); --> Student s = (Student) p;   the _sub_ can replace the _super_ NOT THE OTHER WAY (الابن يحل محل الأب)
 * 4. Polymorphism -> (related to inheritance) override => main concept of Polymorphism, and it's useful for --code reuse--, overload
 *
 */

/*
when asked about What is the diff between Class and Object? give example from life
when asked about the meaning of something say the usability of it
*/

public class Calculation {
    // this class can be used between 2 or more users
    private int a, b; //class level variables

    public Calculation(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void sum() {
        int c = a + b;
        System.out.println(c);
    }

    public void subtract() {
        int c = a - b;
        System.out.println(c);
    }
}
