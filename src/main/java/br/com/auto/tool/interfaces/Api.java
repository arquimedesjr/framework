package br.com.auto.tool.interfaces;

public interface Api {
	
	public void setUp(String url);
	
	public void post(String pathJson);
	
	public String get();
	
	public void delete();
	
	public void update(String pathJson);
	
	public void validacion(String key, String value);
	

}
