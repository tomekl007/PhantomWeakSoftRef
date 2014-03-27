import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author Tomasz Lelek
 * @since 2014-03-27
 */
public class WeakRef {
    public static void main(String[] args) {
        Counter counter = new Counter(); // strong reference - line 1
        WeakReference<Counter> weakCounter = new WeakReference<Counter>(counter);
        // weak reference
        counter = null; // now Counter object is eligible for garbage collection



        /*Now as soon as you make strong reference counter = null, counter object created on line 1
         becomes eligible for garbage collection; because it doesn't have any more Strong reference
         and Weak reference by reference variable weakCounter can not prevent Counter object from being
         garbage collected.  On the other hand, had this been Soft Reference, Counter object is not garbage collected
         until JVM absolutely needs memory. Soft reference in Java is represented using java.lang.ref.SoftReference
         class. You can use following code to create a SoftReference in Java
          */


        Counter prime = new Counter(); // prime holds a strong reference - line 2
        SoftReference<Counter> soft = new SoftReference<Counter>(prime) ; //soft reference variable has SoftReference to Counter Object created at line 2
        prime = null; // now Counter object is eligible for garbage collection but only be collected when JVM absolutely needs memory


        ReferenceQueue refQueue = new ReferenceQueue(); //reference will be stored in this queue for cleanup
        DigitalCounter digit = new DigitalCounter();
        PhantomReference<DigitalCounter> phantom = new PhantomReference<DigitalCounter>(digit, refQueue);


        System.out.println(refQueue.poll());
        //Read more: http://javarevisited.blogspot.com/2014/03/difference-between-weakreference-vs-softreference-phantom-strong-reference-java.html#ixzz2xAxVjaAm

    }
}
