package controllers;
import java.awt.Component;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

public class ComponentSerializer {
	
  public void write(Component comp, OutputStream out) throws IOException {
	  
    System.out.println("writing " + comp);
    ObjectOutputStream oout = new ObjectOutputStream(out);
    oout.writeObject(new ComponentEncapsulator(comp));
    oout.reset();
    oout.flush();
  }
  
  public Component read(InputStream in) throws IOException, ClassNotFoundException {
	  
    ObjectInputStream oin = new ObjectInputStream(in);
    
    ComponentEncapsulator enc = (ComponentEncapsulator)oin.readObject();
    
    return enc.getComponent();
  }
  
  
  private class ComponentEncapsulator implements Serializable {
	  
	private static final long serialVersionUID = -2570883859139673450L;
	private final Component comp;
    
    public ComponentEncapsulator(Component comp) {
      this.comp = comp;
    }
    public Component getComponent() {
      return comp;
    }
    
    private IOException defaultWriteException;
    
    private void writeObject(final ObjectOutputStream out) throws IOException {
    	
      if(SwingUtilities.isEventDispatchThread()) {
      } 
      else {
    	  
        try {
        	
          SwingUtilities.invokeAndWait(new Runnable() {
            public void run() {
              try {
            	  
                defaultWriteException = null;
                out.defaultWriteObject();
              } catch(IOException ex) {

                defaultWriteException = ex;
              }
            }
          });
          
          if(defaultWriteException != null) {

            throw defaultWriteException;
          }
        } catch(InterruptedException ex) {

          Thread.currentThread().interrupt();
          return;
        } catch(InvocationTargetException ex) {

          Throwable target = ex.getTargetException();
          
          if (target instanceof RuntimeException) {
        	  
            throw (RuntimeException)target;
          } 
          else if (target instanceof Error) {
        	  
            throw (Error)target;
          }
          ex.printStackTrace();
          throw new RuntimeException(ex.toString());
        }
      }
    }
  }
}