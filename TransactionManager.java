//TransactionManager.java is implemented by classes that manage persistent data
public interface TransactionManager {
	Object find(String s)throws NullPointerException;
	void update(Object o);
	void add(Object o);
	void save(Object o);
}
