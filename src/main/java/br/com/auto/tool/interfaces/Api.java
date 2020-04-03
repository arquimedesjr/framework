package br.com.auto.tool.interfaces;

public interface Api {
	
	public void setUp(String url);
	
	public void post(String pathJson);
	
	public void get();
	
	public void delete();
	
	public void update();
	

}
