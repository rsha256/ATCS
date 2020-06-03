package coinCollection;

public class Coin {

	private int yr;
	private String coin;

	public Coin() {
		yr = 0;
		coin = "";
	}

	public Coin(int yr, String coin) {
		this.yr = yr;
		this.coin = coin;
	}

	public String getCoin() {
		return coin;
	}

	public int getYr() {
		return yr;
	}

	public void setYr(int yr) {
		this.yr = yr;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	@Override
	public String toString() {
		return this.yr + ", " + this.coin;
	}

	public boolean equals(Coin obj) {
		return ((obj.yr / 10) == (this.yr / 10)) && (obj.getCoin().equals(this.coin));
	}

}
