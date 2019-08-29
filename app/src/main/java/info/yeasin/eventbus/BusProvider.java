package info.yeasin.eventbus;

import org.greenrobot.eventbus.EventBus;

public class BusProvider {
	private static EventBus sBus;

	public static EventBus getBus() {
		if (sBus == null)
			sBus = EventBus.getDefault();
		return sBus;
	}
}
