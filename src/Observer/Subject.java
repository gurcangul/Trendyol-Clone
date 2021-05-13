package Observer;

public interface Subject{
    public void attach(Observer arg);
    public void detach(Observer arg);
    public void notifyUpdate(Object arg);

}