package provaAClasse;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Exemple {

	public static void main(String[] args) {
		
		ODB odb = ODBFactory.open("neodatis.test");
		IQuery query = new CriteriaQuery(Jugadores.class, Where.equal("edad", 15));
		query.orderByAsc("nombre,edad");
		
		Objects<Jugadores> objects = odb.getObjects(query);
		
		Jugadores jug = (Jugadores) odb.getObjects(query).getFirst();
		
		System.out.println(jug.getNombre() + " - " + jug.getEdad() );
		
		odb.close();
	}

}
