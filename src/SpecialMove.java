public interface SpecialMove {
    public void UseSpecialMove();
    // special move is an interface instead of a method of combatant because some classes dont have special moves such as the skeleton or dummy, so making them define one wouldnt work.
}