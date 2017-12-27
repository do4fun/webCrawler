package com.publiciteweb.webcrawler.multithreads;

import com.publiciteweb.webcrawler.Engine;

public class EngineRunnable extends Thread
{
	Engine engine;

	public EngineRunnable( Engine engine )
	{
		this.engine = engine;
	}

	public void run()
	{
		engine.search();
	}

}
