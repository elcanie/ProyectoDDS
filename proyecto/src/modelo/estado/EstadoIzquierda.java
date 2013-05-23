package modelo.estado;

import modelo.personajes.Bala;
import modelo.personajes.EntidadDinamica;


public class EstadoIzquierda implements Estado{
	private EntidadDinamica entidad;
	private float acumulado;
	public EstadoIzquierda(EntidadDinamica entidad){
		this.entidad=entidad;
		acumulado = 0;
	}
	@Override
	public void actualizarTextura(float time) {
		acumulado += time;
		entidad.setTextura(entidad.getAnimIzquierda().getKeyFrame(acumulado,entidad.esAnimacionLoop()));
	}
	@Override
	public void mover(float vx) {
		if(vx>0) entidad.setEstado(new EstadoDerecha(entidad));
		else if(vx==0) entidad.setEstado(new EstadoReposo(entidad));
	}
	@Override
	public void colisionar() {
		if(entidad.getVida()<=0){
			entidad.setEstado(new EstadoExplosion(entidad));
			entidad.eliminarColega();
			}
	}
	
}
