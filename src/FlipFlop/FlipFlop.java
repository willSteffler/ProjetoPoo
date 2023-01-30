/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FlipFlop;

/**
 *
 * @author William
 */
public abstract class FlipFlop {
    
    protected boolean saidaQ;
    protected boolean saidaQN;

    public boolean isSaidaQ() {
        return saidaQ;
    }

    public boolean isSaidaQN() {
        return saidaQN;
    }
    
    abstract public boolean estadoFlipFlop();
}
