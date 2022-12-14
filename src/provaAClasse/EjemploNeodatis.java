package provaAClasse;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class EjemploNeodatis {

	public static void main(String[] args) {
		
		Jugadores j1 = new Jugadores("Maria","Voleibol","Madrid",15);
		Jugadores j2 = new Jugadores("Miguel","Tennis","Barcelona",15);
		Jugadores j3 = new Jugadores("Mario","Baloncesto","Alcover",15);
		Jugadores j4 = new Jugadores("Alicia","Tennis","Valls",15);

		ODB odb = ODBFactory.open("neodatis.test");
		
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
		System.out.println(objects.size() + "Jugadores:");
		
		int i=1;
		
		while(objects.hasNext()) {
			Jugadores jug = objects.next();
			System.out.println((i++) + "\t: " + jug.getNombre() + "*" + jug.getDeporte() + "*" + jug.getCiudad() + "*" + jug.getEdad());
		}
		
		odb.close();
		
	}

}
