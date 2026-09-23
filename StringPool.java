public class StringPool {
    private String[] stringPool; // array of references, each one points to its own string
    private int currentSize;
    private int maxSize;

    // constructor - sets everything up empty
    public StringPool() {
        maxSize = 5;
        currentSize = 0;
        stringPool = new String[maxSize]; // array to hold 5 references

        for (int i = 0; i < maxSize; i++) {
            stringPool[i] = null; // nothing stored yet
        }
    }

    // adds a string to the next empty slot
    public void addString(String value) {
        if (currentSize >= maxSize) {
            System.out.println("Pool full!");
            return;
        }
        stringPool[currentSize] = value; // store the string reference
        currentSize++;
    }

    // removes a string reference from the pool
    // NOTE: in Java this doesn't cause a true memory leak the way it does in C++ -
    // Java's garbage collector automatically reclaims memory once nothing
    // references an object anymore. This method is kept to mirror the C++
    // version's structure and demonstrate the concept.
    public void removeString(int index) {
        stringPool[index] = null; // dropping the reference; GC handles the rest
        // note: not shifting other elements here to keep things simple,
        // this slot just becomes empty/unused
    }

    // in Java there's no separate "fixed" version needed since there's no
    // manual delete - but kept here to mirror the C++ structure for comparison
    public void removeStringFixed(int index) {
        stringPool[index] = null; // same effect - GC reclaims memory automatically
    }

    // shows what's currently in the pool
    public void displayPool() {
        StringBuilder sb = new StringBuilder("Pool contents: ");
        for (int i = 0; i < maxSize; i++) {
            if (stringPool[i] != null) {
                sb.append(stringPool[i]).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        StringPool pool = new StringPool();

        pool.addString("Gujjar");
        pool.addString("Chachu");
        pool.addString("Chapri");

        System.out.println("##################################");
        System.out.println("After adding strings:");
        pool.displayPool();

        // removing index 1 - in C++ this leaked memory, in Java the GC
        // reclaims it automatically once nothing references it anymore
        pool.removeString(1);
        System.out.println("\nAfter removal:");
        pool.displayPool();

        // removing index 2
        pool.removeStringFixed(2);
        System.out.println("\nAfter fixed removal:");
        pool.displayPool();
        System.out.println("##################################");
    }
}
