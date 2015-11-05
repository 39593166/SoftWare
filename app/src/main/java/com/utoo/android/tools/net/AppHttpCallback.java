package com.utoo.android.tools.net;

import com.android.volley.VolleyError;

public interface AppHttpCallback {
	void NetFailed(VolleyError error);

	void onReturned(String response);
}
