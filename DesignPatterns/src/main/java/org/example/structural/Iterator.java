package org.example.structural;

interface IteratorDemo{
    public boolean hasNext();
    public Object next();
}

interface Container{
    public IteratorDemo getIterator();
}

class NamesCollection implements Container {
    public String name[] = {"Aman", "Deepanshu", "Abhi", "Kamal", "Manan"};

    @Override
    public IteratorDemo getIterator() {
        return new IterateNamesCollection();
    }


    private class IterateNamesCollection implements IteratorDemo {
        int i;

        @Override
        public boolean hasNext() {
            if (i < name.length)
                return true;
            else
                return false;
        }

        @Override
        public Object next() {
            if (this.hasNext())
                return name[i++];
            else
                return null;
        }
    }
}
public class Iterator {
    public static void main(String[] args) {
        NamesCollection repository = new NamesCollection();

        for(IteratorDemo iter = repository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("NAME : "+name);
        }
    }
}
