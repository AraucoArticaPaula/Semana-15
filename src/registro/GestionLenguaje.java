package registro;

public class GestionLenguaje {
    private LenguajeProgramacion[] arregloLenguajes;
    private int contadorLenguajes;
    private static final int FACTOR_CRECIMIENTO = 5;

    public GestionLenguaje() {
        arregloLenguajes = new LenguajeProgramacion[FACTOR_CRECIMIENTO];
        contadorLenguajes = 0;
    }
    public void agregarLenguaje(int anioCreacion, String 
            caracteristicaPrincipal, String nombre, String utilizacion) {
        if (contadorLenguajes == arregloLenguajes.length) {
            aumentarCapacidad();
        }
        LenguajeProgramacion nuevoLenguaje = new LenguajeProgramacion
        (anioCreacion, caracteristicaPrincipal, nombre, utilizacion);
        arregloLenguajes[contadorLenguajes++] = nuevoLenguaje;
    }
    private void aumentarCapacidad() {
        LenguajeProgramacion[] nuevoArreglo = new LenguajeProgramacion[arregloLenguajes.length + FACTOR_CRECIMIENTO];
        System.arraycopy(arregloLenguajes, 0, nuevoArreglo, 0, arregloLenguajes.length);
        arregloLenguajes = nuevoArreglo;
    }
    public LenguajeProgramacion buscarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equals(nombre)) {
                return arregloLenguajes[i];
            }
        }
        return null;
    }
    public boolean eliminarLenguaje(String nombre) {
        for (int i = 0; i < contadorLenguajes; i++) {
            if (arregloLenguajes[i].getNombre().equals(nombre)) {
                for (int j = i; j < contadorLenguajes - 1; j++) {
                    arregloLenguajes[j] = arregloLenguajes[j + 1];
                }
                arregloLenguajes[--contadorLenguajes] = null;
                return true;
            }
        }
        return false;
    }
    public void imprimirLenguajes() {
        for (int i = 0; i < contadorLenguajes; i++) {
            System.out.println(arregloLenguajes[i]);
        }
    }
}
