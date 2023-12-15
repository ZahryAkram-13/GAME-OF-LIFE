package observer;

public interface ListenableModel {
	
	public void addListener(ModelListener listener);
	public void removeListener(ModelListener listener);

}
