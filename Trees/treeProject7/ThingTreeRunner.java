package treeProject7;

public class ThingTreeRunner
{
    public static void main(String[] args)
    {
        //A A A A B V S E A S A A V S E A
        ThingTree test = new ThingTree();
        test.addThing("Fachen");
        test.addThing("Baugi");
        test.addThing("Menoetius");
        test.addThing("Geryon");
        test.addThing("Fachen");
        test.addThing("Menoetius");
        test.addThing("Fachen");
        test.addThing("Menoetius");
        test.addThing("Zipacna");
        test.addThing("Baugi");
        test.addThing("Gofannon");
        test.addThing("Fachen");
        test.addThing("Cronus");
        test.addThing("Fachen");
        test.addThing("Zipacna");
        test.addThing("Geryon");
        System.out.println(test);


        test = new ThingTree();
        test.addThing("Everest");
        test.addThing("Dhaulagiri");
        test.addThing("Everest");
        test.addThing("Shispare");
        test.addThing("Ultar");
        test.addThing("Eiger");
        test.addThing("Eiger");
        test.addThing("Ultar");
        test.addThing("Fuji");
        System.out.println(test);

        /*
        *
        * Baugi - 2 Cronus - 1 Fachen - 5 Geryon - 2 Gofannon - 1 Menoetius - 3 Zipacna – 2
        * Dhaulagiri - 1 Eiger - 2 Everest - 2 Fuji - 1 Shispare - 1 Ultar - 2
        *
        *  */

    }
}
