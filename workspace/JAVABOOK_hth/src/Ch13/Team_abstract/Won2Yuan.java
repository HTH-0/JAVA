package Ch13.Team_abstract;

public class Won2Yuan extends Converter {
	public void won2Yuan() {
	}

	public Won2Yuan(double ratio) {
		super();
		this.ratio = ratio;
	}

	@Override
	protected double convert(double src) {
		String c = Double.toString(src/ratio);
		int d = c.indexOf(".")+2;
		String e = c.substring(0, d);
		return Double.parseDouble(e);
	}

	@Override
	protected String getSrcString() {
		return "원화";
	}

	@Override
	protected String getDestString() {
		return "위안";
	}

}
