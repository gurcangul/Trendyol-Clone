package Observer;

public interface ISubject{
    public void attach(IObserver o);
    public void detach(IObserver o);
    public void notifyUpdate(Object arg);

}