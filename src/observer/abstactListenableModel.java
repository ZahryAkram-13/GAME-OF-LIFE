package observer;

import java.util.ArrayList;
import java.util.List;

public class abstactListenableModel implements ListenableModel{
	
	private List<ModelListener> listeners = new ArrayList<>();

	@Override
	public void addListener(ModelListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(ModelListener listener) {
		this.listeners.remove(listener);
	}
	
	public void notifyListeners() {
		this.listeners.forEach(listener ->{
			listener.update(this);
		});
	}

	public List<ModelListener> getListeners() {
		return listeners;
	}

	public void setListeners(List<ModelListener> listeners) {
		this.listeners = listeners;
	}
	
	

}
