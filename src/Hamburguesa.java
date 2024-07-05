import java.util.List;

class Hamburguesa {
    private List<Ingrediente> ingredientes;
    private List<Extra> extras;
    private List<Pan> panes;
    private Carne carne;
    private int extrasAgregados;


    public Hamburguesa(Pan panSuperior, Pan panInferior, Carne carne, int numeroExtras) {
        this.panes = List.of(panSuperior, panInferior);
        this.carne = carne;
        this.extras = List.of(new Extra[numeroExtras]);
        this.extrasAgregados = 0;
    }

    public void agregarExtra(Extra extra) {
        if (extrasAgregados < extras.size()) {
            extras.add(extra);
            extrasAgregados++;
        }
    }
    public void eliminarExtra(Extra extra) {
        for (int i = 0; i < extrasAgregados; i++) {
            if (extras.get(i).equals(extra)) {
                extras.remove(i);
                extrasAgregados--;
                break;
            }
        }
    }
    public void cambiarCarne(Carne carne) {
        this.carne = carne;
    }
    public void cambiarPanSuperior(Pan pan) {
        panes.set(0, pan);
    }
    public void cambiarPanInferior(Pan pan) {
        panes.set(1, pan);
    }
    public void cambiarExtra(Extra extraViejo, Extra extraNuevo) {
        for (int i = 0; i < extrasAgregados; i++) {
            if (extras.get(i).equals(extraViejo)) {
                extras.set(i, extraNuevo);
                break;
            }
        }
    }
    public void quitaPanIntermedio(panInter pan) {
        for (int i = 0; i < extrasAgregados; i++) {
            if (extras.get(i).equals(pan)) {
                extras.remove(i);
                ;
                break;
            }
        }
    }
    public void quitaCarne(Carne carne) {
        if (this.carne.equals(carne)) {
            this.carne = null;
        }
    }
    public void agregarExtrasPosicion(int posicion, Extra extra) {
        if (posicion < extrasAgregados) {
            extras.add(posicion, extra);
            extrasAgregados++;
        }
    }
    public void moverExtra(int posicion, int nuevaPosicion) {
        if (posicion < extrasAgregados && nuevaPosicion < extrasAgregados) {
            Extra extra = extras.get(posicion);
            extras.remove(posicion);
            extras.add(nuevaPosicion, extra);
        }
    }
    public void agragapanesPosicion(int posicion, panInter pan) {
        if (posicion < extras.size()) {
            extras.add(posicion, pan);
        }
    }
    public void agregarCarnePosicion(int posicion, Carne carne) {
        if (posicion < extras.size()) {
            this.carne = carne;
        }
    }

    public void mostrar() {
        panes.get(0).mostrar();
        carne.mostrar();
        for (int i = 0; i < extrasAgregados; i++) {
            extras.get(i).mostrar();
        }
        panes.get(1).mostrar();
    }

    public String describir() {
        String descripcion;
        if (carne == null) {
            descripcion = panes.get(0).describir() + ", " + panes.get(1).describir();
            for (int i = 0; i < extrasAgregados; i++) {
                descripcion = descripcion + ", " + extras.get(i).describir();
            }
            descripcion = descripcion + "\n";
            return descripcion;
        } else {
            descripcion = panes.get(0).describir() + ", " + carne.describir();
            for (int i = 0; i < extrasAgregados; i++) {
                descripcion = descripcion + ", " + extras.get(i).describir();
            }
            descripcion = descripcion + "\n";
            return descripcion;
        }
    }
}
