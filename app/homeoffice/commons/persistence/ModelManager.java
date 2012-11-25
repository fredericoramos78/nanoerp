/**
 * 
 */
package homeoffice.commons.persistence;

import play.db.jpa.JPA;

/**
 * @author framos
 *
 */
public class ModelManager {

	
	private static ThreadLocal<ModelManager> singleton;
	
	
	
	private ModelManager() {
	}
	
	
	public static ModelManager getInstance() {
		if ((singleton == null) || (singleton.get() == null)) {
			singleton.set(new ModelManager());
		}
		return singleton.get();
	}
	
	
	/**
	 * Executes the INSERT SQL operation into the database.
	 */
	public void insert(Object _entity) {
		JPA.em().persist(_entity);
	}

	/**
	 * Executes the DELETE SQL operation into the database.
	 */
	public void delete(Object _entity) {
		JPA.em().remove(_entity);
	}
}
