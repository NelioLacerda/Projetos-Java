package Iterators;

import Bill.Bill;

/**
 * @author Nélio Lacerda
 */
public class BillIteratorClass implements BillIterator {
    private Bill[] bills;
    private int size, nextIndex;

    public BillIteratorClass(Bill[] bills, int size){
        this.bills = bills;
        this.size = size;
        this.nextIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return nextIndex < size;
    }

    @Override
    public Bill next() {
        return bills[nextIndex++];
    }
}
