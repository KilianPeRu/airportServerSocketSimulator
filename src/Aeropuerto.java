import java.io.Serializable;

public class Aeropuerto implements Serializable {

    int id;
    String origen;
    String destino;
    String horaLlegada;
    String horaSalida;

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "id=" + id +
                ", origen='" + origen + '\'' +
                ", destino='" + destino + '\'' +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Aeropuerto(int id, String origen, String destino, String horaLlegada, String horaSalida) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
    }
}
