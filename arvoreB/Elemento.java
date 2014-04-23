package arvoreB;

public class Elemento
{

	int	elemento;

	public Elemento(int elemento)
	{
		setElemento(elemento);

	}

	public int getElemento()
	{
		return elemento;
	}

	public void setElemento(int elemento)
	{
		this.elemento = elemento;
	}

	public int compareTo(Elemento e)
	{
		if (e.getElemento() > this.getElemento())
		{
			return 1;
		} else if (e.getElemento() < this.getElemento())
		{
			return -1;
		} else
		{
			return 0;
		}
	}

	@Override
	public String toString()
	{

		return "" + getElemento();
	}

}
