package arcade.model;

/**
 * @author AYCM
 */
public class Speech {

    private int id_speech;
    private String speech;
    private int id_nivel;
    private String nivel;

    public Speech() {
    }

    public int getId_speech() {
        return id_speech;
    }

    public void setId_speech(int id_speech) {
        this.id_speech = id_speech;
    }

    public String getSpeech() {
        return speech;
    }

    public void setSpeech(String speech) {
        this.speech = speech;
    }

    public int getId_nivel() {
        return id_nivel;
    }

    public void setId_nivel(int id_nivel) {
        this.id_nivel = id_nivel;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

}
