package br.com.sys.interfaces;

public interface IService<T> {
	public void add(T entity);
	
	public void remove(T entity);
	
	public int getTotalItens();
}
