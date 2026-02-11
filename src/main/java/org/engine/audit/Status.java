public enum Status {
    INFO(1),
    ALERTA(2),
    CRITICO(3);

    private final int nivel;

    Status(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }
}

