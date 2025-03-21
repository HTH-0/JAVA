package Ch14;

public class Won2Euro extends Converter{
	public Won2Euro(double ratio) {
		this.ratio = ratio;
	}
	@Override
	protected double convert(double src) {
		return src/ratio;
	}
	@Override
	protected String getSrcString() {
		return "원";
	}
	@Override
	protected String getDestString() {
		return "유로";
	}
}
