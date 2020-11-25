package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class Autopista implements Imultable{
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telapase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	private TreeSet <Vehiculo> vehiculosEnInfraccion;
	private String nombre;
	private Integer cantidadDeVehiculosEnCirculacion;
	
	
	public Autopista(String nombre) {
		this.nombre=nombre;
		this.telapase= new HashMap<Integer,Vehiculo>();
		this.vehiculosEnCirculacion= new HashSet<Vehiculo>();
		
	}
	
	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		
		if(!telapase.containsKey(numeroTelpase) && !telapase.containsValue(vehiculo)) {
	        telapase.put(numeroTelpase, vehiculo);
	        return true;
	        }else {
	        return false;
	        }
		
	}
	public Boolean ingresarAutopista (Integer numeroTelepase) throws Exception{
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	   // y no permite ingresar al autopista
		Boolean ingreso = false;
        if (!telapase.containsKey(numeroTelepase)) {
            throw new Exception();
        }else {
            ingreso = true;
            vehiculosEnCirculacion.add(telapase.get(numeroTelepase));
            this.cantidadDeVehiculosEnCirculacion++;
        }

        return ingreso;
    }
	
		
		
	
	
	public void salirAutpista (Vehiculo vehiculo) throws  Exception{
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		  if(telapase.containsValue(vehiculo))
			  vehiculosEnCirculacion.remove(vehiculo);
		      this.cantidadDeVehiculosEnCirculacion--;

	        throw new Exception();
		
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		Patente ordenadar = new Patente();
        TreeSet<Vehiculo> vehiculosPorPatente = new TreeSet<Vehiculo>(ordenadar);
        vehiculosPorPatente.addAll(vehiculosEnInfraccion);


    return vehiculosPorPatente;
	
	
    }

	public Integer cantidadDeVehiculosENCirculacion() {
		Integer cantidad=this.cantidadDeVehiculosEnCirculacion;
	
		return cantidad;
}

	@Override
	public Boolean enInfraccion() {
		// TODO Auto-generated method stub
		for (Vehiculo vehiculo : vehiculosEnCirculacion) {
            if (vehiculo instanceof Automovil && vehiculo.getVelocidadActual()>vehiculo.getLimiteVelocidad()) {
                vehiculosEnInfraccion.add(vehiculo);
                return true;
            }else if (vehiculo instanceof Camion && vehiculo.getVelocidadActual()>vehiculo.getLimiteVelocidad() ) {
                vehiculosEnInfraccion.add(vehiculo);
                return true;
            }
        }
        return false;
    }

}

