package examples;

public class ObjectA {

    //This ObjectB is a property of ObjectA. It can be set by a constructor, or by a setter.
    private ObjectB objectB;

    /**
     *
     * @return the objectB property
     */
    public ObjectB getObjectB() {
        return objectB;
    }

    /**
     * sets the objectB property
     * @param objectB
     */
    public void setObjectB(ObjectB objectB) {
        this.objectB = objectB;
    }

    public ObjectA(ObjectB objectB){
        //this objectB (index 0) is being set in the constructor
        //when objectA is created
        this.objectB = objectB;
    }

    public static void main(String[] args) {
        //this constructor would probably actually be called from somewhere else.
	    ObjectA objectA = new ObjectA(new ObjectB(0));
	    objectA.run();
    }

    private void run(){
        //This will print from the first ObjectB from the
        objectB.printSomeString("Hi there!");

        //now we'll create another new ObjectB with a different index.
        //this is just an instance variable so it will disappear once the run() method ends.
        ObjectB anotherObjectB = new ObjectB(1);
        anotherObjectB.printSomeString("Nice to meet you!");

        //now we'll get another object by having it passed as a
        //return from a method in some other object
        ObjectC objectC = objectB.getObjectC();

        //now we'll use objectB to print some data from objectC
        objectB.printSomeString("the property of objectC is: " + objectC.getMyStringProperty());

        //now we'll use a setter to set a property in objectC
        objectC.setMyStringProperty("something else");

        //now we'll print the same thing again with the new property
        objectB.printSomeString("the property of objectC is: " + objectC.getMyStringProperty());

    }

}

class ObjectB{
    private final int index;

    //objectC is a property variable of objectB
    private ObjectC objectC;

    public ObjectB(int index){
        this.index = index;
        this.objectC = new ObjectC();
    }

    public void printSomeString(String str) {
        System.out.println("My index is " + index +" and I was passed the string: " + str);
    }

    /**
     *
     * @return the objectC property
     */
    public ObjectC getObjectC() {
        return objectC;
    }
}

class ObjectC{
    private String myStringProperty;
    public ObjectC(){
        myStringProperty = "default";
    }

    /**
     *
     * @return myStringProperty of ObjectC
     */
    public String getMyStringProperty() {
        return myStringProperty;
    }

    /**
     *
     * @param myStringProperty will become myStringProperty
     */
    public void setMyStringProperty(String myStringProperty) {
        this.myStringProperty = myStringProperty;
    }
}