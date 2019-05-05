package com.website.action;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;

public class PushletController {

	static public class HelloPushlet extends EventPullSource {
		
		// 休眠五秒
		@Override
		protected long getSleepTime() {
			return 5000;
		}

		@Override
		protected Event pullEvent() {
			Event event = Event.createDataEvent("/PushletListener/Hello");
			boolean flag = true; // 
			if (flag) {
				event.setField("mess", "Hello, Plushlet!");
			}
			return event;
		}
	}
}
