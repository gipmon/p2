/* Rafael Ferreira */
class RadioStationInfo {
  private String name = null;
  private double frequency;

  public RadioStationInfo(String nomeRDS, double frequenciaFM) {
    this.name = nomeRDS;
    this.frequency = frequenciaFM;
  }

  public String name() {
    return name;
  }

  public double frequency() {
    return frequency;
  }
}

public class FmRadioSet {

  private int volume = 7; // starts with default volume level 7
  private RadioStationInfo currentStation = null;

  static private RadioStationInfo[] listOfKnownStations = new RadioStationInfo[0];

  /**
   * tunes the radio using the intended station name
   */
  public void tune(String name) {
    boolean found = false;
    int i = 0;
    while (!found && i < listOfKnownStations.length) {
      found = listOfKnownStations[i].name().equalsIgnoreCase(name);
      i++;
    }
    if (found)
      currentStation = listOfKnownStations[i - 1];
  }

  /**
   * tunes the radio using the intended station frequency
   */
  public void tune(double frequency) {
    boolean found = false;
    int i = 0;
    while (!found && i < listOfKnownStations.length) {
      found = listOfKnownStations[i].frequency() == frequency;
      i++;
    }
    if (found)
      currentStation = listOfKnownStations[i - 1];
  }

  public static void addStationInfo (RadioStationInfo station) {
    RadioStationInfo[] newList = new RadioStationInfo[listOfKnownStations.length + 1];
    System.arraycopy(listOfKnownStations, 0, newList, 0,
        listOfKnownStations.length);
    newList[listOfKnownStations.length] = station;
    listOfKnownStations = newList;
  }

  public void turnDownVolume() {
    volume--;
  }

  public void turnUpVolume() {
    volume++;
  }

  public String currentPlayingStation() {
    if (currentStation == null) {
      return null;
    } else
      return currentStation.name();
  }

  public int currentVolume() {
    return this.volume;
  }
  public static void main(String[] args) {

    FmRadioSet.addStationInfo(new RadioStationInfo("TSF", 105.3));
    FmRadioSet.addStationInfo(new RadioStationInfo("Comercial", 97.7));
    FmRadioSet.addStationInfo(new RadioStationInfo("Kiss", 88.8));

    FmRadioSet casio = new FmRadioSet(), 
               pionner = new FmRadioSet(), 
               sony = new FmRadioSet();

    casio.tune(97.7);
    casio.turnDownVolume();

    pionner.tune("TSF");

    sony.tune(casio.currentPlayingStation());
    sony.turnUpVolume();

    System.out.printf( "%s %d\n", casio.currentPlayingStation(), casio.currentVolume());
    System.out.printf( "%s %d\n", pionner.currentPlayingStation(), pionner.currentVolume());
    System.out.printf( "%s %d\n", sony.currentPlayingStation(), sony.currentVolume());

    casio.turnDownVolume();
    casio.tune(pionner.currentPlayingStation());
    System.out.printf( "%s %d\n", casio.currentPlayingStation(), casio.currentVolume());
    System.out.printf( "%s %d\n", pionner.currentPlayingStation(), pionner.currentVolume());
  }
}
/* 
 ---- INDIQUE QUAL O RESULTADO APRESENTADO PELO PROGRAMA NO ECRÃ ----
 Primeiro temos que nos focar nas operações da main que está definida no final do programa.
 * Em primeiro lugar são definidas as informações sobre as radio stations TSF com a freq 105.3;
 a Comercial com a freq 97.7 e a radio station Kiss com a freq 88.8.
 * Depois vamos fazer o setup dos diferentes rádios. Primeiro criamos o Casio, depois o da Pioneer
 e de seguida o da Sony.
 * Colocamos o casio na frequencia 97.7 com a funação casio.tune(); e depois baixamos o volume com 
 a função casio.turnDownVolume();  De seguida colocamos o rádio da pioneer na TSF com a função pioneer.tune(String a); ficando este conectado na frequencia 105.3;
 * Por seguinte colucamos o sony  na mesma rádio do da casio que é dado pela função casio.currentPlayingStation(); e baixamos-lhe o volume.
 * Portanto o casio está na 97.7 - Comercial com o volume 6 (na inicialização das rádios o volume é definido 
 inicialmente a 7; O pioneer está na TSF 105.3 e com o volume a 7; O sony está na 97.7 Comercial e está com o volume a 8
 * Portanto os primeiros outputs são:
 Comercial 6
 TSF 7
 Comercial 8
 Após isso são feitas duas modificações, o casio baixa o volume e passa a estar na radio do da pioneer sendo  TSF 5 o final;
 Portanto as últimas duas outputs são:
 TSF 5
 TSF 7
 */
