package BubbleGame;

public interface Moveable {
	
	public abstract void left();
	public abstract void right();
	public abstract void up();
	default void down() {};
}
