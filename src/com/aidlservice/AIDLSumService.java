package com.aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class AIDLSumService extends Service {

	private static final long mSleepInterval = 1000L;
	private String TAG = "AIDLSumService";
	
	public class SumServiceImpl extends ISumService.Stub {

		@Override
		public long fibonacciSum(long n) throws RemoteException {
			Log.v(TAG  , "fibonacciSum() value of N: "+ n);
			return AIDLSumService.this.fibonacciSum(n);
		}
	}

	@Override
	public void onCreate() {
		Log.i(TAG  , "onCreate()");
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		super.onStartCommand(intent, flags, startId);
		Log.i(TAG  , "onStartCommand()");
		return Service.BIND_AUTO_CREATE;
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		Log.i(TAG  , "onBind()");
		return new SumServiceImpl();
	}

	public long fibonacciSum(long n){
		Log.v(TAG  , "fibonacciSum() N: "+ n);
		if(n == 0)
	        return 0;
	    else if(n == 1)
	      return 1;
	   else
	      return fibonacciSum(n - 1) + fibonacciSum(n - 2);
	}
	
}
