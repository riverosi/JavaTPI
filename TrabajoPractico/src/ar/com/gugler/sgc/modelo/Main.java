package ar.com.gugler.sgc.modelo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		var alumno1 = new Alumno("39539138", "Riveros", "Ignacio");
		alumno1.setLegajo("12346");
		var alumno2 = new Alumno("39539138", "Riveros", "Ignacio");
		alumno2.setLegajo("12345");
		var profesor1 = new Profesor("39539138", "Pita", "Gustavo de Dios");
		profesor1.setCuil("206584001");
		
		
		if (alumno1.equals(alumno2)) {
			System.out.println(alumno1.mostrarInformacion());
		}
		else {
			System.out.println("los alumnos no son iguales");
		}
		
		
		System.out.println(profesor1.mostrarInformacion());
		System.out.println(profesor1.toString());
		
		
		var cursoJava = new Curso(123);
		
		cursoJava.agregarAlumno(alumno1);
		cursoJava.agregarAlumno(alumno2);
		cursoJava.eliminarAlumno(alumno2);
		
		System.out.println( cursoJava.getAlumnos().size() );		
		
	}

}
