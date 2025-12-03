public class Contacto
{
    private int id;
    private string nombre;
    private int telefono;

    // Constructor por defecto
    public Contacto()
    {
    }

    // Constructor parametrizado
    public Contacto(int id, string nombre, int telefono)
    {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int Id
    {
        get { return id; }
        set { id = value; }
    }

    public string Nombre
    {
        get { return nombre; }
        set { nombre = value; }
    }

    public int Telefono
    {
        get { return telefono; }
        set { telefono = value; }
    }

    public override string ToString()
    {
        return "ID: " + id + ", Nombre: " + nombre + ", Teléfono: " + telefono;
    }
}