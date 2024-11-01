package thread.collection.simple.list;

public class SyncProxyList implements SimpleList {

    SimpleList target;

    public SyncProxyList(SimpleList target) {
        this.target = target;
    }

    @Override
    public synchronized int size() {
        return target.size();
    }

    @Override
    public synchronized void add(Object e) {
        target.add(e);
    }

    @Override
    public synchronized Object get(int index) {
        return target.get(index);
    }

    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] " + target.toString();
    }
}
