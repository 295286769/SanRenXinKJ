package com.srx.huangweishui.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkUtils {

	/**
	 * @param context
	 * @param networkType
	 * @return is network state on
	 */
	private static boolean isNetworkConnected(Context context, int... networkType) {
		ConnectivityManager connManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo networkInfo;
		if (networkType.length == 0) {
			networkInfo = connManager.getActiveNetworkInfo();
		} else {
			networkInfo = connManager.getNetworkInfo(networkType[0]);
		}
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}

	public static boolean isNetworkOn(Context context) {
		return isNetworkConnected(context);
	}

	public static boolean isWifiOn(Context context) {
		return isNetworkConnected(context, ConnectivityManager.TYPE_WIFI);
	}

	public static boolean isMobileOn(Context context) {
		return isNetworkConnected(context, ConnectivityManager.TYPE_MOBILE);
	}
}
