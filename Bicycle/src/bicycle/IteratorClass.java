package bicycle;

 class IteratorClass implements Iterator{
    private final int size;
     private int nextIndex;

    private final Bicycle[] bicycles;

    public IteratorClass(Bicycle[] bicycles, int size){
        this.bicycles = bicycles;
        this.size = size;
        init();
    }
    @Override
    public boolean hasNext() {
        return nextIndex < size;
    }

    @Override
    public Bicycle next() {
        return bicycles[nextIndex++];
    }

     @Override
     public void init() {
         this.nextIndex = 0;
     }
 }
