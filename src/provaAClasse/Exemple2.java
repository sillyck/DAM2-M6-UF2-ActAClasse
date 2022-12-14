package provaAClasse;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Exemple2 {

	public static void main(String[] args) {
		
		ODB odb = ODBFactory.open("neodatis.test");
		CriteriaQuery query = new CriteriaQuery(Jugadores.class, Where.equal("nombre", "Maria"));
		Objects<Jugadores> Objetos = odb.getObjects(query);
		
		Jugadores jug = (Jugadores) Objetos.getFirst();
		jug.setDeporte("vóley-playa");
		odb.store(jug);
		
		odb.close();
	}

}
