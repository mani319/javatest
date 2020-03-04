package com.manikanta.corejava;

/**
 * Created by Manikanta Tummalapenta on 21 Jan 2020
 *
 * References:
 * https://www.guru99.com/interface-vs-abstract-class-java.html
 * https://stackoverflow.com/questions/16781329/when-do-i-have-to-use-interfaces-instead-of-abstract-classes
 *
 */
public class InterfaceVSAbstractClass {

    public static void main(String[] args) {
        AbstractClassExample example = new ExtendedAbstractClass();
    }
}

// Interfaces help to define the peripheral abilities of a class.
interface InterfaceExample1 {

    // Can't have data variables

    // Can only have constants - public static final
    int CONSTANT1 = 1;

    // All the methods are abstract and keyword "abstract" is optional.
    // All the methods are public and can't have any other access modifiers
    void sampleMethod();

    // Java 1.8 provides default method
    default void sampleDefaultMethod() { System.out.println("This is a default method in interface!"); }
}

// An abstract class defines the identity of a class.
// An abstract class’s purpose is to provide an appropriate superclass
// from which other classes can inherit and thus share a common design.
abstract class AbstractClassExample {

    // Can have data variables
    int age;

    // Can have constants
    int CONSTANT1 = 1;

    // Methods can be either abstract or concrete - Can have access modifier

    // Abstract methods should have keyword "abstract"
    abstract void sampleAbstractMethod();

    // Sample concrete method - This makes it reusable for sub classes.
    void sampleConcreteMethod() { System.out.println("This is concrete method of Abstract class!"); }

    // Methods with access modifier
    private void samplePrivateMethod() { System.out.println("Sample private method!"); }
    protected void sampleProtectedMethod() { System.out.println("Sample protected method!"); }
}

class ExtendedAbstractClass extends AbstractClassExample {
    // Can extend only 1 abstract class

    // Only abstract methods from Abstract Class needs to be overridden. Others are optional
    @Override
    void sampleAbstractMethod() {
        System.out.println("Overridden abstract method!");
    }
}