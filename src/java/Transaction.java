public interface Transaction{
	public abstract PatronAccount getPatronAccount();

	public abstract long getTime();

	public abstract int getId();

	public abstract int getStatus();

	public abstract void resolve();
}
