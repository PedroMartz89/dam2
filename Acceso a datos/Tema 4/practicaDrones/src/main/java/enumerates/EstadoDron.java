package enumerates;

public enum EstadoDron {
    disponible("Disponible"),
    en_mision("En mision"),
    fuera_de_servicio("Fuera de servicio");

    EstadoDron(String nombreLegible){this.nombreLegible = nombreLegible;}
    private String nombreLegible;
}
