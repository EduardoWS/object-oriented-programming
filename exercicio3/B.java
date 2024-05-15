// SCC0504 - Programação Orientada a Objetos (2024)

// Nome: Eduardo Ribeiro Rodrigues
// Número USP: 13696679

// Exercise 3: Polymorphism
// Consider the definition of the class A. Define a subclass of A named B that overrides method m1() so that it makes m the difference between m and n instead of their sum.
// Also make the main method print the values shown. Do not change any existing code, just add to it.

class A {
    private int m;
    private int n;
    public A(int mIn, int nIn) {
        m = mIn;
        n = nIn;
    }
    public void m1() {
        m = m + n;
    }
 
    public String toString() {
        return "A = (" + m + ", " + n + ")";
    }
}

public class B extends A{ 
    
    private int m;
    private int n;
    
    public B(int mIn, int nIn) {
        super(mIn, nIn);
        m = mIn;
        n = nIn;
    }
    
    public void m1(){
        m = m - n;
    }

    public String toString() {
        return "B = (" + m + ", " + n + ")";
    }


    public static void main(String[] args) {
        A a = new A(1, 2);
        A b = new B(1, 2);
        System.out.println(a + " " + b);
        a.m1();
        b.m1();
        System.out.println(a + " " + b);
    }
}  