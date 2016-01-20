/* Rafael Ferreira */
public class Switch {

  private Switch ports[];

  Switch ( int nrPorts )  { 
    assert nrPorts > 0 : "Invalid number of ports for a switch";

    ports = new Switch[nrPorts];
  }

  public int freePort ()  { 
    assert freePorts() != 0 : "No free ports";

    int port = -1;

    for (int i = 0; i < ports.length; i++) {
      if (ports[i] == null) {
        port = i;
        break;
      }
    }

    assert port >= 0 && port < ports.length : "Internal error";
    return port;
  }

  public int freePorts ()  { 
    int result = 0;

    for (int i = 0; i < ports.length; i++) {
      if (ports[i] == null) {
        result++;
      }
    }

    return result;
  }

  public boolean connect ( Switch s )  { 
    assert s!=null : "Invalid argument";
    assert s!=this : "Switches should not connect to themselves";

    if (freePorts() == 0 || s.ports() == 0) {
      return false;
    }

    int totalFreePorts = freePorts() + s.freePorts();

    ports[freePort()] = s;

    s.ports[s.freePort()] = this;

    assert totalFreePorts-2 == freePorts() + s.freePorts() : "Internal error";

    return true;
  } 

} 
